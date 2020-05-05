package com.tic.robot;

public interface Battery {

	void charge();
	/**
	 * Use given unit of battery 
	 * 
	 * @param unit
	 * @return return true if battery is need to be charge
	 */
	boolean use(double unit);
	double getRemaining();
}
