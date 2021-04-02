package com.customnavigation.ui.navigation.list.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment
import com.customnavigation.R
import com.customnavigation.databinding.FragmentDetailBinding
import com.customnavigation.ui.navigation.list.ListItem

class DetailDialogFragment : DialogFragment() {

    companion object {
        const val DETAIL_ITEM = "DetailDialogFragment.DETAIL_ITEM"

        fun newInstance(item: ListItem): DetailDialogFragment = DetailDialogFragment().apply {
            arguments = bundleOf(
                DETAIL_ITEM to item
            )
        }
    }

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setStyle(STYLE_NORMAL, R.style.FullScreenDialog)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.getParcelable<ListItem?>(DETAIL_ITEM)?.let(::showTextView)

        initToolbar()
    }

    private fun initToolbar() = with(binding.toolbar) {
        title.text = getString(R.string.detail)

        backButton.setOnClickListener {
            dismiss()
        }
    }

    private fun showTextView(inputText: ListItem) {
        binding.textView.text = inputText.name
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}