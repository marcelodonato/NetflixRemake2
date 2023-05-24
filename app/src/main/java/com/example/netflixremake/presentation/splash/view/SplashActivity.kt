package com.example.netflixremake.presentation.splash.view

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.netflixremake.base.BaseActivity
import com.example.netflixremake.base.BaseViewModel
import com.example.netflixremake.databinding.ActivitySplashBinding
import com.example.netflixremake.extension.viewBinding
import com.example.netflixremake.presentation.splash.viewmodel.SplashViewModel
import com.gaelmarhic.quadrant.QuadrantConstants.HOME_ACTIVITY
import com.gaelmarhic.quadrant.QuadrantConstants.LOGIN_ACTIVITY
import com.google.firebase.auth.FirebaseAuth

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
        navigateToActivity(
            if (result) HOME_ACTIVITY
            else LOGIN_ACTIVITY)
        finish()

    }
}