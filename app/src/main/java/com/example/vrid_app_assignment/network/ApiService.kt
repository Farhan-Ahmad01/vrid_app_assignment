package com.example.vrid_app_assignment.network

import com.example.vrid_app_assignment.api.BlogDataModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("wp/v2/posts")
    suspend fun getBlogPosts(
        @Query("per_page") perPage: Int = 10,
        @Query("page") page: Int = 1
    ): BlogDataModel
}