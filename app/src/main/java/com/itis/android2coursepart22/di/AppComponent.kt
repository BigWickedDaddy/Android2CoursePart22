package com.itis.android2coursepart22.di

import com.itis.android2coursepart22.App
import com.itis.android2coursepart22.di.module.AppModule
import com.itis.android2coursepart22.di.module.NetModule
import com.itis.android2coursepart22.di.module.RepoModule
import dagger.BindsInstance
import dagger.Component


@Component(
    modules = [
        AppModule::class,
        NetModule::class,
        RepoModule::class,]
)
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun applicationContext(application: App): Builder
        fun build(): AppComponent
    }

    fun inject(application: App)

}