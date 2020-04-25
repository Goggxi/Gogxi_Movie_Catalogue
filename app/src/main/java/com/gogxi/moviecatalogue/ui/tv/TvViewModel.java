package com.gogxi.moviecatalogue.ui.tv;

import androidx.lifecycle.ViewModel;

import com.gogxi.moviecatalogue.data.TV;
import com.gogxi.moviecatalogue.utils.DataDummy;

import java.util.List;

public class TvViewModel extends ViewModel {

    public List<TV> getTV() {
        return DataDummy.generateDummyTV();
    }
}
