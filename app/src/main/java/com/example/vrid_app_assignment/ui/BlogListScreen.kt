package com.example.vrid_app_assignment.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.vrid_app_assignment.api.BlogDataModelItem
import com.example.vrid_app_assignment.viewmodel.BlogViewModel
import java.net.URLEncoder

@Composable
fun BlogListScreen(
    navController: NavController,
    blogViewModel: BlogViewModel = viewModel()
) {
    val blogPosts by blogViewModel.blogPosts.collectAsState()

    LaunchedEffect(Unit) {
        blogViewModel.fetchBlogPosts()
    }

    LazyColumn(contentPadding = PaddingValues(16.dp)) {
        blogPosts?.let {
            items(it) { post ->
                BlogListItem(post = post, onPostClick = {
                    val encodedUrl = URLEncoder.encode(post.link, "UTF-8")
                    navController.navigate("blog_detail/$encodedUrl")
                })
            }
        }
    }
}

@Composable
fun BlogListItem(post: BlogDataModelItem, onPostClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable(onClick = onPostClick),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = post.title.rendered, style = MaterialTheme.typography.headlineSmall)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = post.uagb_author_info?.display_name ?: "Unknown Author",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = post.date.substringBefore("T"),
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Gray
                )
            }
        }
    }
}