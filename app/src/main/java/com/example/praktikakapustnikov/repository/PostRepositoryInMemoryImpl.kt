package com.example.praktikakapustnikov.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.praktikakapustnikov.dto.Post

class PostRepositoryInMemoryImpl : PostRepository {
    private var post = Post(
        id = 1,
        author = "Бтпит. Учебное заведение",
        content = "Всех студентов поздравляем с 1 сентября!",
        published = "1 сентября в 8:00",
        likedByMe = false,
        sharedByMe = false
    )
    private val data = MutableLiveData(post)

    override fun get(): LiveData<Post> = data
    override fun like() {
        post = post.copy(likedByMe = !post.likedByMe)
        data.value = post
    }
    override fun share() {
        post = post.copy(sharedByMe = !post.sharedByMe)
        data.value = post
    }
}