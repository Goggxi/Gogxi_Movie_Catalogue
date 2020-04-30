package com.gogxi.moviecatalogue.data;


import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.gogxi.moviecatalogue.data.source.entity.Movie;
import com.gogxi.moviecatalogue.data.source.entity.MovieResponse;
import com.gogxi.moviecatalogue.data.source.remote.ApiClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieRepository {
    private ApiClient client;
    private MutableLiveData<List<Movie>> listMovie = new MutableLiveData<>();

    public void setResultMovie(String username){
        if (this.client == null){
            client = new ApiClient();
        }
        //noinspection NullableProblems
        client.getClient()
                .getMovie(username)
                .enqueue(new Callback<MovieResponse>() {

                    @Override
                    public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
//                        Log.d("Message", "onResponse: " + response.body());
                        MovieResponse mUsersResponse = response.body();
                        try {
                            if (mUsersResponse != null && mUsersResponse.getResults() != null){
                                List<Movie> users = mUsersResponse.getResults();
                                listMovie.postValue(users);
                                Log.d("Message", "Success: " + users);
                            }
                        } catch (Exception e){
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFailure(Call<MovieResponse> call, Throwable t) {
                        Log.d("Message", "onFailure: " +t.getMessage());
                    }
                });
    }

    public LiveData<List<Movie>> getResultMovie(){
        return listMovie;
    }
}
