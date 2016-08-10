/*
 * Frame.java
 * 
 * ****All units in INCHES****
 * 
 * TODO:
 *  Integrate with pocket class
 *  Figure out sub-pocket logic
 *  Improve toString() output
 *  
 *  
 */

package com.glassworks.core;

import java.util.Scanner;

/**
 * This class builds frame objects based on user given dimensions.
 * 
 * @author Garrett Lahmann
 * @version June 27, 2016
 */
public class Frame extends BuildObject {
	private int horPocketCount;
	private int vertPocketCount;
	/*
	private int jambCount;
	private int headCount;
	private int intermediateCount;
	private int sillCount;
	*/
	private double width;
	private double height;
	private Pocket[][] pockets;

	/**
	 * Construct new Frame based on width and height. Width and height input must be greater than 4.0".
	 * 
	 * @param width		horizontal dimension of a frame.
	 * @param height	vertical dimension of a a frame.
	 */
	public Frame(double width, double height) {
		this.width = width;
		this.height = height;
		horPocketCount = 1;
		vertPocketCount = 1;

		Scanner console = new Scanner(System.in);

		// Ask user if frame contains multiple pockets
		System.out.print("Does this frame have multiple pockets? \nEnter y or n: ");
		String multiPocket = console.next();

		// Get frame pocket counts for uniform frames
		// TODO Logic to deal with frames of irregular pocket arrangements (Sub-pockets!!!!!!!!!!)
		if(multiPocket.equalsIgnoreCase("y")) {
			horPocketCount = getPocketCounts("horizontal", console);
			vertPocketCount = getPocketCounts("vertical", console);
		}

		// Construct array to hold pockets
		pockets = new Pocket[horPocketCount][vertPocketCount];

		// TODO: 
		//  Logic for pocket size generator with multipockets
		//  Error when beam allowance for pocket number exceeds given dimensions i.e. too many pockets for size
		// Currently constructs pockets of equal dimensions (no irregular size allowance yet)
		double pocketWidth;
		double pocketHeight;
		for(int i = 0; i < horPocketCount; i++) {
			for(int j = vertPocketCount - 1; j >= 0; j--) {
				pocketWidth = (width - 2 * (horPocketCount + 1)) / horPocketCount;
				pocketHeight = (height - 2 * (vertPocketCount + 1)) / vertPocketCount;
				pockets[i][j] = new Pocket(pocketWidth, pocketHeight);
			}
		}

	}

	/** 
	 * 
	 * @param orientation	the axis of alignment (horizontal or vertical).
	 * @param console		a scanner to accept user input.
	 * @return 				number of pockets in a given direction.
	 */
	private int getPocketCounts(String orientation, Scanner console) {
		return checkInt("How many " + orientation + " pockets in the frame? ", console);
	}

	/**
	 * Validate a user entered integer.
	 * 
	 * @param message	a message prompting user for an integer value.
	 * @param console	a scanner to accept user input.
	 * @return val		a positive integer.
	 */
	private int checkInt(String message, Scanner console) {
		System.out.print(message);
		int val;
		do {
			// TODO: Fix repetition on first error!!!!!!!!!!!!!!!!!!!!
			while(!console.hasNextInt()) {
				System.out.println("Error: Value must be a positive integer.");
				System.out.print(message);
				console.next();
			}
			val = console.nextInt();
			console.nextLine();
		} while (val < 1);
		return val;
	}

	public double getWidth() {
		return width;
	}

	public double getHeight() {
		return height;
	}
 
	/**
	 * Return a String representation of the defining dimensions of the frame.
	 */
	public String toString() {
		StringBuilder output = new StringBuilder();
		output.append("Frame size: ");
		output.append(width);
		output.append(" x ");
		output.append(height);
		output.append("\n");
		output.append("Pockets: ");
		output.append(horPocketCount);
		output.append(" x ");
		output.append(vertPocketCount);
		output.append("\nPocket dimensions: "); // TODO: Create visual representation for all pockets.
		output.append(pockets[0][0].toString());
		return output.toString(); 
	}
	
	/**
	 * Method for unit testing of Frame class.
	 * 
	 * @param args	reads command line input.
	 */
	public static void main(String[] args) {
		Frame f1 = new Frame(45, 54.2);
		System.out.println(f1.toString());
	}
}
