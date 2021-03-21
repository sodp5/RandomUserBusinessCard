package com.munny.randomuserbusinesscard.ui.main

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.munny.randomuserbusinesscard.R
import com.munny.randomuserbusinesscard.base.BaseActivity
import com.munny.randomuserbusinesscard.databinding.ActivityMainBinding
import com.munny.randomuserbusinesscard.ui.businesscard.BusinessCardActivity
import com.munny.randomuserbusinesscard.ui.main.MainViewModel.MainCommand.CreateBusinessCard
import com.munny.randomuserbusinesscard.util.observeEvent
import javax.inject.Inject

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    @Inject
    lateinit var vmFactory: ViewModelProvider.Factory

    private val vm: MainViewModel by viewModels { vmFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.vm = vm

        vm.mainCommand.observeEvent(this) { command ->
            when (command) {
                is CreateBusinessCard -> {
                    startActivity(Intent(applicationContext, BusinessCardActivity::class.java).apply {
                        putExtra("userInfo", command.userInfo)
                    })
                }
                MainViewModel.MainCommand.ShowRequestBusinessCardToast -> {
                    Toast.makeText(this, "유저를 먼저 불러와주세요.", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}