package com.example.news.ui.intersets

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.news.data.interest.InterestRepository
import com.example.news.data.interest.InterestSection
import com.example.news.data.interest.TopicSelection
import com.example.news.data.posts.successOr
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class InterestsViewModel(
    private val interestsRepository: InterestRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(InterestsUiState(loading = true))
    val uiState: StateFlow<InterestsUiState> = _uiState.asStateFlow()


    val selectedTopics =
        interestsRepository.observeTopicsSelected().stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            emptySet()
        )

    val selectedPeople =
        interestsRepository.observePeopleSelected().stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            emptySet()
        )

    val selectedPublications =
        interestsRepository.observePublicationSelected().stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            emptySet()
        )

    init {
        refreshAll()
    }

    private fun refreshAll() {
        _uiState.update { it.copy(loading = true) }
        viewModelScope.launch {
            val topicDeferred = async { interestsRepository.getTopics() }
            val peopleDeferred = async { interestsRepository.getPeople() }
            val publicationDeferred = async { interestsRepository.getPublications() }

            val topics = topicDeferred.await().successOr(emptyList())
            val people = peopleDeferred.await().successOr(emptyList())
            val publications = publicationDeferred.await().successOr(emptyList())

            _uiState.update {
                it.copy(
                    loading = false,
                    topics = topics,
                    people = people,
                    publications = publications
                )
            }
        }
    }


    fun toggleTopicSelection(topic: TopicSelection) {
        viewModelScope.launch {
            interestsRepository.toggleTopicSelection(topic)
        }
    }

    fun togglePersonSelected(person: String) {
        viewModelScope.launch {
            interestsRepository.togglePersonSelected(person)
        }
    }

    fun togglePublicationSelected(publication: String) {
        viewModelScope.launch {
            interestsRepository.togglePublicationSelected(publication)
        }
    }


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

data class InterestsUiState(
    val topics: List<InterestSection> = emptyList(),
    val people: List<String> = emptyList(),
    val publications: List<String> = emptyList(),
    val loading: Boolean = false,
)