package com.customnavigation.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.customnavigation.R
import com.customnavigation.databinding.LayoutContainerBinding

abstract class BaseFlowFragment : Fragment() {

    companion object {
        private const val MIN_SCREEN_COUNT = 1
    }

    private var _binding: LayoutContainerBinding? = null
    private val binding get() = _binding!!

    protected open val container: Int = R.id.main_container

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = LayoutContainerBinding.inflate(inflater, container, false)

        return binding.root
    }

    protected fun isEmptyStack(): Boolean = childFragmentManager.fragments.isEmpty()

    fun onBackPressed(): Boolean = childFragmentManager.findFragmentById(container).let { fragment ->
        if (fragment is BaseFlowFragment) {
            fragment.onBackPressed()
        } else {
            if (childFragmentManager.backStackEntryCount > MIN_SCREEN_COUNT) {
                childFragmentManager.popBackStack()
                true
            } else {
                false
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}