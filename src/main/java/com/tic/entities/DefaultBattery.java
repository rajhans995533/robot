package com.tic.entities;

/**
 * Bettery class
 * 
 * @author hansraj
 *
 */
public class DefaultBattery implements Battery {

	private static final int MINIMUM_WARING=15;
	private double backup;

	public DefaultBattery() {
		backup = 100;
	}

	@Override
	public void charge() {

		backup = 100;
	}

	@Override
	public boolean use(double unit) {
		backup = backup - unit;
		if(backup<MINIMUM_WARING)
			return true;
		return false;
	}

	@Override
	public double getRemaining() {
		return backup;
	}

}
