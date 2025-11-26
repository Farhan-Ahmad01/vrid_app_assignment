package com.example.vrid_app_assignment.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.vrid_app_assignment.db.AppDatabase
import com.example.vrid_app_assignment.db.BlogPostEntity
import com.example.vrid_app_assignment.repository.BlogRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class BlogViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: BlogRepository

    val blogPosts: StateFlow<List<BlogPostEntity>?>

    init {
        val blogDao = AppDatabase.getDatabase(application).blogDao()
        repository = BlogRepository(blogDao)
        blogPosts = repository.blogPosts.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = null // Use null for initial state
        )
        refreshBlogPosts()
    }

    fun refreshBlogPosts() {
        viewModelScope.launch {
            repository.refreshBlogPosts()
        }
    }
}