package com.tic;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.tic.robot.Robot;

import static org.junit.Assert.assertEquals;

@SpringBootTest
class RobotApplicationTests {
	
	
	@Test
	void contextLoads() {
	}


	@Test
	void walk5Km() {
		Robot robot=new Robot();
		robot.walkForKm(5);
		assertEquals(robot.getRemainingBattery(),"0 %");
		
	}

	
	@Test
	void walkLessthan5Km() {
		Robot robot=new Robot();
		robot.walkForKm(3);
		assertEquals(robot.getRemainingBattery(),"40 %");
		
	}
	
	
	
	@Test
	void walkMorehan0Km() {
		Robot robot=new Robot();
		robot.walkForKm(0);
		assertEquals(robot.getRemainingBattery(),"100 %");
		
	}
	
	
	@Test
	void walkMorehan6Km() {

	    PrintStream save_out=System.out;final ByteArrayOutputStream out = new ByteArrayOutputStream();System.setOut(new PrintStream(out));
	    Robot robot=new Robot();
		robot.walkForKm(6);
	    assertEquals("Sorry my Batery is not capable to complete this distance\r\n", out.toString());

	    System.setOut(save_out);
	}
	
	
	@Test
	void walkLessthan2KmWith3Kg() {
		Robot robot=new Robot();
		robot.pickWeight(3);
		robot.walkForKm(2);
		assertEquals(robot.getRemainingBattery(),"54 %");
		
	}
	
	
	@Test
	void walkWithOverWeight() {

	    PrintStream save_out=System.out;final ByteArrayOutputStream out = new ByteArrayOutputStream();System.setOut(new PrintStream(out));
	    Robot robot=new Robot();
		robot.pickWeight(12);
		robot.walkForKm(2);
	    assertEquals("Overweight\r\n", out.toString());

	    System.setOut(save_out);
	}
	
	
	
}
