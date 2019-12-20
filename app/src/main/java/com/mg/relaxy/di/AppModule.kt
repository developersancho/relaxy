package com.mg.relaxy.di

import com.mg.local.di.localModule
import com.mg.manager.di.managerModule
import com.mg.relaxy.BuildConfig
import com.mg.remote.di.remoteModule

val appModule = listOf(
    remoteModule(BuildConfig.BASE_URL),
    localModule(BuildConfig.DB_NAME),
    managerModule,
    viewModelModule
)