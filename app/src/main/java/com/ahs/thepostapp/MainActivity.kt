package com.ahs.thepostapp

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import com.ahs.thepostapp.databinding.ActivityMainBinding
import com.ahs.thepostapp.utils.adapter.PostsAdapter
import com.ahs.thepostapp.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val mainViewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val adapter = PostsAdapter()

        mainViewModel.fetchPosts()
        mainViewModel.postList.observe(this) {
            if (it.isNotEmpty()) {
                adapter.differ.submitList(it)
            }
        }

        binding.apply {
            recyclerView.layoutManager = LinearLayoutManager(this@MainActivity, VERTICAL, false)
            recyclerView.setHasFixedSize(true)

            recyclerView.adapter = adapter
        }
    }
}