package uk.co.applylogic.playground.navigation.application.di

import dagger.Module
import dagger.Provides
import uk.co.applylogic.playground.navigation.application.NavigationDemoApp

/**
 * Created by Golan Shay @golanshy on 26 June,2019
 */
@Module
class AppModule(val app: NavigationDemoApp) {
    @Provides
    @AppScope
    @ApplicationContext
    fun provideApp() = app
}