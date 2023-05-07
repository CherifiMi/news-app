package com.example.news.model

data class PostFeed(
    val highlightedPost: Post,
    val recommendedPost: List<Post>,
    val popularPosts: List<Post>,
    val recentPosts: List<Post>,
){
    val allPosts: List<Post> =
        listOf(highlightedPost) + recommendedPost + popularPosts + recentPosts
}
