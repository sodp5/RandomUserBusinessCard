package com.munny.randomuserbusinesscard.ui.businesscard

import android.os.Bundle
import androidx.activity.viewModels
import com.munny.randomuserbusinesscard.R
import com.munny.randomuserbusinesscard.base.BaseActivity
import com.munny.randomuserbusinesscard.databinding.ActivityBusinessCardBinding
import com.munny.randomuserbusinesscard.model.UserInfo
import com.munny.randomuserbusinesscard.ui.main.MainActivity.Companion.EXTRA_USER_INFO
import javax.inject.Inject

class BusinessCardActivity : BaseActivity<ActivityBusinessCardBinding>(
    R.layout.activity_business_card
) {
    @Inject
    lateinit var vmFactory: BusinessCardViewModel.BusinessCardViewModelFactory

    private val vm: BusinessCardViewModel by viewModels {
        BusinessCardViewModel.getBusinessCardViewModelFactory(
            vmFactory, intent.getParcelableExtra(EXTRA_USER_INFO) as UserInfo
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.vm = vm
    }
}