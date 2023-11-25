package com.example.githubsearchapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubsearchapp.repository.MainRespository

class MainViewModel(val repository: MainRespository) : ViewModel() {


    fun getSampleData() : LiveData<String> {
        return repository.getSampleData()
    }

}

