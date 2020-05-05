package com.tic.entities;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Robot interface
 * 
 * We assume the robot can pick multiple objects at same time
 * 
 * @author hansraj
 *
 */
public class Robot {
	private static final int MAX_WEIGHT_IN_KG = 10;

	private static final double BATTERY_REQUIRED_PER_KM_PER_KG = 2.0;

	private static final double BATTER_REQUIRED_PER_KM = 20.0;// 100/5

	// currently using DefaultBettry that can be upgrade in future
	private Battery battery;
	private List<Object> objects = new ArrayList<Object>();

	public Robot() {
		if (battery == null)
			battery = new DefaultBattery();
	}

	/**
	 * Pick the object
	 * 
	 * @param obj
	 */
	void pickObject(Object obj) {
		objects.add(obj);
	}

	/**
	 * pick a weight when object name is not required
	 * 
	 * @param weight
	 */
	void pickWeight(double weight) {
		this.pickObject(new Object(weight));
	}

	/**
	 * To move distance in Meets
	 * 
	 * @param distance
	 */
	public void walkForMeeters(double distance) {
		double totalWeight = getTotalObjectsWait();
		if (totalWeight > MAX_WEIGHT_IN_KG) {
			showLedDisplay("Overweight");
//			System.out.println("Sorry i can not pick the object :: My maximum capacity is of weight :"
//					+ MAX_WEIGHT_IN_KG + " KG ");
		}
		double betteryReqPerMeeters = (BATTER_REQUIRED_PER_KM / 1000) + batteryConsumeForWeighPerMeeter(totalWeight);
		move(distance, betteryReqPerMeeters);
		// double reqBattery = betteryReqPerMeeters * betteryReqPerKm;
		/*
		 * if (battery.getRemaining() < reqBattery) { System.out.
		 * println("Sorry my battery is not enough to move the given distance with given weight "
		 * ); }
		 */

	}

	/**
	 * To walk in KMs
	 * 
	 * @param distance
	 */
	public void walk(double distance) {
		double distanceInMeeters = distance * 1000;
		walkForMeeters(distanceInMeeters);
	}
	
	/**
	 * To get Remaining battery
	 * 
	 * @return
	 */
	public double getRemainingBattery() {
		return Math.ceil(this.battery.getRemaining());
		
	}
	


	/**
	 * To move meeter by meeter
	 * 
	 * @param distance
	 * @param betteryReqPerMeeters
	 */
	private void move(double distance, double betteryReqPerMeeters) {
		for (int i = 0; i <= distance; i++) {
			if (battery.use(betteryReqPerMeeters)) {
				// to show the battery is under 15%
				showRedHeadLight();
			}

			
			System.out.println("Completed " + i + ": meeter distance");

		}

	}

	/**
	 * To show the red light on robot
	 * 
	 */
	private void showRedHeadLight() {
		System.out.println("Red Head Light On ");

	}

	/**
	 * To show the LED display on chest
	 * 
	 * @param message
	 */
	private void showLedDisplay(String message) {
		System.out.println(message);
	}

	/**
	 * 
	 * @param totalWeight
	 * @return
	 */
	private double batteryConsumeForWeighPerMeeter(double totalWeight) {
		return (BATTERY_REQUIRED_PER_KM_PER_KG * totalWeight) / 1000;
	}

	public double getTotalObjectsWait() {
		return objects.stream().mapToDouble(obj -> obj.getWeight()).sum();
	}

	
	/**
	 * To read a barcode
	 * 
	 * @param barcode
	 * @return
	 */
	public boolean readBarcode(String barcode) {
		try {
			new BigInteger(barcode);

		} catch (NumberFormatException e) {
			showLedDisplay("Scan Failure");
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		Robot r = new Robot();
//		System.out.println(r.readBarcode("112225"));
//		System.out.println(r.readBarcode("112225B"));
		r.pickWeight(1);
		r.walk(2);
		System.out.println(r.getRemainingBattery());
		
	}
}
