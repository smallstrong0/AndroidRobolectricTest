package com.smallstrong.androidrobolectrictest;

import org.robolectric.annotation.Implementation;
import org.robolectric.annotation.Implements;
import org.robolectric.annotation.RealObject;

/**
 * Created by smallstrong on 2017/6/6.
 */

@Implements(TestBean.class)
public class ShadowTestBean {
    @RealObject
    TestBean testBean;

    public ShadowTestBean() {

    }

    @Implementation
    public String getName() {
        return "Hello, I ma shadow of RobolectricBean: " + testBean.name;
    }

    @Implementation
    public void setName(String name) {
        testBean.name = name;
    }

    @Implementation
    public int getAge() {
        return testBean.age;
    }

    @Implementation
    public void setAge(int age) {
        testBean.age = age;
    }

}
