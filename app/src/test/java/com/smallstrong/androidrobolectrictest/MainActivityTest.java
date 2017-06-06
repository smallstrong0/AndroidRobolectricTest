package com.smallstrong.androidrobolectrictest;


import android.content.Intent;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.Shadows;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowActivity;

/**
 * Created by smallstrong on 2017/6/6.
 */

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 23, shadows = ShadowTestBean.class)

public class MainActivityTest {

    @Before
    public void setup() {
        //Todo
    }

    @Test
    public void testClick() {
        MainActivity mainActivity = Robolectric.buildActivity(MainActivity.class).create().get();
        mainActivity.findViewById(R.id.tv_first).performClick();

        // 获取对应的Shadow类
        ShadowActivity shadowActivity = Shadows.shadowOf(mainActivity);
        // 借助Shadow类获取启动下一Activity的Intent
        Intent nextIntent = shadowActivity.getNextStartedActivity();
        // 校验Intent的正确性
        Assert.assertEquals(nextIntent.getComponent().getClassName(), SecondActivity.class.getName());


    }

}
