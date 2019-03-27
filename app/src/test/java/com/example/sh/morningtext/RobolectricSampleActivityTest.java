package com.example.sh.morningtext;

import android.content.Intent;
import android.widget.Button;

import com.example.sh.morningtext.activity.MainActivity;
import com.example.sh.morningtext.activity.WelcomeActivity;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.robolectric.Shadows.shadowOf;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 23)
public class RobolectricSampleActivityTest {

    @Test
    public void activitySkipText(){
        WelcomeActivity activity = Robolectric.setupActivity(WelcomeActivity.class);
        activity.findViewById(R.id.btn_wel).performClick();

        Intent expectedIntent  = new Intent(activity,MainActivity.class);
        Intent actualIntent = shadowOf(activity).getNextStartedActivity();

        Assert.assertEquals("WelcomeActivity",actualIntent.getComponent());

    }

}
