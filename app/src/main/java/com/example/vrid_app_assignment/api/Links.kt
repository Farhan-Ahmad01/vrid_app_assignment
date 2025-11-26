package com.example.vrid_app_assignment.api

data class Links(
    val about: List<About>,
    val author: List<Author>,
    val collection: List<Collection>,
    val curies: List<Cury>,
    val predecessor_version: List<PredecessorVersion>,
    val replies: List<Reply>,
    val self: List<Self>,
    val version_history: List<VersionHistory>,
    val wp_attachment: List<WpAttachment>,
    val wp_featuredmedia: List<WpFeaturedmedia>,
    val wp_term: List<WpTerm>
)