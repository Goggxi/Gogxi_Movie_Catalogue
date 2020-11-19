package com.gogxi.moviecatalogue.data.remote;

import android.os.Handler;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.gogxi.moviecatalogue.data.remote.model.Movie;
import com.gogxi.moviecatalogue.data.remote.model.TV;
import com.gogxi.moviecatalogue.data.remote.response.MovieResponse;
import com.gogxi.moviecatalogue.data.remote.response.TVResponse;
import com.gogxi.moviecatalogue.utils.ApiService;
import com.gogxi.moviecatalogue.utils.EspressoIdlingResource;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.gogxi.moviecatalogue.utils.Constants.API_KEY;
import static com.gogxi.moviecatalogue.utils.Constants.LANGUAGE;
import static com.gogxi.moviecatalogue.utils.Constants.PAGE;
import static com.gogxi.moviecatalogue.utils.Constants.SERVICE_LATENCY_IN_MILLIS;

public class RemoteRepository {
    private static RemoteRepository INSTANCE;
    private ApiService apiService;

    private RemoteRepository(ApiService apiService) {
        this.apiService = apiService;
    }

    public static RemoteRepository getInstance(ApiService apiService) {
        if (INSTANCE == null) {
            INSTANCE = new RemoteRepository(apiService);
        }
        return INSTANCE;
    }

    public LiveData<ApiResponse<List<Movie>>> getMovie() {
        EspressoIdlingResource.increment();
        MutableLiveData<ApiResponse<List<Movie>>> resultMovies = new MutableLiveData<>();

        Handler handler = new Handler();
        handler.postDelayed(() -> {
            Call<MovieResponse> call = apiService.getMovie(API_KEY, LANGUAGE , PAGE);
            call.enqueue(new Callback<MovieResponse>() {
                @Override
                public void onResponse(@NonNull Call<MovieResponse> call, @NonNull Response<MovieResponse> response) {
                    if (response.body() != null) {
                        resultMovies.setValue(ApiResponse.success(response.body().getResults()));
                        if (!EspressoIdlingResource.getEspressoIdlingResource().isIdleNow()) {
                            EspressoIdlingResource.decrement();
                        }
                    }
                }

                @Override
                public void onFailure(@NotNull Call<MovieResponse> call, @NotNull Throwable t) {
                    EspressoIdlingResource.decrement();
                }
            });

        }, SERVICE_LATENCY_IN_MILLIS);

        return resultMovies;
    }

    public LiveData<ApiResponse<List<TV>>> getTv() {
        EspressoIdlingResource.increment();
        MutableLiveData<ApiResponse<List<TV>>> resultTvShow = new MutableLiveData<>();

        Handler handler = new Handler();
        handler.postDelayed(() -> {
            Call<TVResponse> call = apiService.getTv(API_KEY, LANGUAGE , PAGE);
            call.enqueue(new Callback<TVResponse>() {
                @Override
                public void onResponse(@NonNull Call<TVResponse> call, @NonNull Response<TVResponse> response) {
                    if (response.body() != null) {
                        resultTvShow.setValue(ApiResponse.success(response.body().getResults()));
                        if (!EspressoIdlingResource.getEspressoIdlingResource().isIdleNow()) {
                            EspressoIdlingResource.decrement();
                        }
                    }
                }

                @Override
                public void onFailure(@NotNull Call<TVResponse> call, @NotNull Throwable t) {
                    EspressoIdlingResource.decrement();
                }
            });

        }, SERVICE_LATENCY_IN_MILLIS);

        return resultTvShow;
    }
}
