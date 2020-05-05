package com.tic.service;

/**
 * Robot Service
 * 
 * @author hansraj
 *
 */
public interface RobotService {
	
	/**
	 * To initialize the robot
	 */
	public void startRobot();
	
	/**
	 * To walk robot for particular distance in km
	 * 
	 * @param km
	 */
	public void walk(float km);
	
	/**
	 * To walk robot for particular distance in km with certain weight
	 * 
	 * @param km
	 * @param weight
	 */
	
	public void walkWithWeight(float km,double weight);
	
	/**
	 * To display bettery statu
	 * 
	 */
	public void displayBetteryStatus();
	
	/**
	 * To read barcode
	 * @param barcode
	 */
	public void readBarcode(String barcode);
	
	
	
}
