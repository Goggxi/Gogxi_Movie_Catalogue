package com.gogxi.moviecatalogue.ui.favorite.movie;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gogxi.moviecatalogue.R;
import com.gogxi.moviecatalogue.viewmodel.ViewModelFactory;

public class MovieFavoriteFragment extends Fragment {
    private MovieFavoriteAdapter adapter;
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private TextView tvNotFound;

    public MovieFavoriteFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_favorite, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.rv_movie_favorite);
        tvNotFound = view.findViewById(R.id.tv_not_movie_favorite);
        progressBar = view.findViewById(R.id.progress_movie_favorite);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() != null) {
            progressBar.setVisibility(View.VISIBLE);
            MovieFavoriteViewModel movieFavoriteViewModel = obtainViewModel(getActivity());
            adapter = new MovieFavoriteAdapter();

            movieFavoriteViewModel.getFavoriteMovie().observe(getViewLifecycleOwner(), movie -> {
                if (movie != null) {
                    switch (movie.status) {
                        case SUCCESS:
                            progressBar.setVisibility(View.GONE);
                            adapter.setMovie(movie.data);
                            adapter.notifyDataSetChanged();
                            if (adapter.getItemCount() == 0){
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
            recyclerView.setAdapter(adapter);
        }
    }

    private static MovieFavoriteViewModel obtainViewModel(FragmentActivity activity) {
        ViewModelFactory factory = ViewModelFactory.getInstance(activity.getApplication());
        return new ViewModelProvider(activity, factory).get(MovieFavoriteViewModel.class);
    }
}