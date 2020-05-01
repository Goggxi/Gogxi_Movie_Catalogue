package com.gogxi.moviecatalogue.di;

import com.gogxi.moviecatalogue.data.Repository;
import com.gogxi.moviecatalogue.data.remote.RemoteDataSource;
import com.gogxi.moviecatalogue.utils.ApiClient;
import com.gogxi.moviecatalogue.utils.ApiService;

public class Injection {
    public static Repository repository(){
        RemoteDataSource remoteRepository = RemoteDataSource.getInstance(ApiClient.getClient().create(ApiService.class));
        return Repository.getInstance(remoteRepository);
    }
}
