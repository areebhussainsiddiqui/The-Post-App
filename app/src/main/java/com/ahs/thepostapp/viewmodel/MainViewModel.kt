package com.ahs.thepostapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ahs.thepostapp.model.Posts
import com.ahs.thepostapp.repository.PostRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: PostRepository) : ViewModel() {
    private val _postLists = MutableLiveData<List<Posts>>()
    val postList: LiveData<List<Posts>>
        get() = _postLists


    fun fetchPosts() {
        try {
            viewModelScope.launch {
                _postLists.postValue(repository.getPost())
            }
        } catch (e: Exception) {
            Log.d("TAG", "getPost: exception  ${e.message}")
            _postLists.postValue(emptyList())
        }
       // return postList
    }
}