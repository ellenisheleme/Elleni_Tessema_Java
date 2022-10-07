package com.company;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConverterSwitchTest {

    private ConverterSwitch converterSwitch;


    @Before
        public void setUp() {
           converterSwitch = new ConverterSwitch();
    }

    @Test
    public void ShouldReturnTheCorrespondingMonth(){
        String actualVal = converterSwitch.convertMonth(13);
        String expectedVal = "";
        assertEquals(expectedVal, actualVal);
    }

    @Test
    public void ShouldReturnTheCorrespondingDay(){
        String actualVal = converterSwitch.convertDay(10);
        String  expectedVal = "";
        assertEquals(expectedVal, actualVal);
    }


}