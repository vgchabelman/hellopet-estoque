package br.com.hellopetdesign.estoque

import android.app.Application
import br.com.hellopetdesign.estoque.di.applicationModule
import br.com.hellopetdesign.estoque.di.materialModule
import br.com.hellopetdesign.estoque.di.orderModule
import br.com.hellopetdesign.estoque.di.productModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class HellopetApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@HellopetApplication)

            modules(
                listOf(
                    applicationModule,
                    productModule,
                    materialModule,
                    orderModule
                )
            )
        }
    }
}