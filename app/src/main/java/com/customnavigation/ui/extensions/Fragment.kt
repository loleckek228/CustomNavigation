package com.customnavigation.ui.extensions

import androidx.fragment.app.Fragment
import com.customnavigation.ui.base.BaseFlowFragment
import com.customnavigation.ui.base.BaseFragment

inline fun <reified F : BaseFlowFragment> Fragment.childReplaceWithoutBackStack(container: Int) {
    childFragmentManager.replaceWithoutBackStack<F>(container)
}

inline fun <reified F : BaseFragment> Fragment.childReplaceWithBackStack(
    container: Int,
    tag: String
) {
    childFragmentManager.replaceWithBackStack<F>(container, tag)
}