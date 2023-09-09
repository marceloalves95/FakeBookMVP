package br.com.fakebookmvp.app

import android.app.Application
import br.com.fakebookmvp.app.di.FakeBookModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext

class Application : Application() {
    override fun onCreate() {
        super.onCreate()
        GlobalContext.startKoin {
            androidContext(this@Application)
        }
        FakeBookModule.load()
    }
}