package com.customnavigation.ui.navigation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.customnavigation.databinding.FragmentListBinding
import com.customnavigation.ui.base.BaseFragment

class ListFragment : BaseFragment() {

    private var _binding: FragmentListBinding? = null
    private val binding
        get() = _binding!!

    private val adapter: ListAdapter by lazy {
        ListAdapter(onListItemClickListener)
    }

    private val onListItemClickListener: ListAdapter.OnListItemClickListener =
        object : ListAdapter.OnListItemClickListener {
            override fun onItemClick(data: ListItem) {
                (parentFragment as ListNavigation).toDetail(data)
            }
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()
        setDataToAdapter()
    }

    private fun initRecyclerView() {
        with(binding.recyclerView) {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = this@ListFragment.adapter
        }
    }

    private fun setDataToAdapter() {
        adapter.setData(ListItem.defaultItems)
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}