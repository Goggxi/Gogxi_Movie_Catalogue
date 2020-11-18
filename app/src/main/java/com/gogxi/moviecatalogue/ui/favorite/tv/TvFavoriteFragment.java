package com.gogxi.moviecatalogue.ui.favorite.tv;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.gogxi.moviecatalogue.R;
import com.gogxi.moviecatalogue.viewmodel.ViewModelFactory;

public class TvFavoriteFragment extends Fragment {
    private TvFavoriteAdapter tvFavoriteAdapter;
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private TextView tvNotFound;

    public TvFavoriteFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tv_favorite, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.rv_tv_favorite);
        tvNotFound = view.findViewById(R.id.tv_not_tv_favorite);
        progressBar = view.findViewById(R.id.progress_tv_favorite);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() != null) {
            progressBar.setVisibility(View.VISIBLE);
            TvFavoriteViewModel tvFavoriteViewModel = obtainViewModel(getActivity());
            tvFavoriteAdapter = new TvFavoriteAdapter(getActivity());

            tvFavoriteViewModel.getFavoriteTv().observe(getViewLifecycleOwner(), tv -> {
                if (tv != null) {
                    switch (tv.status) {
                        case SUCCESS:
                            progressBar.setVisibility(View.GONE);
                            tvFavoriteAdapter.setTV(tv.data);
                            tvFavoriteAdapter.notifyDataSetChanged();
                            if (tvFavoriteAdapter.getItemCount() == 0){
                                tvNotFound.setVisibility(View.VISIBLE);
                            }
                            break;
                        case LOADING:
                            progressBar.setVisibility(View.VISIBLE);
                            break;
                        case ERROR:
                            tvNotFound.setVisibility(View.VISIBLE);
                            progressBar.setVisibility(View.GONE);
                            Toast.makeText(getContext(), R.string.error, Toast.LENGTH_SHORT).show();
                            break;
                    }
                }
            });

            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            recyclerView.setHasFixedSize(true);
            recyclerView.setAdapter(tvFavoriteAdapter);
        }
    }

    private static TvFavoriteViewModel obtainViewModel(FragmentActivity activity) {
        ViewModelFactory factory = ViewModelFactory.getInstance(activity.getApplication());
        return ViewModelProviders.of(activity, factory).get(TvFavoriteViewModel.class);
    }
}