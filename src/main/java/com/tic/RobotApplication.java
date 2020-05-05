package com.tic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tic.robot.Robot;
import com.tic.service.RobotUtility;

@SpringBootApplication
public class RobotApplication {

	public static void main(String[] args) {
		//SpringApplication.run(RobotApplication.class, args);
		Robot r = new Robot();
//		System.out.println(r.readBarcode("112225"));
//		System.out.println(r.readBarcode("112225B"));
		//r.pickWeight(1);
//		r.walkForKm(2);
//		r.walkForKm(1);
//		System.out.println(r.getRemainingBattery());
		//System.out.println(Robot.walk(5,1));
//		System.out.println(Robot.walk(4,3));
//		System.out.println(Robot.walk(2));
//		System.out.println(Robot.walk(2,12));
		System.out.println(RobotUtility.walk(3.5));
		System.out.println(RobotUtility.walk(2,3));
		System.out.println(RobotUtility.walk(2,12));
	}

}
