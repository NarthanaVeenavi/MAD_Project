package com.example.home;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import junit.framework.TestCase;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class View_Emergency_NoticesTest extends TestCase {

    @Rule
    public ActivityTestRule<View_Emergency_Notices> emergency_noticesActivityTestRule = new ActivityTestRule<>(View_Emergency_Notices.class);

    @Test
    public void recycleTest(){
        Espresso.onView(withId(R.id.recyclerView_three)).perform(RecyclerViewActions.actionOnItemAtPosition(1,click()));
    }
}