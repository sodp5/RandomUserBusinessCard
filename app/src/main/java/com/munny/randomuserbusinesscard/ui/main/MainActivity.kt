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
                        putExtra(EXTRA_USER_INFO, command.userInfo)
                    })
                }
                MainViewModel.MainCommand.ShowRequestRandomUserToast -> {
                    val message = getString(R.string.main_request_random_user_toast)
                    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    companion object {
        const val EXTRA_USER_INFO = "extra_user_info"
    }
}