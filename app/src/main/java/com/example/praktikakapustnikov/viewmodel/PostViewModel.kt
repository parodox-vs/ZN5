package com.example.praktikakapustnikov.viewmodel

import androidx.lifecycle.ViewModel
import com.example.praktikakapustnikov.repository.PostRepository
import com.example.praktikakapustnikov.repository.PostRepositoryInMemoryImpl

class PostViewModel : ViewModel() {
    private val repository: PostRepository = PostRepositoryInMemoryImpl()
    val data = repository.get()
    fun like() = repository.like()
    fun share() = repository.share()
}