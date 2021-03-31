package com.customnavigation.ui.login.singup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.customnavigation.R
import com.customnavigation.databinding.FragmentSignUpBinding
import com.customnavigation.ui.base.BaseFragment
import com.customnavigation.ui.login.LoginNavigation

class SignUpFragment : BaseFragment() {

    companion object {
        const val TAG = "SignUpFragment"
    }

    private var _binding: FragmentSignUpBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSignUpBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)

        initButton()
        initToolbar()
    }

    private fun initButton() {
        binding.signUpButton.setOnClickListener {
            (parentFragment as LoginNavigation).fromSignUpToSighIn()
        }
    }

    private fun initToolbar() {
        with(binding.toolbar) {
            title.text = getString(R.string.sign_up)
            backButton.setOnClickListener {
                activity?.onBackPressed()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}