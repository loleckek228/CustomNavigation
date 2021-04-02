package com.customnavigation.ui.login

interface LoginNavigation {
    fun toLogin()
    fun toSighIn()
    fun toSignUp()
    fun fromSignUpToSighIn()
    fun toBottomNavigation()
}