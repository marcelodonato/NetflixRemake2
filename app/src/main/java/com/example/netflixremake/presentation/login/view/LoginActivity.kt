package com.example.netflixremake.presentation.login.view

import android.os.Bundle
import com.example.netflixremake.base.BaseActivity
import com.example.netflixremake.base.BaseViewModel
import com.example.netflixremake.databinding.ActivityLoginBinding
import com.example.netflixremake.extension.viewBinding

class LoginActivity : BaseActivity<BaseViewModel>() {

    override val binding by viewBinding(ActivityLoginBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupView()
    }

    private fun setupView(){

    }

}