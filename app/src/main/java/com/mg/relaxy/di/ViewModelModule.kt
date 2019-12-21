package com.mg.relaxy.di

import com.mg.relaxy.ui.home.categories.CategoryViewModel
import com.mg.relaxy.ui.home.categorydetails.CategoryDetailViewModel
import com.mg.relaxy.ui.home.favorites.FavoriteViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { FavoriteViewModel(get()) }
    viewModel { CategoryViewModel(get()) }
    viewModel { CategoryDetailViewModel(get()) }
}