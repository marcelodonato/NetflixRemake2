package com.example.netflixremake.presentation.adapter.viewHolders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.netflixremake.R
import com.example.netflixremake.data.model.AdaptableItem
import com.example.netflixremake.data.model.MovieSimilar
import com.example.netflixremake.databinding.MovieItemSimilarBinding
import com.squareup.picasso.Picasso

class MovieItemSimilarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private var binding = MovieItemSimilarBinding.bind(itemView)

    fun bindWith(item: MovieSimilar, clickListener: (AdaptableItem) -> Unit) {
        with(binding) {
            Picasso.get().load(item.coverSimilarUrl).placeholder(R.drawable.placeholder_bg)
                .error(R.drawable.placeholder_bg).into(imgCoverSimilar)
            cvContainerMovieSimilar.setOnClickListener {
                clickListener.invoke(item)
            }
        }
    }
}