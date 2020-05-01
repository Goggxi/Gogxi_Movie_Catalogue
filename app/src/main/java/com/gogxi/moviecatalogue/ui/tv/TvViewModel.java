package com.gogxi.moviecatalogue.ui.tv;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.gogxi.moviecatalogue.data.Repository;
import com.gogxi.moviecatalogue.data.remote.entity.TV;

import java.util.List;

public class TvViewModel extends ViewModel {
    private Repository repository;

    public TvViewModel(Repository repository){
        this.repository = repository;
    }

    LiveData<List<TV>> getTv(){
        return repository.getTv();
    }
}
