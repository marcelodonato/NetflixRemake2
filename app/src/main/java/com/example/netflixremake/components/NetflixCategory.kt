package com.example.netflixremake.components

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.netflixremake.data.model.AdaptableItem
import com.example.netflixremake.data.model.Category
import com.example.netflixremake.databinding.CategoryItemBinding
import com.example.netflixremake.presentation.adapter.NetflixGenericAdapter

class NetflixCategory : ConstraintLayout {

    private val binding: CategoryItemBinding =
        CategoryItemBinding.inflate(LayoutInflater.from(context), this, true)

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    fun setupWith(items: Category, callback: (AdaptableItem) -> Unit) {
        with(binding) {
            tvTitle.text = items.name
            rvCategory.apply {
                val adapterCategory = NetflixGenericAdapter()
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                adapter = adapterCategory
                adapterCategory.items = items.movieList.orEmpty()
                adapterCategory.clickListener = { adaptableItem ->
                    callback(adaptableItem)
                }
            }
        }
    }
}