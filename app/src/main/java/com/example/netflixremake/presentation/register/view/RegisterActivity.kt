package com.example.netflixremake.presentation.register.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.example.netflixremake.R
import com.example.netflixremake.base.BaseActivity
import com.example.netflixremake.base.BaseViewModel
import com.example.netflixremake.databinding.ActivityRegisterBinding
import com.example.netflixremake.extension.confirmIfEmailIsValid
import com.example.netflixremake.extension.getEditText
import com.example.netflixremake.extension.validate
import com.example.netflixremake.extension.viewBinding
import com.example.netflixremake.presentation.home.view.HomeActivity
import com.example.netflixremake.presentation.login.view.LoginActivity
import com.example.netflixremake.presentation.register.viewmodel.RegisterViewModel
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : BaseActivity<RegisterViewModel>() {
    override val binding by viewBinding(ActivityRegisterBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupView()
    }

    private fun setupView() {
        with(binding) {
            tvLogin.setOnClickListener {
                startLoginActivity()
            }
            btnRegister.setOnClickListener {
                validateFields()
            }
        }
    }


    private fun validateFields() {
        val email = binding.etEmailRegister.validate()
        val password = binding.etPasswordRegister.validate()
        val confirmPassword =
            binding.etConfirmPassword.getEditText() != binding.etPasswordRegister.getEditText()
        val passwordLength = binding.etPasswordRegister.length() !in 6..63
        val confirmEmail = confirmIfEmailIsValid(binding.etEmailRegister.getEditText())

        when {
            email -> binding.etEmailRegister.error =
                getString(R.string.generic_error_edit_text, getString(R.string.email))
            confirmEmail -> binding.etEmailRegister.error = getString(R.string.email_error)
            password -> binding.etPasswordRegister.error =
                getString(R.string.generic_error_edit_text, getString(R.string.password))
            passwordLength -> binding.etPasswordRegister.error =
                getString(R.string.password_error_length)
            confirmPassword -> binding.etConfirmPassword.error =
                getString(R.string.generic_error_edit_text)
            else -> {
                viewModel.registerToFirebase(
                    binding.etEmailRegister.getEditText(),
                    binding.etPasswordRegister.getEditText()
                )

                setupObservable()
            }
        }
    }

    private fun setupObservable() =  with(viewModel) {
        onRegisterResult.observe(this@RegisterActivity, ::onRegisterResult)
    }

    private fun onRegisterResult(result : Boolean){
        if(result){
            finish()
            startHomeActivity()
        }else{
            errorCase()
        }
    }

    private fun startLoginActivity() {
        val intent = Intent(baseContext, LoginActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
        finish()
    }

    private fun startHomeActivity() {
        val intent = Intent(baseContext, HomeActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
        finish()
    }

    private fun errorCase() {
        Toast.makeText(this, getString(R.string.unexpected_error), Toast.LENGTH_SHORT).show()
    }
}