package com.gogxi.moviecatalogue.ui.home;


import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.gogxi.moviecatalogue.R;
import com.gogxi.moviecatalogue.ui.movie.MovieFragment;
import com.gogxi.moviecatalogue.ui.tv.TvFragment;

import java.util.Objects;

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
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new MovieFragment();
                break;
            case 1:
                fragment = new TvFragment();
                break;
            default:
        }
        return Objects.requireNonNull(fragment);
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
