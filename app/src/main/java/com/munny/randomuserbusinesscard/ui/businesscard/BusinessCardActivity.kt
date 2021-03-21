package com.munny.randomuserbusinesscard.ui.businesscard

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.munny.randomuserbusinesscard.R
import com.munny.randomuserbusinesscard.base.BaseActivity
import com.munny.randomuserbusinesscard.databinding.ActivityBusinessCardBinding
import com.munny.randomuserbusinesscard.di.viewmodel.ViewModelFactory
import com.munny.randomuserbusinesscard.model.UserInfo
import javax.inject.Inject

class BusinessCardActivity : BaseActivity<ActivityBusinessCardBinding>(
    R.layout.activity_business_card
) {
    @Inject
    lateinit var vmFactory: ViewModelFactory

    private val vm: BusinessCardViewModel by viewModels { vmFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.vm = vm

        vm.setUserInfo(intent.getParcelableExtra("userInfo") as UserInfo)
    }
}