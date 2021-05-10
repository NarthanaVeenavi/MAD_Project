package com.example.home;

import android.content.Intent;

import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class LoginTest{

    @Rule

    public IntentsTestRule<Login> intentsTestRule = new IntentsTestRule<Login>(Login.class);

    public ActivityTestRule<Login> activityTestRule = new ActivityTestRule<>(Login.class);

    @Test
    public void testIntentMainActivity(){
        onView(withId(R.id.button_signup)).perform(click());
        intended(hasComponent(Add_Blood_Banks.class.getName()));

    }

    @Test
    public void testIntent2Login(){
        onView(withId(R.id.button8)).perform(click());
        Intent i = new Intent();
        activityTestRule.launchActivity(i);
    }



}