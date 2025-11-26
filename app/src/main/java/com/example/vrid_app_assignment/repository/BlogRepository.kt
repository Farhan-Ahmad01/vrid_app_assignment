package com.example.vrid_app_assignment.repository

import com.example.vrid_app_assignment.network.RetrofitInstance

class BlogRepository {
    suspend fun getBlogPosts(page: Int, perPage: Int) = RetrofitInstance.api.getBlogPosts(page = page, perPage = perPage)
}