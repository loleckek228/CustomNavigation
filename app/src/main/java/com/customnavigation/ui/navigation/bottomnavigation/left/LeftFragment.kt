package com.customnavigation.ui.navigation.bottomnavigation.left

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.customnavigation.databinding.FragmentLeftBinding
import com.customnavigation.ui.base.BaseFragment

class LeftFragment : BaseFragment() {

    companion object {
        const val TAG = "LeftFragment"
    }

    private var _binding: FragmentLeftBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLeftBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)

        setOnClickButtonListener()
    }

    private fun setOnClickButtonListener() {
        binding.button.setOnClickListener {
            (parentFragment as LeftNavigation).toInnerLeft()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}