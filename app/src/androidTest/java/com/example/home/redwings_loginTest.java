package com.example.home;

import android.content.Intent;

import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.rule.ActivityTestRule;

import junit.framework.TestCase;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.intent.Intents.intended;

public class redwings_loginTest {

    @Rule
    public ActivityTestRule<redwings_login> activityTestRule = new ActivityTestRule<>(redwings_login.class);

    @Test
    public void testIntentLogin(){
        onView(withId(R.id.button1)).perform(click());
        Intent i = new Intent();
        activityTestRule.launchActivity(i);
    }

}