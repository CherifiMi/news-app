package com.example.news.data.posts

import com.example.news.model.Post
import com.example.news.model.PostFeed
import kotlinx.coroutines.flow.Flow

class FakePostsRepository: PostsRepository {
    override suspend fun getPost(postId: String?): Result<Post> {
        TODO("Not yet implemented")
    }

    override suspend fun getPostsFeed(): Result<PostFeed> {
        TODO("Not yet implemented")
    }

    override fun observeFavorites(): Flow<Set<String>> {
        TODO("Not yet implemented")
    }

    override suspend fun toggleFavorite(postId: String) {
        TODO("Not yet implemented")
    }
}