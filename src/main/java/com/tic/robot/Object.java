package com.tic.robot;

/**
 * class object that can be picked by robot
 * 
 * @author hansraj
 *
 */
public class Object {
	private static final String OBJECT_DEFAULT_NAME = "no name";
	private String name;
	private double weight;

	public Object() {
	}

	public Object(double weight) {
		this.weight = weight;
		this.name = OBJECT_DEFAULT_NAME;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the weight
	 */
	public double getWeight() {
		return weight;
	}

	/**
	 * @param weight the weight to set
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}

}
