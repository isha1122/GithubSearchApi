package com.example.githubsearchapp.repository

import android.os.Handler
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.githubsearchapp.retrofit.api.APIService
import com.fmq.ticketmonitoringsystem.retrofit.BaseRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MainRespository(val apiService: APIService) : BaseRepository() {


    fun getSampleData() : MutableLiveData<String> {

        val result : MutableLiveData<String> = MutableLiveData()

        Handler().postDelayed({
            result.postValue("Shiva")
        },3000)
      return result
    }

}