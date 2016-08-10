/*
 * Pocket.java
 * 
 * TODO:
 *  Manage sub pockets
 *  
 */

package com.glassworks.core;

/**
 * 
 * @author Garrett Lahmann
 * @version July 12th, 2016
 *
 */
public class Pocket {
	private double width;
	private double height;
	private Glass pane;
	
	/**
	 * 
	 * @param width		vertical dimension of pocket;
	 * @param height	horizontal dimension of pocket;
	 */
	public Pocket (double width, double height) {
		this.width = width;
		this.height = height;
		
		pane = new Glass(width, height);
		
	}
	
	public double getWidth() {
		return width;
	}
	
	public double getHeight() {
		return height;
	}
	
	public String toString() {
		return  BinFractionConverter.toBinFraction(width) + " x " + 
				BinFractionConverter.toBinFraction(height) + "\n" + pane.toString();
	}
}
