package com.example.news.util

internal fun <E> Set<E>.addOrRemove(element: E): Set<E> {
    this as MutableSet
    if (!add(element)){
        remove(element)
    }
    return this.toSet()
}
