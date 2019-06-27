package uk.co.applylogic.playground.navigation.credential

import dagger.Module
import dagger.Provides
import uk.co.applylogic.playground.navigation.application.di.AppScope
import uk.co.applylogic.playground.navigation.application.di.ApplicationContext

/**
 * Created by Golan Shay @golanshy on 26 June,2019
 */
@Module
class CredentialModule {

    @Provides
    @AppScope
    @ApplicationContext
    fun provideCredential() = ""
}