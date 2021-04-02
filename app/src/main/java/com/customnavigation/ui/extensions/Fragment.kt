package com.customnavigation.ui.extensions

import androidx.fragment.app.Fragment
import com.customnavigation.ui.base.BaseFlowFragment

inline fun <reified F : BaseFlowFragment> Fragment.childReplaceWithoutBackStack(
    container: Int
) = childFragmentManager.replaceWithoutBackStack<F>(container)

inline fun <reified F : Fragment> Fragment.childReplaceWithBackStack(
    container: Int,
    tag: String
) = childFragmentManager.replaceWithBackStack<F>(container, tag)