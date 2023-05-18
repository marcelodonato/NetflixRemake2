package com.example.netflixremake.presentation.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.netflixremake.base.BaseActivity
import com.example.netflixremake.base.BaseViewModel
import com.example.netflixremake.databinding.ActivitySplashBinding
import com.example.netflixremake.di.NetflixInitializer
import com.example.netflixremake.extension.viewBinding
import com.example.netflixremake.presentation.home.view.HomeActivity
import com.example.netflixremake.presentation.login.view.LoginActivity
import com.google.firebase.auth.FirebaseAuth

class SplashActivity : BaseActivity<BaseViewModel>() {

    override val binding by viewBinding(ActivitySplashBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        NetflixInitializer.init()
        Handler(Looper.getMainLooper()).postDelayed(
            { checkConnected() }, 4000.toLong()
        )
    }

    private fun checkConnected() {
        val user = FirebaseAuth.getInstance().currentUser;
        if (user != null) {
            startHomeActivity()
        } else {
            startLoginActivity()
        }
    }

    private fun startHomeActivity() {
        val intent = Intent(baseContext, HomeActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
        finish()
    }

    private fun startLoginActivity() {
        val intent = Intent(baseContext, LoginActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
        finish()
    }
}