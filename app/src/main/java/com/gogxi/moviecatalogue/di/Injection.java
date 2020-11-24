package com.gogxi.moviecatalogue.di;

import android.app.Application;

import com.gogxi.moviecatalogue.data.Repository;
import com.gogxi.moviecatalogue.data.local.LocalRepository;
import com.gogxi.moviecatalogue.data.local.room.Database;
import com.gogxi.moviecatalogue.data.remote.RemoteRepository;
import com.gogxi.moviecatalogue.utils.ApiClient;
import com.gogxi.moviecatalogue.utils.ApiService;
import com.gogxi.moviecatalogue.utils.AppExecutors;

public class Injection {
    public static Repository repository(Application application) {
        Database database = (Database) Database.getINSTANCE(application);

        LocalRepository localRepository = LocalRepository.get_instance(database.databaseDao());
        RemoteRepository remoteRepository = RemoteRepository.getInstance(ApiClient.getClient().create(ApiService.class));
        AppExecutors appExecutors = new AppExecutors();
        return Repository.getInstance(localRepository, remoteRepository, appExecutors);
    }
}
