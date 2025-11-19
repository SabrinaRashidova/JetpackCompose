package com.sabrina.jetpackpractise.pagination

interface Paginator<Key,Item> {
    suspend fun loadNextItems()
    fun reset()
}