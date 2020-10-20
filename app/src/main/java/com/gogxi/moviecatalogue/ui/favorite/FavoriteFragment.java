package com.gogxi.moviecatalogue.ui.favorite;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.gogxi.moviecatalogue.R;
import com.gogxi.moviecatalogue.ui.home.HomeActivity;
import com.google.android.material.tabs.TabLayout;

import java.util.Objects;


public class FavoriteFragment extends Fragment {

    public FavoriteFragment(){

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        FragmentPagerAdapter mFragmentPagerAdapter = new FragmentPageAdapter(getContext(), getChildFragmentManager());
        ViewPager viewPager = view.findViewById(R.id.view_pager);
        viewPager.setAdapter(mFragmentPagerAdapter);

        TabLayout tabs = view.findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_favorite, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        Objects.requireNonNull(((HomeActivity) Objects.requireNonNull(getActivity()))
                .getSupportActionBar()).setTitle(R.string.favorite);
    }
}