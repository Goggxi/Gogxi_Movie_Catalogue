package com.gogxi.moviecatalogue.ui.tv;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.gogxi.moviecatalogue.data.TVRepository;
import com.gogxi.moviecatalogue.data.source.entity.TV;

import java.util.List;

public class TvViewModel extends ViewModel {

//    public List<TV> getTV() {
//        return DataDummy.generateDummyTV();
//    }

    private TVRepository tvRepository;

    public TvViewModel(){
        tvRepository = new TVRepository();
    }

    public void setDiscoverTV(String language){
        tvRepository.setResultTV(language);
    }

    public LiveData<List<TV>> getDiscoverTV(){
        return tvRepository.getResultTV();
    }
}
