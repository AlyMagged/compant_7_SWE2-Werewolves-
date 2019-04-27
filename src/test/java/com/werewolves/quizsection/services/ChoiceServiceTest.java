package com.werewolves.quizsection.services;

import org.junit.Test;

import static org.junit.Assert.*;

public class ChoiceServiceTest {

    @Test
    public void getAllChoices() {
    }

    @Test
    public void getChoiceByID() {
    }

    @Test
    public void updateChoiceByID() {
    }

    @Test
    public void deleteChoiceByID() {
    }

    @Test
    public void addChoice() {
    }

    @Test
    public void add() {
        int x = 5 , y = 2;
        ChoiceService service = new ChoiceService();
        assertEquals(7 , service.add(x , y));
    }
}