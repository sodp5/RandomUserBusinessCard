package com.munny.randomuserbusinesscard.di.activity

import com.munny.randomuserbusinesscard.ui.businesscard.BusinessCardActivity
import com.munny.randomuserbusinesscard.ui.main.MainActivity
import com.munny.randomuserbusinesscard.ui.main.MainModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {
    @ActivityScope
    @ContributesAndroidInjector(modules = [MainModule::class])
    abstract fun injectMainActivity(): MainActivity

    @ActivityScope
    @ContributesAndroidInjector
    abstract fun injectBusinessCardActivity(): BusinessCardActivity
}