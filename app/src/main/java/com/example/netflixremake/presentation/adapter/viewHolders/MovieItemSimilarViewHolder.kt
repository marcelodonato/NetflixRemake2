package com.example.netflixremake.presentation.adapter.viewHolders

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.netflixremake.data.model.AdaptableItem
import com.example.netflixremake.data.model.Movie
import com.example.netflixremake.databinding.MovieItemBinding
import com.example.netflixremake.databinding.MovieItemSimilarBinding

class MovieItemSimilarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private var binding = MovieItemSimilarBinding.bind(itemView)

    val context: Context = itemView.context

    fun bindWith(item: Movie, clickListener: (AdaptableItem) -> Unit) {
        with(binding) {
            cvContainerMovieSimilar.setOnClickListener{
                clickListener.invoke(item)
            }
        }
    }
}