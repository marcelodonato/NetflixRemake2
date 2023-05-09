package com.example.netflixremake.presentation.adapter.viewHolders

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.netflixremake.data.model.AdaptableItem
import com.example.netflixremake.data.model.Category
import com.example.netflixremake.databinding.CategoryItemBinding
import com.example.netflixremake.presentation.adapter.NetflixGenericAdapter

class CategoryItemViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
    private var binding = CategoryItemBinding.bind(itemView)

    val context: Context = itemView.context

    fun bindWith(item: Category, clickListener: (AdaptableItem) -> Unit) {
        with(binding) {
            tvTitle.text = item.name
            rvCategory.apply {
                layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
                adapter = NetflixGenericAdapter {
                }
            }
        }
    }
}