package com.customnavigation.ui.navigation.list

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.customnavigation.databinding.FragmentListBinding

class ListFragment : Fragment() {

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!

    private lateinit var navigation: ListNavigation

    private val adapter: ListAdapter by lazy {
        ListAdapter().apply {
            setListItemClickListener {
                navigation.toDetail(it)
            }
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        navigation = parentFragment as ListNavigation
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()
        setDataToAdapter()
    }

    private fun initRecyclerView() = with(binding.recyclerView) {
        layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        adapter = this@ListFragment.adapter
    }

    private fun setDataToAdapter() = adapter.setData(ListItemFactory.defaultItems)

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}