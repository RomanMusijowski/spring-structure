package com.learn;

import com.learn.annotations.InjectByType;

/**
 * @author Evgeny Borisov
 */
@Deprecated
public class CoronaDesinfector {
    @InjectByType
    private Announcer announcer;
    @InjectByType
    private Policeman policman;

    public void start(Room room) {
        announcer.announce("Go out ");
        policman.makePeopleLeaveRoom("Got out crowd now !!!!!!!!!!!!");
        desinfect(room);
        announcer.announce("You can try to enter the root ");
    }

    private void desinfect(Room room){
        System.out.println("зачитывается молитва: 'корона изыди!' - молитва прочитана, вирус низвергнут в ад");
    }
}
