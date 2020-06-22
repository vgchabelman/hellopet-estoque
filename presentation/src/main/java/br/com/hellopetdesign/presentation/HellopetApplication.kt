package br.com.hellopetdesign.presentation

import android.app.Application
import br.com.hellopetdesign.presentation.di.applicationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class HellopetApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@HellopetApplication)

            modules(listOf(applicationModule))
        }
    }
}