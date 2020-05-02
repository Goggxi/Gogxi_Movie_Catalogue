package com.gogxi.moviecatalogue.ui.tv;

import androidx.test.espresso.IdlingRegistry;
import androidx.test.rule.ActivityTestRule;

import com.gogxi.moviecatalogue.R;
import com.gogxi.moviecatalogue.SingleFragmentActivity;
import com.gogxi.moviecatalogue.utils.EspressoIdlingResource;
import com.gogxi.moviecatalogue.utils.RVItemCountAssertion;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class TvFragmentTest {
    @Rule
    public final ActivityTestRule<SingleFragmentActivity> activityTestRule = new ActivityTestRule<>(SingleFragmentActivity.class);
    private final TvFragment tvFragment = new TvFragment();

    @Before
    public void setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.getEspressoIdlingResource());
        activityTestRule.getActivity().setFragment(tvFragment);
    }

    @After
    public void tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.getEspressoIdlingResource());
    }

    @Test
    public void loadMovies() {
        onView(withId(R.id.rv_tv)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_tv)).check(new RVItemCountAssertion(20));
    }
}