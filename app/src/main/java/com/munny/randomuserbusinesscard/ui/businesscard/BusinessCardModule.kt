package com.munny.randomuserbusinesscard.ui.businesscard

import androidx.lifecycle.ViewModel
import com.munny.randomuserbusinesscard.di.viewmodel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class BusinessCardModule {
    @Binds
    @IntoMap
    @ViewModelKey(BusinessCardViewModel::class)
    abstract fun bindBusinessCardViewModel(businessCardViewModel: BusinessCardViewModel): ViewModel
}