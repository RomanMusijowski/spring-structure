package com.learn;

import com.learn.annotations.InjectByType;

import javax.annotation.PostConstruct;

public class PolicemanImpl implements Policeman {
    @InjectByType
    Recommendator recommendator;

    @PostConstruct
    public void init() {
        System.out.println(recommendator.getClass());
    }

    @Override
    public void makePeopleLeaveRoom(String message) {
        System.out.println(message);
        recommendator.recommend();
    }
}
