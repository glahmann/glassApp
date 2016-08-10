/*
 * Glass.java
 * 
 * TODO:
 * Check .75" addition for accuracy!!! 
 * 
 */

package com.glassworks.core;

/**
 * 
 * @author Garrett Lahmann
 * @version June 25, 2016
 *
 */
public class Glass {

	// TODO incorporate all fields
	private double width;
	private double height;
	private double depth; 		// e.g. .625, 1.0
	private double glassThickness; // e.g. .125, .25
	private String cure;		// e.g. tempered, annealed, laminated
		
	public Glass(double width, double height) {
		this.width = width + .75;
		this.height = height + .75;
	}
	
	public double getWidth() {
		return width;
	}
	
	public double getHeight() {
		return height;
	}
	
	public String toString() {
		return "Glass: " + width + "x" + height;
	}
	
	/**
	 * Method for unit testing of Glass class.
	 * 
	 * @param args	reads command line input.
	 */
	public static void main(String[] args) {
		Glass test1 = new Glass(43, 54);
		System.out.println(test1.getWidth() + " " + test1.getHeight());
	}
}
