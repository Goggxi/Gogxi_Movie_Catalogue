package com.gogxi.moviecatalogue.ui.tv;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gogxi.moviecatalogue.R;
import com.gogxi.moviecatalogue.viewmodel.ViewModelFactory;

import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class TvFragment extends Fragment {
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
            ViewModelFactory factory = ViewModelFactory.getInstance();
            TvViewModel viewModel = new ViewModelProvider(this, factory).get(TvViewModel.class);
            TVAdapter tvAdapter = new TVAdapter();

            viewModel.getTv().observe(this, tvs -> {
                tvAdapter.setTV(tvs);
                tvAdapter.notifyDataSetChanged();
                if (tvAdapter.getItemCount() == 0){
                    tvNotFound.setVisibility(View.VISIBLE);
                }
                showLoading(true);
            });

            rvTV.setLayoutManager(new LinearLayoutManager(getContext()));
            rvTV.setHasFixedSize(true);
            rvTV.setAdapter(new ScaleInAnimationAdapter(tvAdapter));

            showLoading(false);
        }
    }

    private void showLoading(boolean state) {
        if (state){
            mProgressTV.setVisibility(View.GONE);
        } else {
            mProgressTV.setVisibility(View.VISIBLE);
        }
    }
}
