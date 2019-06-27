package uk.co.applylogic.playground.navigation.application

import android.app.Application
import com.squareup.leakcanary.LeakCanary
import uk.co.applylogic.playground.navigation.application.di.AppComponent
import uk.co.applylogic.playground.navigation.application.di.DaggerAppComponent

/**
 * Created by Golan Shay @golanshy on 26 June,2019
 */
class NavigationDemoApp: Application() {

    companion object {
        lateinit var appContext: NavigationDemoApp
    }

    private val component: AppComponent by lazy {
        DaggerAppComponent
            .builder()
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        appContext = this
        component.inject(this)

        if (!LeakCanary.isInAnalyzerProcess(this)) LeakCanary.install(this)
    }
}