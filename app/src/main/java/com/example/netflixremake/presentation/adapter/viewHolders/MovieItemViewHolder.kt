package com.example.netflixremake.presentation.adapter.viewHolders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.netflixremake.R
import com.example.netflixremake.data.model.AdaptableItem
import com.example.netflixremake.data.model.Movie
import com.example.netflixremake.databinding.MovieItemBinding
import com.squareup.picasso.Picasso

class MovieItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private var binding = MovieItemBinding.bind(itemView)

    fun bindWith(item: Movie, clickListener: (AdaptableItem) -> Unit) {
        with(binding) {
            Picasso.get().load(item.coverUrl).placeholder(R.drawable.placeholder_bg)
                .error(R.drawable.placeholder_bg).into(imgCover)
            cvContainerMovie.setOnClickListener {
                val position = adapterPosition
                clickListener.invoke(item)
            }
        }

    }
}