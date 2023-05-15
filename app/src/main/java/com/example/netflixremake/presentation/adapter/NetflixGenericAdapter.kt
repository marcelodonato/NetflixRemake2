package com.example.netflixremake.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.IntDef
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.netflixremake.R
import com.example.netflixremake.data.model.*
import com.example.netflixremake.presentation.adapter.viewHolders.CategoryItemViewHolder
import com.example.netflixremake.presentation.adapter.viewHolders.MovieItemSimilarViewHolder
import com.example.netflixremake.presentation.adapter.viewHolders.MovieItemViewHolder

class NetflixGenericAdapter(var clickListener: (AdaptableItem) -> Unit = {}) :
    Adapter<ViewHolder>() {

    var items: List<AdaptableItem> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {

            MOVIE -> MovieItemViewHolder(
                inflater.inflate(
                    R.layout.movie_item, parent, false
                )
            )

            CATEGORY -> CategoryItemViewHolder(
                inflater.inflate(
                    R.layout.category_item, parent, false
                )
            )

            SIMILAR -> MovieItemSimilarViewHolder(
                inflater.inflate(
                    R.layout.movie_item_similar, parent, false
                )
            )


            else -> throw NullPointerException("Should not create adapter without a determined viewType")
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        when (holder) {
            is MovieItemViewHolder -> holder.bindWith(item as Movie, clickListener)
            is CategoryItemViewHolder -> holder.bindWith(item as CategoryItem, clickListener)
            is MovieItemSimilarViewHolder -> holder.bindWith(item as MovieSimilar)

            else -> throw NullPointerException("NetflixGenericAdapter viewHolder is null")
        }
    }

    override fun getItemViewType(position: Int) = items[position].itemType()

    override fun getItemCount() = items.size

    override fun onViewAttachedToWindow(holder: ViewHolder) {
        if (holder is ParentMatcher) holder.matchParent()
        super.onViewAttachedToWindow(holder)
    }

    companion object {
        @IntDef(MOVIE, CATEGORY, SIMILAR)
        @Retention(AnnotationRetention.SOURCE)
        annotation class AdapterType

        const val MOVIE = 0
        const val CATEGORY = 1
        const val SIMILAR = 2


        interface ParentMatcher {
            fun matchParent()
        }
    }
}