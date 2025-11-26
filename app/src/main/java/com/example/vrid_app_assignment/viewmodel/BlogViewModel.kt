package com.example.vrid_app_assignment.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vrid_app_assignment.api.BlogDataModel
import com.example.vrid_app_assignment.repository.BlogRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class BlogViewModel : ViewModel() {

    private val repository = BlogRepository()

    private val _blogPosts = MutableStateFlow<BlogDataModel?>(null)
    val blogPosts: StateFlow<BlogDataModel?> = _blogPosts

    fun fetchBlogPosts() {
        viewModelScope.launch {
            try {
                _blogPosts.value = repository.getBlogPosts(1, 10)
            } catch (e: Exception) {
                // Handle error
            }
        }
    }
}