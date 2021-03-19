package com.munny.randomuserbusinesscard.ui.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.munny.randomuserbusinesscard.R
import com.munny.randomuserbusinesscard.base.BaseActivity
import com.munny.randomuserbusinesscard.databinding.ActivityMainBinding
import javax.inject.Inject

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    @Inject
    lateinit var vmFactory: ViewModelProvider.Factory

    private val vm: MainViewModel by viewModels { vmFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        vm.requestRandomUser()
    }
}