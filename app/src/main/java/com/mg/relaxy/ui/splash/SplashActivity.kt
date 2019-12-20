package com.mg.relaxy.ui.splash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mg.relaxy.R
import com.mg.relaxy.ui.home.HomeActivity
import com.mg.util.constant.AppConstants
import com.mg.util.extensions.launchActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        CoroutineScope(Dispatchers.Main).launch {
            delay(AppConstants.splash_duration)
            launchActivity<HomeActivity>()
            overridePendingTransition(R.anim.fade_in, R.anim.splash_fade_out)
            finish()
        }
    }

    override fun onBackPressed() {

    }
}
