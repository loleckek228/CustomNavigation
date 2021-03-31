package com.customnavigation.ui.login.signin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.customnavigation.R
import com.customnavigation.databinding.FragmentSignInBinding
import com.customnavigation.ui.base.BaseFragment
import com.customnavigation.ui.login.LoginNavigation

class SignInFragment : BaseFragment() {

    companion object {
        const val TAG = "SignInFragment"
    }

    private var _binding: FragmentSignInBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSignInBinding.inflate(inflater, container, false)

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
        binding.signInButton.setOnClickListener {
            (parentFragment as LoginNavigation).toBottomNavigation()
        }
    }

    private fun initToolbar() {
        with(binding.toolbar) {
            title.text = getString(R.string.sign_in)

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