package com.example.vrid_app_assignment.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface BlogDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(posts: List<BlogPostEntity>)

    @Query("SELECT * FROM blog_posts")
    fun getAllBlogPosts(): Flow<List<BlogPostEntity>>

    @Query("DELETE FROM blog_posts")
    suspend fun deleteAll()
}