package com.gogxi.moviecatalogue.utils;

import com.gogxi.moviecatalogue.data.remote.response.MovieResponse;
import com.gogxi.moviecatalogue.data.remote.response.TVResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("discover/movie")
    Call<MovieResponse> getMovie(
            @Query("api_key") String apiKey,
            @Query("language") String language,
            @Query("page") int page
    );

    @GET("discover/tv")
    Call<TVResponse> getTv(
            @Query("api_key") String apiKey,
            @Query("language") String language,
            @Query("page") int page
    );
}
