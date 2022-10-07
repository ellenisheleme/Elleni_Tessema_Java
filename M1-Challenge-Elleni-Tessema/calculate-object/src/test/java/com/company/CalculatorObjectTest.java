package com.company;

import org.junit.Before;
import org.junit.Test;
import sun.security.x509.DeltaCRLIndicatorExtension;

import static org.junit.Assert.*;

public class CalculatorObjectTest {

    private CalculatorObject calc;

    @Before
    public void setUp(){
        calc =new CalculatorObject();

    }

    @Test
    public void shouldReturnTheSumOfTwoIntegers(){
        assertEquals(2, calc.add(1, 1));
    }

    @Test
    public void shouldReturnTheDifferenceOfTwoIntegers(){
        assertEquals(-29, calc.subtraction(23, 52));
    }

    @Test
    public void shouldReturnTheMultipleOfTwoIntegers(){
        assertEquals(68, calc.multiplication(34, 2));
    }

    @Test
    public void shouldReturnTheDivisionOfTwoIntegers(){
        assertEquals(4, calc.division(12, 3));
    }

    @Test
    public void shouldReturnTheSumOfTwoDoubleNumbers(){
        String failMessage = "Expected calculator to handle double addition.";
        assertEquals(failMessage, 5.7, calc.add(3.4, 2.3), 0.0001);
    }

    @Test
    public void shouldReturnTheMultipleOfTwoDoubleNumbers(){
        String failMessage = "Expected calculator to handle double multiplication";
        assertEquals(29.48, calc.multiplication(6.7, 4.4), .0001);
    }

    @Test
    public void shouldReturnTheDifferenceOfTwoDoubleNumbers(){
        String failMessage = "Expected calculator to handle double subtraction";
        assertEquals(failMessage, 5, calc.subtraction(5.5, 0.5), 0.0001);
    }

    @Test
    public void shouldReturnTheDivisionOfTwoDoubleNumbers(){
        String failMessage = "Expected calculator to handle double division";
        assertEquals(4.9090, calc.division(10.8, 2.2), .001);
    }
}