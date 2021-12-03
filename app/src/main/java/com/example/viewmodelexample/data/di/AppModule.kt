package com.example.viewmodelexample.data.di

import com.example.viewmodelexample.data.remote.PostViewModel
import com.example.viewmodelexample.data.repo.Repository
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { Repository() }

    viewModel { PostViewModel(get()) }
}