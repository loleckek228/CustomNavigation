package com.customnavigation.ui.navigation.bottomnavigation.left

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.customnavigation.R
import com.customnavigation.databinding.FragmentInnerLeftBinding
import com.customnavigation.ui.base.BaseFragment

class InnerLeftFragment : BaseFragment() {

    companion object {
        const val TAG = "InnerLeftFragment"
    }

    private var _binding: FragmentInnerLeftBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentInnerLeftBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initToolbar()
    }

    private fun initToolbar() {
        with(binding) {
            title.text = getString(R.string.inner_left_fragment)

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