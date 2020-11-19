package com.gogxi.moviecatalogue.ui.home;

import androidx.test.espresso.IdlingRegistry;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.rule.ActivityTestRule;

import com.gogxi.moviecatalogue.R;
import com.gogxi.moviecatalogue.utils.EspressoIdlingResource;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class HomeActivityTest {

    @Rule
    public ActivityTestRule activityRule = new ActivityTestRule<>(HomeActivity.class);

    @Before
    public void setUp(){
        IdlingRegistry.getInstance().register(EspressoIdlingResource.getEspressoIdlingResource());
    }

    @After
    public void tearDown(){
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.getEspressoIdlingResource());
    }

    @Test
    public void loadMovie() {
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()));
    }

    @Test
    public void loadDetailMovie() {
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.img_backdrop)).check(matches(isDisplayed()));
        onView(withId(R.id.img_poster)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_title)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_release)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_rate)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_language)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_storyline)).check(matches(isDisplayed()));
    }

    @Test
    public void loadFavoriteMovie() {
        onView(withId(R.id.navigation_favorite)).perform(click());
        onView(withText("Movie")).perform(click());
        onView(withId(R.id.rv_movie_favorite)).check(matches(isDisplayed()));
    }

    @Test
    public void loadTV() {
        onView(withId(R.id.navigation_tv)).perform(click());
        onView(withId(R.id.rv_tv)).check(matches(isDisplayed()));
    }

    @Test
    public void loadDetailTV() {
        onView(withId(R.id.navigation_tv)).perform(click());
        onView(withId(R.id.rv_tv)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.img_backdrop)).check(matches(isDisplayed()));
        onView(withId(R.id.img_poster)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_title)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_release)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_rate)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_language)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_storyline)).check(matches(isDisplayed()));
    }

    @Test
    public void loadFavoriteTV() {
        onView(withId(R.id.navigation_favorite)).perform(click());
        onView(withText("TV Show")).perform(click());
        onView(withId(R.id.rv_tv_favorite)).check(matches(isDisplayed()));
    }
}