package com.example.praktikakapustnikov.repository

import androidx.lifecycle.LiveData
import com.example.praktikakapustnikov.dto.Post

interface PostRepository {
    fun get(): LiveData<Post>
    fun like()
    fun share()
}