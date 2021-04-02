package com.customnavigation.ui.login

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.customnavigation.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var navigation: LoginNavigation

    override fun onAttach(context: Context) {
        super.onAttach(context)

        navigation = parentFragment as LoginNavigation
    }

    companion object {
        const val TAG = "LoginFragment"
    }

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setSingInButtonBehavior()
        setSingUpButtonBehavior()
    }

    private fun setSingInButtonBehavior() = binding.signInButton.setOnClickListener {
        navigation.toSighIn()
    }

    private fun setSingUpButtonBehavior() = binding.signUpButton.setOnClickListener {
        navigation.toSignUp()
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}