package com.example.news.data.interest

import kotlinx.coroutines.flow.Flow
import com.example.news.data.posts.Result

data class InterestSection(
    val title: String,
    val interests: List<String>
)
data class TopicSelection(val section: String, val topic: String)
interface InterestRepository {
    /**
     * Get relevant topics to the user.
     */
    suspend fun getTopics(): Result<List<InterestSection>>

    /**
     * Get list of people.
     */
    suspend fun getPeople(): Result<List<String>>

    /**
     * Get list of publications.
     */
    suspend fun getPublications(): Result<List<String>>

    /**
     * Toggle between selected and unselected
     */
    suspend fun toggleTopicSelection(topic: TopicSelection)

    /**
     * Toggle between selected and unselected
     */
    suspend fun togglePersonSelected(person: String)

    /**
     * Toggle between selected and unselected
     */
    suspend fun togglePublicationSelected(publication: String)

    /**
     * Currently selected topics
     */
    fun observeTopicsSelected(): Flow<Set<TopicSelection>>

    /**
     * Currently selected people
     */
    fun observePeopleSelected(): Flow<Set<String>>

    /**
     * Currently selected publications
     */
    fun observePublicationSelected(): Flow<Set<String>>
}