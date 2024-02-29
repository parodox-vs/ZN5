package com.example.praktikakapustnikov.activity

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.praktikakapustnikov.databinding.ActivityMainBinding
import androidx.appcompat.app.AppCompatActivity
import com.example.praktikakapustnikov.R
import com.example.praktikakapustnikov.dto.Post
import com.example.praktikakapustnikov.viewmodel.PostViewModel


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val viewModel: PostViewModel by viewModels()
        viewModel.data.observe(this) { post ->
            with(binding) {
                textView.text = post.author
                textView2.text = post.published
                textView3.text = post.content
                imageButton.setImageResource(
                    if (post.likedByMe) R.drawable.like_svgrepo_com__1_ else R.drawable.like_svgrepo_com
                )
                if (post.likedByMe) post.likes++
                else {post.likes--}
                textView4?.text = post.likes.toString()

                imageButton2.setOnClickListener {
                    if (post.sharedByMe) post.shares++
                    textView5?.text = post.shares.toString()
                }
            }


        }

        binding.imageButton.setOnClickListener {
            viewModel.like()
        }
        binding.imageButton2.setOnClickListener {
            viewModel.share()
        }

    }
}
