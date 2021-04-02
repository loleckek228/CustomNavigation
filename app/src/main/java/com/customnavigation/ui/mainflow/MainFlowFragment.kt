package com.customnavigation.ui.mainflow

import android.os.Bundle
import com.customnavigation.ui.base.BaseFlowFragment
import com.customnavigation.ui.extensions.childReplaceWithoutBackStack
import com.customnavigation.ui.login.LoginFlowFragment
import com.customnavigation.ui.navigation.bottomnavigation.BottomNavigationFlowFragment

class MainFlowFragment : BaseFlowFragment(), MainNavigation {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null && isEmptyStack()) {
            toLogin()
        }
    }

    override fun toBottomNavigation() = childReplaceWithoutBackStack<BottomNavigationFlowFragment>(container)

    override fun toLogin() = childReplaceWithoutBackStack<LoginFlowFragment>(container)
}