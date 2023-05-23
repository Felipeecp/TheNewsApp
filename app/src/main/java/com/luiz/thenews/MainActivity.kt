package com.luiz.thenews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.luiz.thenews.databinding.ActivityMainBinding
import com.luiz.thenews.presentation.adapter.NewsAdapter
import com.luiz.thenews.presentation.viewmodel.NewsViewModel
import com.luiz.thenews.presentation.viewmodel.NewsViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: NewsViewModelFactory
    @Inject
    lateinit var newsAdapter: NewsAdapter
    private lateinit var binding: ActivityMainBinding
    lateinit var viewModel: NewsViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupBottomMenu()

        viewModel = ViewModelProvider(this, factory)[NewsViewModel::class.java]

    }

    private fun setupBottomMenu() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController
        binding.bvnNews.setupWithNavController(
            navController
        )
    }
}