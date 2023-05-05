package com.example.netflixremake.presentation.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.netflixremake.data.model.Movie
import com.example.netflixremake.databinding.MovieItemSimilarBinding

class MovieSimilarAdapter(
    private val movies: List<Movie>,
    private val onItemClick: ((item: Movie, index: Int) -> Unit)? = null
) :
    RecyclerView.Adapter<MovieSimilarAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            MovieItemSimilarBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = movies.size

    inner class MovieViewHolder(var binding: MovieItemSimilarBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]

        holder.binding.apply {
            cvContainerMovie.setOnClickListener {
                onItemClick?.invoke(movie, position)
            }
        }

    }
}


