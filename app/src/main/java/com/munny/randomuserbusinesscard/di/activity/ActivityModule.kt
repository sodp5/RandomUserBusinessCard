package com.munny.randomuserbusinesscard.di.activity

import com.munny.randomuserbusinesscard.ui.MainActivity
import com.munny.randomuserbusinesscard.ui.MainModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {
    @ActivityScope
    @ContributesAndroidInjector(modules = [MainModule::class])
    abstract fun injectMainActivity(): MainActivity
}