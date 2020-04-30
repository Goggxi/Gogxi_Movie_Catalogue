package com.gogxi.moviecatalogue.ui.tv;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.gogxi.moviecatalogue.R;
import com.gogxi.moviecatalogue.data.source.entity.TV;
import com.gogxi.moviecatalogue.viewmodel.ViewModelFactory;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class TvFragment extends Fragment {
    private RecyclerView rvTV;
    private TextView tvNotFound;
    private ProgressBar mProgressTV;
    private TVAdapter tvAdapter;

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
            ViewModelFactory factory = ViewModelFactory.getInstance();
            TvViewModel viewModel = new ViewModelProvider(this, factory).get(TvViewModel.class);

            tvAdapter = new TVAdapter();
            viewModel.setDiscoverTV(getString(R.string.lang));
            viewModel.getDiscoverTV().observe(this, getTV);
            rvTV.setLayoutManager(new LinearLayoutManager(getContext()));
            rvTV.setAdapter(tvAdapter);

            showLoading(false);
        }
    }

    private Observer<List<TV>> getTV = tvs -> {
        if (tvs != null){
            tvAdapter.setTV(tvs);
            tvAdapter.notifyDataSetChanged();
            showLoading(true);
            if (tvAdapter.getItemCount() == 0 ){
                tvNotFound.setVisibility(View.VISIBLE);
            }
        }
    };

    private void showLoading(boolean state) {
        if (state){
            mProgressTV.setVisibility(View.GONE);
        } else {
            mProgressTV.setVisibility(View.VISIBLE);
        }
    }
}
