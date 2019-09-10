package uk.co.applylogic.playground.navigation.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.SavedStateVMFactory
import androidx.lifecycle.ViewModelProvider
import uk.co.applylogic.playground.navigation.R
import uk.co.applylogic.playground.navigation.application.di.AppComponent
import uk.co.applylogic.playground.navigation.application.di.DaggerAppComponent

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    private val component: AppComponent by lazy {
        DaggerAppComponent
            .builder()
            .build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        component.inject(this)

        viewModel = ViewModelProvider(this@MainActivity, SavedStateVMFactory(this)).get(MainViewModel::class.java)
        viewModel.onViewCreated()
    }
}
