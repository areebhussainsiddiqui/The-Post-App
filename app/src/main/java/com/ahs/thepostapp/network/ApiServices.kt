package com.ahs.thepostapp.network

import com.ahs.thepostapp.model.Posts
import retrofit2.http.GET

interface ApiServices {

    @GET("/posts")
    suspend fun getPost():List<Posts>
}