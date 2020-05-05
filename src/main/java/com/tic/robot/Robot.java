package com.tic.robot;

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
	private static final int MAX_WALK_CAPACITY_IN_KM = 5;

	private static final double BATTERY_REQUIRED_PER_KM_PER_KG = 2.0;

	private static final double BATTER_REQUIRED_PER_KM = 20.0;// 100/5

	// currently using DefaultBettry that can be upgrade in future
	private Battery battery;

	// assumed that in future robot can pick up multiple object with given weight
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
	public void pickObject(Object obj) {
		objects.add(obj);
	}

	/**
	 * pick a weight when object name is not required
	 * 
	 * @param weight
	 */
	public void pickWeight(double weight) {
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
			return;
		}
		if (distance > MAX_WALK_CAPACITY_IN_KM * 1000) {
			showLedDisplay("Sorry my Batery is not capable to complete this distance");
			return;
		}

		this.battery.use(batteryConsumeForWeigh(totalWeight));
		double betteryReqPerMeeters = (BATTER_REQUIRED_PER_KM / 1000);
		move(distance, betteryReqPerMeeters);

	}

	/**
	 * To walk in KMs
	 * 
	 * @param distance
	 */
	public void walkForKm(double distance) {
		double distanceInMeeters = distance * 1000;
		walkForMeeters(distanceInMeeters);
	}

	/**
	 * To get Remaining battery
	 * 
	 * @return
	 */
	public String getRemainingBattery() {
		return (int) this.battery.getRemaining() + " %";

	}

	/**
	 * To move meeter by meeter
	 * 
	 * @param distance
	 * @param betteryReqPerMeeters
	 */
	private void move(double distance, double betteryReqPerMeeters) {
		for (int i = 0; i <= distance; i++) {
			if (battery.getRemaining() <= 0) {
				System.out.println("Can't comple the task ::  Battery discharged completly ");
				break;
			}
			if (battery.use(betteryReqPerMeeters)) {
				// to show the battery is under 15%
				showRedHeadLight();

			}

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
	private double batteryConsumeForWeigh(double totalWeight) {
		return (BATTERY_REQUIRED_PER_KM_PER_KG * totalWeight);
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

}
