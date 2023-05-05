package com.example.netflixremake.base

import android.content.Intent
import android.graphics.Rect
import android.os.Bundle
import android.view.MenuItem
import android.view.MotionEvent
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.example.netflixremake.extension.hideKeyboard
import org.koin.androidx.viewmodel.ext.android.viewModelForClass
import java.lang.reflect.ParameterizedType
import kotlin.reflect.KClass

abstract class BaseActivity<V : BaseViewModel> : AppCompatActivity() {

    abstract val binding: ViewBinding

    val viewModel: V by lazy {viewModelForClass(viewModelClass()).value}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    fun navigateToActivity(activity: String) {
        startActivity(Intent().setClassName(this, activity))
    }

    private fun viewModelClass(): KClass<V> {
        return ((javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0] as Class<V>).kotlin
    }

    override fun dispatchTouchEvent(event: MotionEvent): Boolean {
        if (event.action == MotionEvent.ACTION_DOWN) {
            currentFocus.takeIf { it is EditText }?.run {
                val outRect = Rect()
                getGlobalVisibleRect(outRect)
                if (!outRect.contains(event.rawX.toInt(), event.rawY.toInt())) {
                    hideKeyboard()
                    clearFocus()
                }
            }
        }
        return super.dispatchTouchEvent(event)
    }

}
