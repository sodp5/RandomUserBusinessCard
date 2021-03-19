package com.munny.randomuserbusinesscard.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import dagger.android.AndroidInjection

abstract class BaseActivity<B : ViewDataBinding>(
    @LayoutRes val layoutRes: Int
) : AppCompatActivity() {
    protected val binding by lazy {
        DataBindingUtil.setContentView(this, layoutRes) as B
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        binding.lifecycleOwner = this
    }
}