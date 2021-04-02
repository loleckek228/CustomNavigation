package com.customnavigation.ui.login

import android.content.Context
import android.os.Bundle
import com.customnavigation.ui.base.BaseFlowFragment
import com.customnavigation.ui.extensions.childReplaceWithBackStack
import com.customnavigation.ui.login.signin.SignInFragment
import com.customnavigation.ui.login.singup.SignUpFragment
import com.customnavigation.ui.mainflow.MainNavigation

class LoginFlowFragment : BaseFlowFragment(), LoginNavigation {

    private lateinit var navigation: MainNavigation

    override fun onAttach(context: Context) {
        super.onAttach(context)

        navigation = parentFragment as MainNavigation
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null && isEmptyStack()) {
            toLogin()
        }
    }

    override fun toLogin() = childReplaceWithBackStack<LoginFragment>(container, LoginFragment.TAG)

    override fun toSighIn() = childReplaceWithBackStack<SignInFragment>(container, SignInFragment.TAG)

    override fun toSignUp() = childReplaceWithBackStack<SignUpFragment>(container, SignUpFragment.TAG)

    override fun toBottomNavigation() = navigation.toBottomNavigation()

    override fun fromSignUpToSighIn() {
        childFragmentManager.popBackStack()
        toSighIn()
    }
}