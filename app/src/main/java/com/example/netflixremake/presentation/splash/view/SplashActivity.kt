package com.example.netflixremake.presentation.splash.view

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.netflixremake.base.BaseActivity
import com.example.netflixremake.databinding.ActivitySplashBinding
import com.example.netflixremake.extension.viewBinding
import com.example.netflixremake.presentation.home.view.HomeActivity
import com.example.netflixremake.presentation.login.view.LoginActivity
import com.example.netflixremake.presentation.splash.viewmodel.SplashViewModel

class SplashActivity : BaseActivity<SplashViewModel>() {

    override val binding by viewBinding(ActivitySplashBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Handler(Looper.getMainLooper()).postDelayed(
            {
                viewModel.checkConnected()
                setupObservable()
            }, 4000L
        )
    }

    private fun setupObservable() = with(viewModel) {
        onVerifyResult.observe(this@SplashActivity, ::onVerifyResult)
    }

    private fun onVerifyResult(result: Boolean) {
        startActivity(if (result) HomeActivity.getStartIntent(this@SplashActivity) else LoginActivity.getStartIntent(this@SplashActivity))
        finish()
    }
}