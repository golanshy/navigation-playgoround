package uk.co.applylogic.playground.navigation.application.di

import com.google.android.gms.auth.api.credentials.Credential
import dagger.Component
import uk.co.applylogic.playground.navigation.application.NavigationDemoApp
import uk.co.applylogic.playground.navigation.credential.CredentialInterface
import uk.co.applylogic.playground.navigation.credential.CredentialModule
import uk.co.applylogic.playground.navigation.networking.APIInterface
import uk.co.applylogic.playground.navigation.networking.RetrofitModule
import uk.co.applylogic.playground.navigation.ui.main.MainActivity

/**
 * Created by Golan Shay @golanshy on 26 June,2019
 */
@AppScope
@Component(modules = [AppModule::class, CredentialModule::class, RetrofitModule::class])
interface AppComponent {
    fun inject(application: NavigationDemoApp)
    fun inject(activity: MainActivity)
    fun getApiInterface() : APIInterface
//    fun getCredentialInterface() : CredentialInterface
}