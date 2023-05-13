package com.example.news.ui.intersets

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.news.data.interest.InterestRepository

class InterestsViewModel(
    private val interestsRepository: InterestRepository
) : ViewModel() {


    companion object {
        fun provideFactory(
            interestsRepository: InterestRepository,
        ): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return InterestsViewModel(interestsRepository) as T
            }
        }
    }
}