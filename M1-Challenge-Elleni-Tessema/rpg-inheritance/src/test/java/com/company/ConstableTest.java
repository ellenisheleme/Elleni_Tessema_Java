package com.company;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConstableTest {
    private Constable constable;
    private Farmer farmer;

    @Before
    public void setUp(){
        constable = new Constable("Brian", true);
        farmer= new Farmer();

    }

    @Test
    public void shouldReturnTheAttackPowerIncreasedByFive(){

        int actualValue = constable.arrestCharacter(farmer);

        assertEquals(10, actualValue);
    }

}