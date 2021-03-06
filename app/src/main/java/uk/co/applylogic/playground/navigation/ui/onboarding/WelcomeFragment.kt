package uk.co.applylogic.playground.navigation.ui.onboarding

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.welcome_fragment.*
import uk.co.applylogic.playground.navigation.R
import uk.co.applylogic.playground.navigation.ui.main.MainViewModel

class WelcomeFragment : Fragment() {

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.welcome_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = activity?.run {
            ViewModelProviders.of(this).get(MainViewModel::class.java)
        } ?: throw Exception("Invalid Activity")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_sign_in.setOnClickListener {
            view.findNavController().navigate(R.id.action_welcomeFragment_to_signInFragment)
        }

        btn_sign_up.setOnClickListener {
            view.findNavController().navigate(R.id.action_welcomeFragment_to_signUpFragment)
        }
    }
}
