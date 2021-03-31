package com.customnavigation.ui.navigation.bottomnavigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.customnavigation.R
import com.customnavigation.databinding.FragmentBottomNavigationFlowBinding
import com.customnavigation.ui.base.BaseFlowFragment
import com.customnavigation.ui.extensions.childReplaceWithoutBackStack
import com.customnavigation.ui.navigation.bottomnavigation.left.LeftFlowFragment
import com.customnavigation.ui.navigation.list.ListFlowFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class BottomNavigationFlowFragment : BaseFlowFragment(), BottomNavigation {

    private var _binding: FragmentBottomNavigationFlowBinding? = null
    private val binding get() = _binding!!

    private lateinit var bottomNavigationView: BottomNavigationView

    override val container: Int = R.id.bottom_navigation_container

    private val onNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_left -> {
                    toLeftFlow()
                    true
                }

                R.id.navigation_middle -> {
                    toListFlow()
                    true
                }

                R.id.navigation_right -> {
                    true
                }

                else -> false
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) {
            defaultDestination(toLeftFlow())
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBottomNavigationFlowBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)

        initBottomNavigationView()
    }

    private fun initBottomNavigationView() {
        bottomNavigationView = binding.bottomNavigationView
        bottomNavigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
    }

    override fun toLeftFlow() {
        childReplaceWithoutBackStack<LeftFlowFragment>(container)
    }

    override fun toListFlow() {
        childReplaceWithoutBackStack<ListFlowFragment>(container)
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}