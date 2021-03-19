package com.munny.randomuserbusinesscard.di

import com.munny.randomuserbusinesscard.BcApplication
import com.munny.randomuserbusinesscard.di.activity.ActivityModule
import com.munny.randomuserbusinesscard.di.api.ApiModule
import com.munny.randomuserbusinesscard.di.viewmodel.ViewModelModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector

@Component(
    modules = [
        ActivityModule::class,
        AndroidInjectionModule::class,
        ViewModelModule::class,
        ApiModule::class
    ]
)
interface AppComponent : AndroidInjector<BcApplication> {
    @Component.Factory
    interface Factory : AndroidInjector.Factory<BcApplication>
}