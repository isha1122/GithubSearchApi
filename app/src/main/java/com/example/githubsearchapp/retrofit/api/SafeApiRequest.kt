package com.example.githubsearchapp.retrofit.api

import com.example.githubsearchapp.retrofit.base.BaseErrors
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.shivichu.gymapp.utils.ApiException
import com.shivichu.gymapp.utils.NoInternetException
import retrofit2.Call


const val GENERIC_ERRROR = "After 3 retries, please contact eCommerce Operations"

abstract class SafeApiRequest {

    suspend fun <T : Any> apiRequest(call: suspend () -> Call<T>): T {

        try {
            val response = call.invoke().execute()
            if (response.isSuccessful) {
                return response.body()!!
            } else {

                val errorObj: BaseErrors
                val error = response.errorBody()?.string()
                val gson =
                    Gson()
                GsonBuilder().setPrettyPrinting().create()
                errorObj = gson.fromJson(error, BaseErrors::class.java)

                throw ApiException(errorObj.errors[0].ErrorDescription)
            }
        } catch (e: NoInternetException) {
            throw NoInternetException(e.message!!)
        } catch (e: ApiException) {
            throw ApiException(e.message!!)
        } catch (e: Exception) {
            throw NoInternetException(GENERIC_ERRROR)
        }
    }

}