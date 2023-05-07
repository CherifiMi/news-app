package com.example.news.data

import android.content.Context
import com.example.news.data.interest.FakeInterestsRepository
import com.example.news.data.interest.InterestRepository
import com.example.news.data.posts.FakePostsRepository
import com.example.news.data.posts.PostsRepository

interface AppContainer {
    val postsRepository: PostsRepository
    val interestsRepository: InterestRepository
}

class AppContainerImpl(private val applicationContext: Context) : AppContainer {

    override val postsRepository: PostsRepository by lazy {
        FakePostsRepository()
    }

    override val interestsRepository: InterestRepository by lazy {
        FakeInterestsRepository()
    }
}
