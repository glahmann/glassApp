/*
 * ProjectBuilder.java
 * 
 * TODO:
 * 	Input validation
 * 	File output
 *  Door builder
 *  Unit converter e.g. .5 -> 1/2"
 *  Add desired precision for user input??? Or use 16ths as standard
 *  ???
 *  
 */

package com.glassworks.core;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Builds and stores all objects for a given job.
 * 
 * @author Garrett Lahmann
 * @version July 12th, 2016
 *
 */
public class ProjectBuilder {
	
	/**
	 * Driver program for entire GlassApp. Creates a running project that stores user-entered frames and doors.
	 * 
	 * TODO: Add ability to modify post instantiation.
	 * 
	 * @param args		reads command line input.
	 */
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		// List to hold all major object components of a job
		ArrayList<BuildObject> buildList = new ArrayList<BuildObject>();
		String repeat = "y";
		
		System.out.println("Welcome to ProjectBuilder\n");
		do {
			repeat = optionList(console, buildList);
			
		} while (repeat.equalsIgnoreCase("y"));
		
		for(BuildObject b: buildList) {
			System.out.println(b + "\n");
		}
	}
	
	/**
	 * List object builder options for user to select from.
	 * 
	 * @param console 
	 * @param buildList	the list of BuildObjects composing the current project.
	 */
	public static String optionList(Scanner console, ArrayList<BuildObject> buildList) {
		// TODO brainstorm more options
		System.out.println("Please select an option from the menu below:");
		System.out.println("1. Window \n2. Door \n3. Quit");
		// TODO input validation
		int choice = console.nextInt();
		if(choice == 1) {
			buildFrame(console, buildList);
			return "y";
		} else if (choice == 2) {
			buildDoor(console, buildList);
			return "y";
		} else {
			return "n";
		}
	}
	
	/**
	 * Builds a single frame based on user dimensions and adds
	 * 
	 * @param console
	 */
	public static void buildFrame(Scanner console, ArrayList<BuildObject> buildList) {
		double width, height;
		System.out.println("Enter RO dimensions separated by a space: "); // TODO elaborate on this.
		// TODO input validation
		width = console.nextDouble();
		height = console.nextDouble();
		
		Frame frame = new Frame(width, height);
		buildList.add(frame);
	}
	
	/**
	 * Builds a single door based on user dimensions and adds 
	 * 
	 * @param console
	 */
	public static void buildDoor(Scanner console, ArrayList<BuildObject> buildList) {
		double width = 0, height = 0;
		
		System.out.println("Enter door opening dimensions separated by a space: ");
		// TODO input validation
		width = console.nextDouble();
		height = console.nextDouble();
		
		Door door = new Door(width, height);
		buildList.add(door);
		
	}
}
