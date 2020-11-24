package com.gogxi.moviecatalogue.ui.favorite;


import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.gogxi.moviecatalogue.R;
import com.gogxi.moviecatalogue.ui.favorite.movie.MovieFavoriteFragment;
import com.gogxi.moviecatalogue.ui.favorite.tv.TvFavoriteFragment;

public class FragmentPageAdapter extends FragmentPagerAdapter {
    private final Context mContext;

    private final int[] TAB_TITLES = new int[]{
            R.string.title_1,
            R.string.title_2,
    };


    FragmentPageAdapter(Context context, FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mContext = context;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new MovieFavoriteFragment();
            case 1:
                return new TvFavoriteFragment();
            default:
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

}
