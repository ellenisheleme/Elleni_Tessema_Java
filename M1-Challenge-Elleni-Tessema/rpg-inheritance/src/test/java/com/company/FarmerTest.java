package com.company;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class FarmerTest {
   Farmer farmer;
   Players player1;

   @Before
    public void setUp(){
       farmer = new Farmer();

       }

     @Test

    public void ShouldReturnAttackPowerlessByOne(){

       assertEquals(0,  farmer.attackAnotherCharacter(player1));


     }


}