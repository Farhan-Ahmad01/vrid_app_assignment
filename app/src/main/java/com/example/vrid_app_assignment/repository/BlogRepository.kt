package com.example.vrid_app_assignment.repository

import com.example.vrid_app_assignment.api.BlogDataModelItem
import com.example.vrid_app_assignment.db.BlogDao
import com.example.vrid_app_assignment.db.BlogPostEntity
import com.example.vrid_app_assignment.network.RetrofitInstance
import kotlinx.coroutines.flow.Flow

class BlogRepository(private val blogDao: BlogDao) {

    val blogPosts: Flow<List<BlogPostEntity>> = blogDao.getAllBlogPosts()

    suspend fun refreshBlogPosts() {
        try {
            val blogPosts = RetrofitInstance.api.getBlogPosts(page = 1, perPage = 10)
            blogDao.insertAll(blogPosts.map { it.toEntity() })
        } catch (e: Exception) {
            // Handle network error
        }
    }

    private fun BlogDataModelItem.toEntity(): BlogPostEntity {
        return BlogPostEntity(
            id = this.id,
            title = this.title.rendered,
            author = this.uagb_author_info?.display_name ?: "Unknown Author",
            date = this.date.substringBefore("T"),
            url = this.link,
            imageUrl = this.jetpack_featured_media_url
        )
    }
}