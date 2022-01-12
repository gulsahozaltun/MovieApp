package com.gulsahozaltun.movieapp.moviedetails.data

data class MovieResponse(
    val Response: String,
    val Movie: List<Movie>,
    val totalResults: String
)