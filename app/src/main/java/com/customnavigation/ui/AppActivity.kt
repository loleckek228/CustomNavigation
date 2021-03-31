package com.customnavigation.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.customnavigation.R
import com.customnavigation.databinding.ActivityAppBinding
import com.customnavigation.ui.base.BaseFlowFragment
import com.customnavigation.ui.mainflow.MainFlowFragment
import com.customnavigation.ui.extensions.activityReplaceWithoutBackStack

class AppActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAppBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAppBinding.inflate(layoutInflater)

        setContentView(binding.root)

        if (savedInstanceState == null) {
            activityReplaceWithoutBackStack<MainFlowFragment>(R.id.app_container)
        }
    }

    override fun onBackPressed() {
        val fragment =
            supportFragmentManager.findFragmentById(R.id.app_container) as? BaseFlowFragment

        if (fragment != null) {
            if (!fragment.onBackPressed()) {
                super.onBackPressed()
            }
        } else {
            super.onBackPressed()
        }
    }
}