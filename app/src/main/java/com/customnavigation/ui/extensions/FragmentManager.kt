package com.customnavigation.ui.extensions

import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.customnavigation.ui.base.BaseFlowFragment
import com.customnavigation.ui.base.BaseFragment

inline fun <reified F : BaseFlowFragment> FragmentManager.replaceWithoutBackStack(container: Int) {
    commit {
        replace<F>(container)
        setReorderingAllowed(true)
    }
}

inline fun <reified F : BaseFragment> FragmentManager.replaceWithBackStack(
    container: Int,
    tag: String
) {
    commit {
        replace<F>(container)
        addToBackStack(tag)
        setReorderingAllowed(true)
    }
}