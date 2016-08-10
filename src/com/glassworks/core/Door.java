/*
 * Door.java
 * 
 * TODO:
 *  WHITEBOARD the following
 *  Unsure if I want it to extend Frame or be unique
 *  Extend pocket?
 *  left/right pivots?
 *  closer type... automatic?
 *  handles/push bars
 *  single/double
 *  
 */

package com.glassworks.core;

/**
 * Builds a door object inside of door frame.
 * ***********
 * 
 * @author Garrett Lahmann
 * @version June 27, 2016
 *
 */
public class Door extends BuildObject{
	
	private double width;
	private double height;
	private String pivot;
	private boolean doubleDoor;
	/**
	 * 
	 * @param width		vertical dimension of door pocket.
	 * @param height	horizontal dimension of door pocket.
	 */
	public Door(double width, double height) {
		// Frame(width, height);	maybe?
		this.width = width;
		this.height = height;
		
	}
	
	public double getWidth() {
		return width;
	}
	
	public double getHeight() {
		return height;
	}
	
	public String toString() {
		return "Door: " + BinFractionConverter.toBinFraction(width) + " x " + 
				BinFractionConverter.toBinFraction(height) + "\n";
	}
}
