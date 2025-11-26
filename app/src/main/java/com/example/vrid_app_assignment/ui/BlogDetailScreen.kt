package com.example.vrid_app_assignment.ui

import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView
import java.net.URLDecoder

@Composable
fun BlogDetailScreen(blogUrl: String) {
    val decodedUrl = URLDecoder.decode(blogUrl, "UTF-8")
    AndroidView(factory = {
        WebView(it).apply {
            webViewClient = WebViewClient()
            loadUrl(decodedUrl)
        }
    })
}