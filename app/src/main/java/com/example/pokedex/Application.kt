package com.example.pokedex

import android.app.Application
import com.example.pokedex.util.ModuleProvider
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication)
            modules(ModuleProvider().getModule())
        }
    }
}