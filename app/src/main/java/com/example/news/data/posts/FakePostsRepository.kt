package com.example.news.data.posts

import com.example.news.model.Post
import com.example.news.model.PostFeed
import com.example.news.util.addOrRemove
import kotlinx.coroutines.Delay
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.withContext

class FakePostsRepository: PostsRepository {

    private var requestCount = 0
    private fun shouldRandomlyFail(): Boolean = ++requestCount % 5 == 0

    private val favorites = MutableStateFlow<Set<String>>(setOf())

    override suspend fun getPost(postId: String?): Result<Post> {
         return withContext(Dispatchers.IO){
             val post = posts.allPosts.find{it.id == postId}
             if (post == null){
                 Result.Error(IllegalArgumentException("post not found"))
             }else{
                 Result.Success(post)
             }
         }
    }

    override suspend fun getPostsFeed(): Result<PostFeed> {
         return withContext(Dispatchers.IO){
             delay(800)
             if (shouldRandomlyFail()) {
                 Result.Error(IllegalStateException())
             } else {
                 Result.Success(posts)
             }
         }
    }

    override fun observeFavorites(): Flow<Set<String>> = favorites

    override suspend fun toggleFavorite(postId: String) {
        favorites.update {
            it.addOrRemove(postId)
        }

    }

}
