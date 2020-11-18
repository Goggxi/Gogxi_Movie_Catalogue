package com.gogxi.moviecatalogue.ui.detail;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.gogxi.moviecatalogue.R;
import com.gogxi.moviecatalogue.data.local.entity.MovieEntity;
import com.gogxi.moviecatalogue.data.local.entity.TVEntity;
import com.gogxi.moviecatalogue.utils.Constants;

public class DetailActivity extends AppCompatActivity {
    public static final String  EXTRA_MOVIE = "extra_movie";
    public static final String EXTRA_TV = "extra_tv";
    private MovieEntity movie;
    private TVEntity tv;
    private TextView mTitle;
    private TextView mRelease;
    private TextView mRate;
    private TextView mLanguage;
    private TextView mStoryline;
    private ImageView mPoster;
    private ImageView mBackdrop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle(R.string.detail);
        }

        mTitle = findViewById(R.id.tv_title);
        mRelease = findViewById(R.id.tv_release);
        mRate = findViewById(R.id.tv_rate);
        mLanguage = findViewById(R.id.tv_language);
        mStoryline = findViewById(R.id.tv_storyline);
        mPoster = findViewById(R.id.img_poster);
        mBackdrop = findViewById(R.id.img_backdrop);

        movie = getIntent().getParcelableExtra(EXTRA_MOVIE);
        tv = getIntent().getParcelableExtra(EXTRA_TV);

        if (movie != null){
            populateMovie();
        } else {
            populateTV();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void populateMovie(){
        mTitle.setText(movie.getTitle());
        mRelease.setText(movie.getRelease_date());
        mRate.setText(movie.getVote_average());
        mLanguage.setText(movie.getOriginal_language());
        mStoryline.setText(movie.getOverview());
        Glide.with(this)
                .load(Constants.POSTER_URL + movie.getPoster_path())
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
                .into(mPoster);
        Glide.with(this)
                .load(Constants.BACKDROP_URL + movie.getBackdrop_path())
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
                .into(mBackdrop);
    }

    private void populateTV(){
        mTitle.setText(tv.getName());
        mRelease.setText(tv.getFirst_air_date());
        mRate.setText(tv.getVote_average());
        mLanguage.setText(tv.getOriginal_language());
        mStoryline.setText(tv.getOverview());
        Glide.with(this)
                .load(Constants.POSTER_URL + tv.getPoster_path())
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
                .into(mPoster);
        Glide.with(this)
                .load(Constants.BACKDROP_URL + tv.getBackdrop_path())
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
                .into(mBackdrop);
    }
}
