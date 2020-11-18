package com.gogxi.moviecatalogue.ui.detail;

import android.content.Context;
import android.content.Intent;

import androidx.test.espresso.IdlingRegistry;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import com.gogxi.moviecatalogue.R;
import com.gogxi.moviecatalogue.data.remote.model.Movie;
import com.gogxi.moviecatalogue.utils.DataDummy;
import com.gogxi.moviecatalogue.utils.EspressoIdlingResource;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class DetailMovieTest {
    private Movie dummyMovie = DataDummy.generateDummyMovie().get(5);

    @Rule
    public ActivityTestRule<DetailActivity> activityRule = new ActivityTestRule<DetailActivity>(DetailActivity.class) {
        @Override
        protected Intent getActivityIntent() {
            Context targetContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
            Intent result = new Intent(targetContext, DetailActivity.class);
            result.putExtra(DetailActivity.EXTRA_MOVIE, dummyMovie);
            return result;
        }
    };

    @Before
    public void setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.getEspressoIdlingResource());
    }

    @After
    public void tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.getEspressoIdlingResource());
    }

    @Test
    public void loadMovieDetail() {
        onView(withId(R.id.img_backdrop)).check(matches(isDisplayed()));
        onView(withId(R.id.img_poster)).check(matches(isDisplayed()));

        onView(withId(R.id.tv_title)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_title)).check(matches(withText(dummyMovie.getTitle())));

        onView(withId(R.id.tv_release)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_release)).check(matches(withText(dummyMovie.getReleaseDate())));

        onView(withId(R.id.tv_rate)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_rate)).check(matches(withText(String.valueOf(dummyMovie.getVoteAverage()))));

        onView(withId(R.id.tv_language)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_language)).check(matches(withText(dummyMovie.getOriginalLanguage())));

        onView(withId(R.id.tv_storyline)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_storyline)).check(matches(withText(dummyMovie.getOverview())));
    }
}