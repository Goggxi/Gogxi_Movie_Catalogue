package com.gogxi.moviecatalogue.ui.home;

import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.rule.ActivityTestRule;

import com.gogxi.moviecatalogue.R;
import com.gogxi.moviecatalogue.data.source.entity.Movie;
import com.gogxi.moviecatalogue.data.source.entity.TV;
import com.gogxi.moviecatalogue.utils.DataDummy;

import org.junit.Rule;
import org.junit.Test;

import java.util.List;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class HomeActivityTest {

    private List<Movie> dummyMovie = DataDummy.generateDummyMovie();
    private List<TV> dummyTV = DataDummy.generateDummyTV();

    @Rule
    public ActivityTestRule activityRule = new ActivityTestRule<>(HomeActivity.class);

    @Test
    public void loadMovie() {
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.scrollToPosition(dummyMovie.size()));
    }

    @Test
    public void loadDetailMovie() {
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.tv_title)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_title)).check(matches(withText(dummyMovie.get(0).getTitle())));
        onView(withId(R.id.tv_release)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_release)).check(matches(withText(dummyMovie.get(0).getReleaseDate())));
    }

    @Test
    public void loadTV() {
        onView(withText("TV Show")).perform(click());
        onView(withId(R.id.rv_tv)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_tv)).perform(RecyclerViewActions.scrollToPosition(dummyTV.size()));
    }

    @Test
    public void loadDetailTV() {
        onView(withText("TV Show")).perform(click());
        onView(withId(R.id.rv_tv)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.tv_title)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_title)).check(matches(withText(dummyTV.get(0).getName())));
        onView(withId(R.id.tv_release)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_release)).check(matches(withText(dummyTV.get(0).getFirstAirDate())));
    }
}