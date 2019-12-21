package com.mg.manager.di

import com.mg.manager.DataManager
import com.mg.manager.IDataManager
import org.koin.dsl.module

val managerModule = module {
    factory { DataManager(get(), get()) as IDataManager }
}