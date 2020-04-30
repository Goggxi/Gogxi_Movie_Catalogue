package com.gogxi.moviecatalogue.data.source.remote;

import com.gogxi.moviecatalogue.data.source.entity.MovieResponse;
import com.gogxi.moviecatalogue.utils.Constants;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("/3/discover/movie?api_key=" +Constants.API_KEY )
    Call<MovieResponse> getMovie(@Query("language") String language);

    @GET("/3/discover/tv?api_key="+ Constants.API_KEY )
    Call<MovieResponse> getTV(@Query("language") String language);
}
