package com.company;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ConverterIfTest {

    private ConverterIf converter;

    @Before

    public void setUp() {
        converter = new ConverterIf();

    }

    @Test

    public void ShouldReturnThCorrespondingMonth(){
        String actualVal = converter.convertMonth(13);
        String  expectedVal = "please enter number between 1 and 12";
        assertEquals(expectedVal, actualVal);
    }

    @Test
    public void ShouldReturnThCorrespondingDayOfWeek(){
        String actualVal = converter.convertDay(10);
        String  expectedVal = "";
        assertEquals(expectedVal, actualVal);
    }

}
