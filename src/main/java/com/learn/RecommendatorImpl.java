package com.learn;

import com.learn.annotations.InjectProperty;
import com.learn.annotations.Singelton;

@Singelton
@Deprecated
public class RecommendatorImpl implements Recommendator {
    @InjectProperty(value = "wisky")
    private String alcohol;

    public RecommendatorImpl() {
        System.out.println("recommendator was created!");

    }

    @Override
    public void recommend() {
        System.out.println("Against corona drink " + alcohol);
    }
}
