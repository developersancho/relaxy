package com.mg.relaxy

import android.content.Context
import androidx.multidex.MultiDexApplication
import com.mg.relaxy.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class CoreApp : MultiDexApplication() {

    companion object {
        lateinit var context: Context
    }


    override fun onCreate() {
        super.onCreate()
        registerActivityLifecycleCallbacks(CoreLifecycleCallbacks())
        context = applicationContext
        configureDi()
    }

    private fun configureDi() = startKoin {
        // use AndroidLogger as Koin Logger - default Level.INFO
        androidLogger()
        // use the Android context given there
        androidContext(this@CoreApp)
        // load properties from assets/koin.properties file
        androidFileProperties()
        // module list
        modules(appModule)
    }
}