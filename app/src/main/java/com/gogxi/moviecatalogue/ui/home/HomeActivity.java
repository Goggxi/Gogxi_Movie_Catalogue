package com.gogxi.moviecatalogue.ui.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.os.Bundle;

import com.gogxi.moviecatalogue.R;
import com.gogxi.moviecatalogue.ui.favorite.FavoriteFragment;
import com.gogxi.moviecatalogue.ui.movie.MovieFragment;
import com.gogxi.moviecatalogue.ui.tv.TvFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        if (savedInstanceState == null){
            navView.setSelectedItemId(R.id.navigation_movie);
        }

    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = item -> {
        Fragment fragment;
        switch (item.getItemId()) {
            case R.id.navigation_movie:
                fragment = new MovieFragment();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container_layout, fragment, fragment.getClass().getSimpleName())
                        .commit();
                return true;
            case R.id.navigation_tv:
                fragment = new TvFragment();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container_layout, fragment, fragment.getClass().getSimpleName())
                        .commit();
                return true;
            case R.id.navigation_favorite:
                fragment = new FavoriteFragment();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container_layout, fragment, fragment.getClass().getSimpleName())
                        .commit();
                return true;
            default:
        }
        return false;
    };

}