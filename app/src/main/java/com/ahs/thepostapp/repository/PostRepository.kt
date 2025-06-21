package com.ahs.thepostapp.repository

import com.ahs.thepostapp.network.ApiServices
import javax.inject.Inject

class PostRepository @Inject constructor(private val apiServices: ApiServices) {

    suspend fun getPost() = apiServices.getPost()
}