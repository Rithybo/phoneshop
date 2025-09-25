package com.rithy.java.school.phoneshop;

public class DestinationLogic {
	 public static boolean zeroFuel(double distanceToPump, double mpg, double fuelLeft) {
	        double maxDriveDistance = fuelLeft * mpg;
	        return maxDriveDistance >= distanceToPump;
	    }
}
