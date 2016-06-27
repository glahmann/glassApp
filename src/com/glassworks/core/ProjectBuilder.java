package com.glassworks.core;
/*
 * ProjectBuilder.java
 * 
 * TODO:
 * 	Input validation
 * 	File output
 *  Door builder
 *  ???
 */


import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * 
 * @author Garrett Lahmann
 *
 */
public class ProjectBuilder {
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		// List to hold all major object components of a job
		ArrayList<BuildObject> buildList = new ArrayList<BuildObject>();
		String repeat = "y";
		
		System.out.println("Welcome to ProjectBuilder\n");
		do {
			System.out.println("Please select an option from the menu below:");
			optionList();
			// TODO input validation
			int choice = console.nextInt();
			if(choice == 1) {
				buildFrame(console, buildList);
			} else if (choice == 2) {
				buildDoor(console, buildList);
			} else {
				repeat = "n";
			}
		} while (repeat.equalsIgnoreCase("y"));
	}
	
	/**
	 * List object builder options for user to select from.
	 */
	public static void optionList() {
		// TODO brainstorm more options
		System.out.println("1. Window \n2. Door \3. Quit");
	}
	
	/**
	 * Builds a single frame based on user dimensions and adds
	 * @param console
	 */
	public static void buildFrame(Scanner console, ArrayList<BuildObject> buildList) {
		double width = 0, height = 0;
		System.out.println();
		
		Frame frame = new Frame(width, height);
		buildList.add(frame);
	}
	
	/**
	 * Builds a single door based on user dimensions and adds
	 * @param console
	 */
	/*public static void buildDoor(Scanner console, ArrayList<BuildObject> buildList) {
		double width = 0, height = 0;
		
		System.out.println();
		
	}*/
}
