package com.example.vrid_app_assignment.api

data class ImageGeneratorSettings(
    val default_image_id: Int,
    val enabled: Boolean,
    val font: String,
    val template: String
)