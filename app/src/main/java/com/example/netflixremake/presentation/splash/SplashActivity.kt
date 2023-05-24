package com.example.netflixremake.presentation.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.netflixremake.base.BaseActivity
import com.example.netflixremake.base.BaseViewModel
import com.example.netflixremake.databinding.ActivitySplashBinding
import com.example.netflixremake.di.LoginInitializer
import com.example.netflixremake.di.NetflixInitializer
import com.example.netflixremake.extension.viewBinding
import com.gaelmarhic.quadrant.QuadrantConstants.HOME_ACTIVITY
import com.gaelmarhic.quadrant.QuadrantConstants.LOGIN_ACTIVITY
import com.google.firebase.auth.FirebaseAuth

class SplashActivity : BaseActivity<BaseViewModel>() {

    override val binding by viewBinding(ActivitySplashBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Handler(Looper.getMainLooper()).postDelayed(
            { checkConnected() }, 4000L
        )
    }

    private fun checkConnected() {
        // colocar no viewmodel firebase
        val user = FirebaseAuth.getInstance().currentUser;
        navigateToActivity(user?.let { HOME_ACTIVITY } ?: LOGIN_ACTIVITY)
        finish()
    }
}