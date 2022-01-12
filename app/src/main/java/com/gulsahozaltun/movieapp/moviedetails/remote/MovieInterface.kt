package com.gulsahozaltun.movieapp.moviedetails.remote

import com.gulsahozaltun.movieapp.moviedetails.data.MovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieInterface {


    @GET("/")
    suspend fun getAllMovies(
        @Query("s")s:String,
        @Query("page")page:Int,
        @Query("apiKey")apiKey:String
    ):Response<MovieResponse>


}