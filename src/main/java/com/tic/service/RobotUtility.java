package com.tic.service;

import org.springframework.stereotype.Service;

import com.tic.robot.Robot;

/**
 * Robot Service
 * 
 * @author hansraj
 *
 */

public class RobotUtility {
	
	
	/**
	 * method to walk 
	 * 
	 * @param distance
	 * @return reaming battery in %
	 */
	public static String walk(double distance) {
		Robot robot = new Robot();
		robot.walkForKm(distance);
		return robot.getRemainingBattery();
	}
	
	/**
	 *  method to walk with weight
	 * 
	 * @param distance
	 * @return reaming battery in %
	 */
	public static String walk(double distance,double weight) {
		Robot robot = new Robot();
		robot.pickWeight(weight);
		robot.walkForKm(distance);
		return robot.getRemainingBattery();
	}

	
	
}
