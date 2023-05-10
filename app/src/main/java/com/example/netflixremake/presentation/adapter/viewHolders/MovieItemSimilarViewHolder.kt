package com.example.netflixremake.presentation.adapter.viewHolders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.netflixremake.data.model.AdaptableItem
import com.example.netflixremake.data.model.Movie
import com.example.netflixremake.data.model.MovieSimilar
import com.example.netflixremake.databinding.MovieItemSimilarBinding

class MovieItemSimilarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private var binding = MovieItemSimilarBinding.bind(itemView)

    fun bindWith(item: MovieSimilar, clickListener: (AdaptableItem) -> Unit) {
        with(binding) {
            imgCoverSimilar.setBackgroundResource(item.coverSimilarUrl)
            cvContainerMovieSimilar.setOnClickListener {
                clickListener.invoke(item)
            }
        }
    }
}