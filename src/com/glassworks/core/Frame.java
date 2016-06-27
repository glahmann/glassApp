package com.glassworks.core;
/*
 * Frame.java
 * 
 * TODO:
 *  Integrate with pocket class
 *  Figure out sub-pocket logic
 *  Improve toString() output
 *  
 */
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
	 * Construct new Frame based on width and height.
	 * 
	 * @param width
	 * @param height
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

		// TODO: Logic for pocket size generator with multipockets
		double pocketWidth;
		double pocketHeight;
		for(int i = 0; i < horPocketCount; i++) {
			for(int i = vertPocketCount - 1; i >= 0; i++) {
				pockets[i][j] = new Pocket(pocketWidth, pocketHeight);
			}
		}

	}

	/**
	 * 
	 * @param orientation
	 * @param console
	 * @return
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
		int val = -1;
		while(val < 1) {
			while(!console.hasNextInt()) {
				console.nextLine();
				System.out.println("Error: Value must be a positive integer.");
				System.out.print(message);
			}
			val = console.nextInt();
			console.nextLine();
		}
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
		return "size: " + width + "x" + height + "\npockets: " + horPocketCount + "x" + vertPocketCount; 
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
