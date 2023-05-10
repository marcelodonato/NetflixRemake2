package com.example.netflixremake.presentation.adapter.viewHolders

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.netflixremake.data.model.AdaptableItem
import com.example.netflixremake.data.model.Category
import com.example.netflixremake.databinding.CategoryItemBinding
import com.example.netflixremake.presentation.adapter.NetflixGenericAdapter

class CategoryItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private var binding = CategoryItemBinding.bind(itemView)

    fun bindWith(items: Category, clickListener: (AdaptableItem) -> Unit) {
        with(binding) {
            tvTitle.text = items.name
            rvCategory.apply {
                val categoryAdapter = NetflixGenericAdapter()
                categoryAdapter.clickListener = {
                    clickListener.invoke(items)
                }
                layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
                categoryAdapter.items = items.movies
                adapter = categoryAdapter
            }
        }
    }
}