package com.company;


import javafx.concurrent.Worker;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class FarmerTest {
   Farmer farmer;
   Warrior player1;

   @Before
    public void setUp(){
       farmer = new Farmer();
       player1 = new Warrior();

       }

     @Test

    public void ShouldReturnAttackPowerlessByOne(){

       assertEquals(0,  farmer.attackAnotherCharacter(player1));

     }

}