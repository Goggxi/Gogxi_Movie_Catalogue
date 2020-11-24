package com.gogxi.moviecatalogue.ui.tv;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.gogxi.moviecatalogue.data.Repository;
import com.gogxi.moviecatalogue.data.local.entity.TVEntity;
import com.gogxi.moviecatalogue.utils.Resource;

import java.util.List;

public class TvViewModel extends ViewModel {
    private Repository repository;
    private MutableLiveData<String> tv = new MutableLiveData<>();


    public TvViewModel(Repository repository) {
        this.repository = repository;
    }

    public LiveData<Resource<List<TVEntity>>> tvShows = Transformations.switchMap(tv,
            data -> repository.get_tvs());

    void setTvAction(String action) {
        tv.setValue(action);
    }

    public void toggleTvFavorite(TVEntity tvEntity) {
        final boolean favorite = !tvEntity.isFavorite();
        repository.set_favorite_tv(tvEntity, favorite);
    }
}
