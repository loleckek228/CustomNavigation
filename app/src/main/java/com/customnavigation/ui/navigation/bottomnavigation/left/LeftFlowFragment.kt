package com.customnavigation.ui.navigation.bottomnavigation.left

import android.os.Bundle
import com.customnavigation.ui.base.BaseFlowFragment
import com.customnavigation.ui.extensions.childReplaceWithBackStack

class LeftFlowFragment : BaseFlowFragment(), LeftNavigation {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null && isEmptyStack()) {
            toLeft()
        }
    }

    override fun toLeft() = childReplaceWithBackStack<LeftFragment>(container, LeftFragment.TAG)

    override fun toInnerLeft() = childReplaceWithBackStack<InnerLeftFragment>(container, InnerLeftFragment.TAG)
}