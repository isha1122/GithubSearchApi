package com.example.githubsearchapp.model

import android.annotation.SuppressLint
import com.google.gson.annotations.SerializedName
import java.text.SimpleDateFormat
import java.util.Calendar

class RepoDetailsModel {

    @SerializedName("name")
    var name: String? = null

   /* @SerializedName("date")
    var date: String? = getDateTimeNow()

    @SuppressLint("SimpleDateFormat")
    fun getDateTimeNow(): String {
        val date = Calendar.getInstance().getTime()
        val formatter = SimpleDateFormat("MMM dd yyyy HH:mm")
        return formatter.format(date)
    }*/
}
