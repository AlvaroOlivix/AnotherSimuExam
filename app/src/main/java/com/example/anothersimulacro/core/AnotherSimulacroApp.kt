package com.example.anothersimulacro.core

import android.app.Application
import com.example.anothersimulacro.core.di.AppModule
import com.google.firebase.FirebaseApp
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin
import org.koin.ksp.generated.module

class AnotherSimulacroApp : Application() {

    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(this)
        startKoin {
            androidContext(this@AnotherSimulacroApp)
            modules(AppModule().module)
        }
    }
}