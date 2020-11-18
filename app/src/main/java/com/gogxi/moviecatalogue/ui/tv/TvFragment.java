package com.gogxi.moviecatalogue.ui.tv;

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
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gogxi.moviecatalogue.R;
import com.gogxi.moviecatalogue.viewmodel.ViewModelFactory;

import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class TvFragment extends Fragment {
    private TVAdapter tvAdapter;
    private RecyclerView rvTV;
    private TextView tvNotFound;
    private ProgressBar mProgressTV;

    public TvFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tv, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvTV = view.findViewById(R.id.rv_tv);
        tvNotFound = view.findViewById(R.id.tv_not_tv);
        mProgressTV = view.findViewById(R.id.progress_tv);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() != null) {
            mProgressTV.setVisibility(View.VISIBLE);
            TvViewModel tvViewModel = obtainViewModel(getActivity());
            tvAdapter = new TVAdapter(getActivity());
            mProgressTV.setVisibility(View.VISIBLE);

            tvViewModel.setTvAction("load");
            tvViewModel.tvShows.observe(getViewLifecycleOwner(), tvShow -> {
                if (tvShow != null) {
                    switch (tvShow.status) {
                        case SUCCESS:
                            tvNotFound.setVisibility(View.GONE);
                            mProgressTV.setVisibility(View.GONE);
                            tvAdapter.setTV(tvShow.data);
                            tvAdapter.notifyDataSetChanged();
                            break;
                        case LOADING:
                            mProgressTV.setVisibility(View.VISIBLE);
                            break;
                        case ERROR:
                            tvNotFound.setVisibility(View.VISIBLE);
                            mProgressTV.setVisibility(View.GONE);
                            Toast.makeText(getContext(), "error", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }
            });
            rvTV.setLayoutManager(new LinearLayoutManager(getContext()));
            rvTV.setHasFixedSize(true);
            rvTV.setAdapter(tvAdapter);
        }
    }

    private static TvViewModel obtainViewModel(FragmentActivity activity) {
        ViewModelFactory factory = ViewModelFactory.getInstance(activity.getApplication());
        return ViewModelProviders.of(activity, factory).get(TvViewModel.class);
    }
}
