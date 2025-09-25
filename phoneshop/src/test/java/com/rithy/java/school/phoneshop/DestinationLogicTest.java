package com.rithy.java.school.phoneshop;



import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class DestinationLogicTest {
	@Test
	void testCanReachPump_EnoughFuel() {
		 assertTrue(DestinationLogic.zeroFuel(50, 25, 2));
	}
	 @Test
	    void testCanReachPump_MoreFuel() {
	        // 3 gallons * 25 mpg = 75 miles → more than distance
	        assertTrue(DestinationLogic.zeroFuel(60, 25, 3));
	    }

	    @Test
	    void testCannotReachPump_NotEnoughFuel() {
	        // 1 gallon * 25 mpg = 25 miles → less than distance
	        assertFalse(DestinationLogic.zeroFuel(50, 25, +1));
	    }
}
