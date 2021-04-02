package com.customnavigation.ui.navigation.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.customnavigation.databinding.ItemListBinding

class ListAdapter : RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    private val data = mutableListOf<ListItem>()
    private lateinit var listItemClickListener: (ListItem) -> Unit

    fun setData(data: List<ListItem>) {
        with(this.data) {
            clear()
            addAll(data)
        }

        notifyDataSetChanged()
    }

    fun setListItemClickListener(listener: (ListItem) -> Unit) {
        listItemClickListener = listener
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder = ViewHolder(
        ItemListBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) = holder.bind(data[position])

    override fun getItemCount(): Int = data.size

    inner class ViewHolder(
        private val itemBinding: ItemListBinding
    ) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(item: ListItem) = with(itemBinding.textViewItem) {
            text = item.name

            setOnClickListener {
                listItemClickListener.invoke(item)
            }
        }
    }
}