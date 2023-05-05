package com.example.netflixremake.presentation.home.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.netflixremake.data.model.Movie
import com.example.netflixremake.databinding.MovieItemBinding

class MovieAdapter(
    private val movies: List<Movie>,
    private val onItemClick: ((item: Movie, index: Int) -> Unit)? = null
) :
    RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            MovieItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = movies.size

    inner class MovieViewHolder(var binding: MovieItemBinding) :
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


