package com.customnavigation.ui.navigation.bottomnavigation.left

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.customnavigation.databinding.FragmentLeftBinding

class LeftFragment : Fragment() {

    private lateinit var navigation: LeftNavigation

    override fun onAttach(context: Context) {
        super.onAttach(context)

        navigation = parentFragment as LeftNavigation
    }

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button.setOnClickListener {
            navigation.toInnerLeft()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}