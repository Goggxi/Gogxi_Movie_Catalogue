package com.gogxi.moviecatalogue.ui.favorite.movie;

import androidx.test.espresso.IdlingRegistry;
import androidx.test.rule.ActivityTestRule;

import com.gogxi.moviecatalogue.R;
import com.gogxi.moviecatalogue.SingleFragmentActivity;
import com.gogxi.moviecatalogue.utils.EspressoIdlingResource;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class MovieFavoriteFragmentTest {
    @Rule
    public final ActivityTestRule<SingleFragmentActivity> activityRule = new ActivityTestRule<>(SingleFragmentActivity.class);
    private final MovieFavoriteFragment movieFavoriteFragment = new MovieFavoriteFragment();

    @Before
    public void setup() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.getEspressoIdlingResource());
        activityRule.getActivity().setFragment(movieFavoriteFragment);
    }

    @After
    public void teardown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.getEspressoIdlingResource());
    }

    @Test
    public void loadMovies() {
        onView(withId(R.id.rv_movie_favorite)).check(matches(isDisplayed()));
    }
}