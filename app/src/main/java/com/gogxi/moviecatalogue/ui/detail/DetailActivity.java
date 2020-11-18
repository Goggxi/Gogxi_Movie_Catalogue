package com.gogxi.moviecatalogue.ui.detail;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProviders;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.gogxi.moviecatalogue.R;
import com.gogxi.moviecatalogue.data.local.entity.MovieEntity;
import com.gogxi.moviecatalogue.data.local.entity.TVEntity;
import com.gogxi.moviecatalogue.ui.movie.MovieViewModel;
import com.gogxi.moviecatalogue.utils.Constants;
import com.gogxi.moviecatalogue.viewmodel.ViewModelFactory;

import org.jetbrains.annotations.NotNull;

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
    private Button mButtonFavorite;
    MovieViewModel movieViewModel;
    private Menu menu;
    private Context mContext;

    @SuppressLint("SetTextI18n")
    @RequiresApi(api = Build.VERSION_CODES.M)
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

        mContext = getApplicationContext();
        mTitle = findViewById(R.id.tv_title);
        mRelease = findViewById(R.id.tv_release);
        mRate = findViewById(R.id.tv_rate);
        mLanguage = findViewById(R.id.tv_language);
        mStoryline = findViewById(R.id.tv_storyline);
        mPoster = findViewById(R.id.img_poster);
        mBackdrop = findViewById(R.id.img_backdrop);
        mButtonFavorite = findViewById(R.id.btn_favorite);

        movie = getIntent().getParcelableExtra(EXTRA_MOVIE);
        tv = getIntent().getParcelableExtra(EXTRA_TV);

        if (movie != null){
            populateMovie();
        } else {
            populateTV();
        }

    }

    @Override
    public boolean onOptionsItemSelected(@NotNull MenuItem item) {
        switch (item.getItemId()) {
//            case R.id.favorite:
//                if (movie.isFavorite()) {
//                    movieViewModel = obtainViewModel();
//                    setFavoriteState(movie.isFavorite());
//                    movieViewModel.toggleMovieFavorite(movie);
//                    Toast.makeText(this, "di tambah ke favorite!", Toast.LENGTH_SHORT).show();
//                }
//                else {
//                    movieViewModel = obtainViewModel();
//                    setFavoriteState(movie.isFavorite());
//                    movieViewModel.toggleMovieFavorite(movie);
//                    Toast.makeText(this, "di hapus dari favorite!", Toast.LENGTH_SHORT).show();
//                }
//                return true;
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_favorite , menu);
//        this.menu = menu;
//        boolean state = movie.isFavorite();
//        setFavoriteState(state);
//        return true;
//    }
//
//    private void setFavoriteState(boolean state) {
//        if (menu == null) return;
//        MenuItem menuItem = menu.findItem(R.id.favorite);
//        if (state) {
//            menuItem.setIcon(ContextCompat.getDrawable(this, R.drawable.ic_favorite_false));
//        } else {
//            menuItem.setIcon(ContextCompat.getDrawable(this, R.drawable.ic_favorite_true));
//        }
//    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void populateMovie(){
        if (movie.isFavorite()){
//            boolean state = movie.isFavorite();
//            setFavoriteState(state);
            mButtonFavorite.setBackgroundResource(R.drawable.background_text_radius_after_press);
            mButtonFavorite.setTextColor(getColor(R.color.colorTextTertiary));
            mButtonFavorite.setText("  Hapus dari Favorite");
            Drawable drawableTrue = ContextCompat.getDrawable(
                    mContext,
                    R.drawable.ic_favorite_true
            );
            assert drawableTrue != null;
            drawableTrue.setBounds(
                    0, // left
                    0, // top
                    drawableTrue.getIntrinsicWidth(), // right
                    drawableTrue.getIntrinsicHeight() // bottom
            );
            mButtonFavorite.setCompoundDrawables(
                    drawableTrue, // Drawable left
                    null, // Drawable top
                    null, // Drawable right
                    null // Drawable bottom
            );
        }

        movieViewModel = obtainViewModel();
        mButtonFavorite.setOnClickListener(v -> {
            if (movie.isFavorite()) {
                mButtonFavorite.setBackgroundResource(R.drawable.background_text_radius_before_press);
                mButtonFavorite.setTextColor(getColor(R.color.colorTextTertiary));
                mButtonFavorite.setText("  Tambah Ke Favorite");
                Toast.makeText(this, "di hapus dari favorite!", Toast.LENGTH_SHORT).show();
                movieViewModel.toggleMovieFavorite(movie);
                Drawable drawableFalse = ContextCompat.getDrawable(
                        mContext,
                        R.drawable.ic_favorite_false
                );
                assert drawableFalse != null;
                drawableFalse.setBounds(
                        0, // left
                        0, // top
                        drawableFalse.getIntrinsicWidth(), // right
                        drawableFalse.getIntrinsicHeight() // bottom
                );
                mButtonFavorite.setCompoundDrawables(
                        drawableFalse, // Drawable left
                        null, // Drawable top
                        null, // Drawable right
                        null // Drawable bottom
                );
            } else {
                mButtonFavorite.setBackgroundResource(R.drawable.background_text_radius_after_press);
                mButtonFavorite.setTextColor(getColor(R.color.colorTextTertiary));
                Toast.makeText(this, "di tambah ke favorite!", Toast.LENGTH_SHORT).show();
                mButtonFavorite.setText("  Hapus dari Favorite");
                movieViewModel.toggleMovieFavorite(movie);
                Drawable drawableTrue = ContextCompat.getDrawable(
                        mContext,
                        R.drawable.ic_favorite_true
                );
                assert drawableTrue != null;
                drawableTrue.setBounds(
                        0, // left
                        0, // top
                        drawableTrue.getIntrinsicWidth(), // right
                        drawableTrue.getIntrinsicHeight() // bottom
                );
                mButtonFavorite.setCompoundDrawables(
                        drawableTrue, // Drawable left
                        null, // Drawable top
                        null, // Drawable right
                        null // Drawable bottom
                );
            }
        });

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

    private MovieViewModel obtainViewModel() {
        ViewModelFactory factory = ViewModelFactory.getInstance(getApplication());
        return ViewModelProviders.of(this, factory).get(MovieViewModel.class);
    }
}
