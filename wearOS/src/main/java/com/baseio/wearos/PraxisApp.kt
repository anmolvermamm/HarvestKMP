package com.baseio.wearos

import android.app.Application
import com.baseio.kmm.di.SharedComponent
import com.baseio.kmm.di.UseCasesComponent
import com.baseio.kmm.di.platformModule
import com.baseio.kmm.di.useCaseModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

val sharedComponent = SharedComponent()
val useCasesComponent = UseCasesComponent()

class PraxisApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@PraxisApp)
            modules(platformModule, useCaseModule, platformModule())
        }
    }
}
