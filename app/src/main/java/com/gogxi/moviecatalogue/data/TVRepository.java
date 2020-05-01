package com.gogxi.moviecatalogue.data;


import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.gogxi.moviecatalogue.data.source.entity.TV;
import com.gogxi.moviecatalogue.data.source.entity.TVResponse;
import com.gogxi.moviecatalogue.data.source.remote.ApiClient;
import com.gogxi.moviecatalogue.utils.EspressoIdlingResource;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TVRepository {
    private ApiClient client;
    private MutableLiveData<List<TV>> listTV = new MutableLiveData<>();

    public void setResultTV(String language){
        if (this.client == null){
            client = new ApiClient();
        }

        EspressoIdlingResource.increment();

        //noinspection NullableProblems
        client.getClient()
                .getTV(language)
                .enqueue(new Callback<TVResponse>() {

                    @Override
                    public void onResponse(Call<TVResponse> call, Response<TVResponse> response) {
//                        Log.d("Message", "onResponse: " + response.body());
                        TVResponse mTvResponse = response.body();
                        try {
                            if (mTvResponse != null && mTvResponse.getResults() != null){
                                List<TV> users = mTvResponse.getResults();
                                listTV.postValue(users);
                                Log.d("Message TV", "Success: " + users);
                            }
                        } catch (Exception e){
                            e.printStackTrace();
                        }
                        EspressoIdlingResource.decrement();
                    }

                    @Override
                    public void onFailure(Call<TVResponse> call, Throwable t) {
                        Log.d("Message", "onFailure: " +t.getMessage());
                        EspressoIdlingResource.decrement();
                    }
                });
    }

    public LiveData<List<TV>> getResultTV(){
        return listTV;
    }
}
