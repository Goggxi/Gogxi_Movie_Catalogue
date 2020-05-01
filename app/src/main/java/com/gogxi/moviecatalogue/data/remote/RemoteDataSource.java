package com.gogxi.moviecatalogue.data.remote;

import android.util.Log;

import androidx.annotation.NonNull;

import com.gogxi.moviecatalogue.data.remote.entity.Movie;
import com.gogxi.moviecatalogue.data.remote.entity.MovieResponse;
import com.gogxi.moviecatalogue.data.remote.entity.TV;
import com.gogxi.moviecatalogue.data.remote.entity.TVResponse;
import com.gogxi.moviecatalogue.utils.ApiService;
import com.gogxi.moviecatalogue.utils.EspressoIdlingResource;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.gogxi.moviecatalogue.utils.Constants.API_KEY;
import static com.gogxi.moviecatalogue.utils.Constants.LANGUAGE;
import static com.gogxi.moviecatalogue.utils.Constants.PAGE;

public class RemoteDataSource {
    private static RemoteDataSource INSTANCE;
    private ApiService apiService;

    private RemoteDataSource(ApiService apiService) {
        this.apiService = apiService;
    }

    public static RemoteDataSource getInstance(ApiService apiService){
        if (INSTANCE == null){
            INSTANCE = new RemoteDataSource(apiService);
        }
        return INSTANCE;
    }

    public void getMovie(LoadMovieCallback  callback){
        EspressoIdlingResource.increment();
        apiService.getMovie(API_KEY, LANGUAGE , PAGE).enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(@NonNull Call<MovieResponse> call, @NonNull Response<MovieResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        callback.onMovieReceived(response.body().getResults());
                        EspressoIdlingResource.decrement();
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<MovieResponse> call, @NonNull Throwable t) {
                Log.e("FAILED LOAD MOVIE", "onFailure: " + t.getMessage());
            }
        });
    }

    public void getTv(LoadTvCallback callback){
        EspressoIdlingResource.increment();
        apiService.getTv(API_KEY, LANGUAGE , PAGE).enqueue(new Callback<TVResponse>() {
            @Override
            public void onResponse(@NonNull Call<TVResponse> call, @NonNull Response<TVResponse> response) {
                if (response.body() != null){
                    callback.onTvReceived(response.body().getResults());
                    EspressoIdlingResource.decrement();
                }
            }

            @Override
            public void onFailure(@NonNull Call<TVResponse> call, @NonNull Throwable t) {
                Log.e("FAILED LOAD TV", "onFailure: " + t.getMessage());
            }
        });
    }

    public interface LoadMovieCallback {
        void onMovieReceived(List<Movie> movie);
    }

    public interface LoadTvCallback{
        void onTvReceived(List<TV> tv);
    }
}
