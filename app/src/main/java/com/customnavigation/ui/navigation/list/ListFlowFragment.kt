package com.customnavigation.ui.navigation.list

import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import com.customnavigation.ui.base.BaseFlowFragment
import com.customnavigation.ui.extensions.childReplaceWithBackStack
import com.customnavigation.ui.navigation.list.detail.DetailDialogFragment

class ListFlowFragment : BaseFlowFragment(), ListNavigation {

    companion object {
        private const val TAG = "ListFlowFragment"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) {
            defaultDestination(toList())
        }
    }

    override fun toDetail(item: ListItem) {
        val fragmentTransaction: FragmentTransaction = childFragmentManager.beginTransaction()

        DetailDialogFragment.newInstance(item).apply {
            show(fragmentTransaction, TAG)
        }
    }

    override fun toList() {
        childReplaceWithBackStack<ListFragment>(container, TAG)
    }
}