package com.example.sh.morningtext;

import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.example.sh.morningtext.activity.MainActivity;
import com.example.sh.morningtext.activity.WelcomeActivity;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.example.sh.morningtext", appContext.getPackageName());
    }

    @Test
    public void checkWelcomeskip(){

//        WelcomeActivity activity = Robolectric.setupActivity(WelcomeActivity.class);
//        activity.findViewById(R.id.btn_wel).performClick();
//
//        Intent expectedIntent  = new Intent(activity, MainActivity.class);
//        Intent actual = shadowOf(RuntimeEnvironment.application).getNextStartedActivity();
//
//        assertEquals(expectedIntent.getComponent(), actual.getComponent());

    }
}
