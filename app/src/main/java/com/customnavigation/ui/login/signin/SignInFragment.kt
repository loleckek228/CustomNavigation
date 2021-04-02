package com.customnavigation.ui.login.signin

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.customnavigation.R
import com.customnavigation.databinding.FragmentSignInBinding
import com.customnavigation.ui.login.LoginNavigation

class SignInFragment : Fragment() {

    companion object {
        const val TAG = "SignInFragment"
    }

    private var _binding: FragmentSignInBinding? = null
    private val binding get() = _binding!!

    private lateinit var navigation: LoginNavigation

    override fun onAttach(context: Context) {
        super.onAttach(context)

        navigation = parentFragment as LoginNavigation
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSignInBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initButton()
        initToolbar()
    }

    private fun initButton() = binding.signInButton.setOnClickListener {
        navigation.toBottomNavigation()
    }

    private fun initToolbar() = with(binding.toolbar) {
        title.text = getString(R.string.sign_in)

        backButton.setOnClickListener {
            requireActivity().onBackPressed()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}