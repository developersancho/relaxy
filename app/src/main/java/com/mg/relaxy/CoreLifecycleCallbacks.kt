package com.mg.relaxy

import android.app.Activity
import android.app.Application
import android.os.Bundle
import timber.log.Timber

class CoreLifecycleCallbacks : Application.ActivityLifecycleCallbacks {

    override fun onActivityPaused(activity: Activity) {
        Timber.d(activity::class.simpleName + " onActivityPaused")
    }

    override fun onActivityStarted(activity: Activity) {
        Timber.d(activity::class.simpleName + " onActivityStarted")
    }

    override fun onActivityDestroyed(activity: Activity) {
        Timber.d(activity::class.simpleName + " onActivityDestroyed")
    }

    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
        Timber.d(activity::class.simpleName + " onActivitySaveInstanceState")
    }

    override fun onActivityStopped(activity: Activity) {
        Timber.d(activity::class.simpleName + " onActivityStopped")
    }

    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
        Timber.d(activity::class.simpleName + " onActivityCreated")
    }

    override fun onActivityResumed(activity: Activity) {
        Timber.d(activity::class.simpleName + " onActivityResumed")
    }

}