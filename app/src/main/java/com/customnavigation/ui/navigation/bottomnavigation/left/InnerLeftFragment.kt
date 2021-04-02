package com.customnavigation.ui.navigation.bottomnavigation.left

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.customnavigation.R
import com.customnavigation.databinding.FragmentInnerLeftBinding

class InnerLeftFragment : Fragment() {

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

    private fun initToolbar() = with(binding) {
        title.text = getString(R.string.inner_left_fragment)

        backButton.setOnClickListener {
            requireActivity().onBackPressed()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}