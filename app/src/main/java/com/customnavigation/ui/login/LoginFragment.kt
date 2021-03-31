package com.customnavigation.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.customnavigation.databinding.FragmentLoginBinding
import com.customnavigation.ui.base.BaseFragment

class LoginFragment : BaseFragment() {

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

        initViews()
    }

    private fun initViews() {
        initSingInButton()
        initSingUpButton()
    }

    private fun initSingInButton() {
        binding.signInButton.setOnClickListener {
            (parentFragment as LoginNavigation).toSighIn()
        }
    }

    private fun initSingUpButton() {
        binding.signUpButton.setOnClickListener {
            (parentFragment as LoginNavigation).toSignUp()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}