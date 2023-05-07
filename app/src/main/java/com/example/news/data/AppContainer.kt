package com.example.news.data

import android.content.Context

interface AppContainer {
    val postsRepository: PostRepository
    val interestsRepository: intrestsRepository
}

class AppContainerImpl(private val applicationContext: Context) : AppContainer {

    override val postsRepository: PostsRepository by lazy {
        FakePostsRepository()
    }

    override val interestsRepository: InterestsRepository by lazy {
        FakeInterestsRepository()
    }
}
