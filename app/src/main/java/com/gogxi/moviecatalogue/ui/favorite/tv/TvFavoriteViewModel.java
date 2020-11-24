package com.gogxi.moviecatalogue.ui.favorite.tv;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.PagedList;

import com.gogxi.moviecatalogue.data.Repository;
import com.gogxi.moviecatalogue.data.local.entity.TVEntity;
import com.gogxi.moviecatalogue.utils.Resource;

public class TvFavoriteViewModel extends ViewModel {
    private Repository repository;

    public TvFavoriteViewModel(Repository repository) {
        this.repository = repository;
    }

    LiveData<Resource<PagedList<TVEntity>>> getFavoriteTv() {
        return repository.get_favorite_tv();
    }
}
