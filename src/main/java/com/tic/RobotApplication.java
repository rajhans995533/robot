package com.tic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tic.robot.Robot;
import com.tic.service.RobotUtility;

@SpringBootApplication
public class RobotApplication {

	public static void main(String[] args) {
		SpringApplication.run(RobotApplication.class, args);
		
		System.out.println(RobotUtility.walk(3.5));
		System.out.println(RobotUtility.walk(2,3));
		System.out.println(RobotUtility.walk(2,12));
	}

}
