package com.customnavigation.ui.extensions

import androidx.appcompat.app.AppCompatActivity
import com.customnavigation.ui.base.BaseFlowFragment

inline fun <reified F : BaseFlowFragment> AppCompatActivity.activityReplaceWithoutBackStack(
    container: Int
) = supportFragmentManager.replaceWithoutBackStack<F>(container)