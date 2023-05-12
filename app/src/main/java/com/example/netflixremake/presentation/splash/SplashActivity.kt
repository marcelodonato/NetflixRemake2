package com.example.netflixremake.presentation.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.netflixremake.base.BaseActivity
import com.example.netflixremake.base.BaseViewModel
import com.example.netflixremake.databinding.ActivitySplashBinding
import com.example.netflixremake.extension.viewBinding
import com.example.netflixremake.presentation.home.view.HomeActivity

class SplashActivity: BaseActivity<BaseViewModel>() {


    override val binding by viewBinding(ActivitySplashBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Handler(Looper.getMainLooper()).postDelayed(
            { startHomeActivity()}, 4000.toLong()
        )
    }

    private fun startHomeActivity() {
        val intent = Intent(baseContext, HomeActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
        finish()
    }
}