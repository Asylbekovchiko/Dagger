package kg.asylbekov.dagger4.app

import android.app.Application
import kg.asylbekov.dagger4.di.AppComponent
import kg.asylbekov.dagger4.di.AppModule
import kg.asylbekov.dagger4.di.DaggerAppComponent

class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }
}