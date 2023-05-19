package com.example.netflixremake.presentation.login.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.netflixremake.R
import com.example.netflixremake.base.BaseActivity
import com.example.netflixremake.base.BaseViewModel
import com.example.netflixremake.databinding.ActivityLoginBinding
import com.example.netflixremake.extension.confirmIfEmailIsValid
import com.example.netflixremake.extension.getEditText
import com.example.netflixremake.extension.validate
import com.example.netflixremake.extension.viewBinding
import com.example.netflixremake.presentation.home.view.HomeActivity
import com.example.netflixremake.presentation.register.view.RegisterActivity
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : BaseActivity<BaseViewModel>() {

    override val binding by viewBinding(ActivityLoginBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupView()
    }

    private fun setupView() {
        with(binding) {
            btnLogin.setOnClickListener {
                validateFields()
            }
            tvRegister.setOnClickListener {
                startRegisterActivity()
            }
        }
    }

    private fun validateFields() {
        val email = binding.etLogin.validate()
        val confirmEmail = confirmIfEmailIsValid(binding.etLogin.getEditText())
        val password = binding.etPassword.validate()

        when {
            email -> binding.etLogin.error =
                getString(R.string.generic_error_edit_text, getString(R.string.email))
            confirmEmail -> binding.etLogin.error = getString(R.string.email_error)
            password -> binding.etPassword.error = getString(R.string.password_error)
            else -> {
//                binding.incLoader.frameLoadingBackground.visibility = View.VISIBLE
                loginFirebase(
                    binding.etLogin.getEditText(),
                    binding.etPassword.getEditText()
                )
            }
        }
    }

    private fun loginFirebase(email: String, password: String) {
        val firebase = FirebaseAuth.getInstance()
        firebase.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    startHomeActivity()
                } else {
                    Toast.makeText(this, "Account not found", Toast.LENGTH_SHORT).show()
                }
            }.addOnFailureListener {
                Toast.makeText(this, it.message.toString(), Toast.LENGTH_SHORT).show()
            }
    }

    private fun startHomeActivity() {
        val homeIntent = Intent(this, HomeActivity::class.java)
        startActivity(homeIntent)
        finish()
    }

    private fun startRegisterActivity() {
        val intent = Intent(baseContext, RegisterActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
        finish()
    }
}