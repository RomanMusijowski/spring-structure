package com.learn;

public class AngryPoliceman implements Policeman {
    @Override
    public void makePeopleLeaveRoom(String message) {
        System.out.println("I'll kill all of you. Go out !");
    }
}
