package com.glassworks.core;
// 6/27: I changed your fields to match my frame class and added getters for testing.
/*
 * Glass.java
 * 
 * TODO:
 *  ???
 */

/**
 * 
 * @author Alex Merk
 * @version June 25, 2016
 *
 */
public class Glass {

	private double width;
	private double height;
		
	public Glass(double width, double height){
		this.width = width + .75;
		this.height = height + .75;
	}
	
	public double getWidth() {
		return width;
	}
	
	public double getHeight() {
		return height;
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
