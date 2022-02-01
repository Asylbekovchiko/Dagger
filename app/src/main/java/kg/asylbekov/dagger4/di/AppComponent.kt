package kg.asylbekov.dagger4.di

import dagger.Component
import kg.asylbekov.dagger4.presentation.MainActivity
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, DataModule::class, DomainModule::class])
interface AppComponent {

    fun inject(mainActivity: MainActivity)
}