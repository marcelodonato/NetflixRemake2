package com.example.netflixremake.presentation.login.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.example.netflixremake.R
import com.example.netflixremake.base.BaseActivity
import com.example.netflixremake.databinding.ActivityLoginBinding
import com.example.netflixremake.extension.confirmIfEmailIsValid
import com.example.netflixremake.extension.getEditText
import com.example.netflixremake.extension.isValid
import com.example.netflixremake.extension.viewBinding
import com.example.netflixremake.presentation.login.viewmodel.LoginViewModel
import com.gaelmarhic.quadrant.QuadrantConstants.HOME_ACTIVITY
import com.gaelmarhic.quadrant.QuadrantConstants.REGISTER_ACTIVITY

class LoginActivity : BaseActivity<LoginViewModel>() {

    companion object {
        fun getStartIntent(context: Context) = Intent(context, LoginActivity::class.java)
    }

    override val binding by viewBinding(ActivityLoginBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupView()
        setupObservable()
    }

    private fun setupObservable() = with(viewModel) {
        onLoginResult.observe(this@LoginActivity, ::onLoginResult)
    }

    private fun setupView() {
        with(binding) {
            btnLogin.setOnClickListener {
                validateFields()
            }
            tvRegister.setOnClickListener {
                navigateToActivity(REGISTER_ACTIVITY)
            }
        }
    }

    private fun validateFields() {
        val email = binding.etLogin.isValid()
        val confirmEmail = confirmIfEmailIsValid(binding.etLogin.getEditText())
        val password = binding.etPassword.isValid()

        when {
            email -> binding.etLogin.error =
                getString(R.string.generic_error_edit_text, getString(R.string.email))
            confirmEmail -> binding.etLogin.error = getString(R.string.email_error)
            password -> binding.etPassword.error = getString(R.string.password_error)
            else -> {
                viewModel.login(binding.etLogin.getEditText(), binding.etPassword.getEditText())
            }
        }
    }

    private fun onLoginResult(result: Boolean) {
        if (result) {
            navigateToActivity(HOME_ACTIVITY)
            finish()
        } else {
            Toast.makeText(this, getString(R.string.unexpected_error), Toast.LENGTH_SHORT).show()
        }
    }
}