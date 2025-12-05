package com.example.vrid_app_assignment.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "blog_posts")
data class BlogPostEntity(
    @PrimaryKey
    val id: Int,
    val title: String,
    val author: String,
    val date: String,
    val url: String,
    val imageUrl: String
)