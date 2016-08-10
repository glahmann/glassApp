/*
 * BinFractionConverter.java
 * 
 * TODO:
 * 	Comprehensive error handling for toDecimal() method
 * 	Deal with invalid input
 * 
 */

package com.glassworks.core;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 * This class contains methods that allow for conversion between decimal and binary fraction equivalents. The purpose
 * is to allow for easy computation, while also outputting to a format commonly used in construction trades.
 * 
 * @author Garrett Lahmann
 * @version August 5th, 2016
 */
public class BinFractionConverter {
	// An immutable table containing decimals and their fractional equivalents, accurate to
	// 32nds.
	private static final Map<Double, String> convTable = createMap();
	
	/**
	 * This method creates and returns a map containing decimals and their binary fraction
	 * equivalents up to 1/32 accuracy.
	 * 
	 * @return aMap		a map of decimal values and their equivalent binary fractions.
	 */
	private static Map<Double, String> createMap() {
		String deci = ".03125 .0625 .09375 .125 .15625 .1875 .21875 .25 .28125 .3125 .34375 " +
				".375 .40625 .4375 .46875 .5 .53125 .5625 .59375 .625 .65625 .6875 .71875 " +
				".75 .78125 .8125 .84375 .875 .90625 .9375 .96875";
		String fract = "1/32 1/16 3/32 1/8 5/32 3/16 7/32 1/4 9/32 5/16 11/32 3/8 13/32 7/16 " +
				"15/32 1/2 17/32 9/16 19/32 5/8 21/32 11/16 23/32 3/4 25/32 13/16 27/32 7/8 " +
				"29/32 15/16 31/32";
		Map<Double, String> aMap = new LinkedHashMap<Double, String>();
		Scanner deciScan = new Scanner(deci); // Create scanner for decimal string
		Scanner fractScan = new Scanner(fract); // Create scanner for fraction string
		// Populate map with decimal & fractional equivalents
		while(deciScan.hasNextDouble()) {
			aMap.put(deciScan.nextDouble(), fractScan.next());
		}
		
		// Close scanners
		deciScan.close();
		fractScan.close();
		
		return aMap;
	}
	
	/**
	 * Converts a given decimal number into its equivalent whole + binary fraction. 
	 * If fraction can be simplified, it will be. 
	 * 
	 * @param number		the decimal value to be converted.
	 * @return fraction		the converted fraction rounded to nearest 1/32.
	 */
	public static String toBinFraction (double number) {
		int num = (int) Math.floor(number);
		double decimal = number - num;
		
		if (Math.abs(decimal - 0) < .00000001) { // Return whole number if no decimal
			return num + "";
		} else if((1 - decimal) < .015625){
			return num + 1 + "";
		} else {							// Return closest fractional approximation
			LinkedList<Double> keys = new LinkedList<Double>(convTable.keySet());
			int low = 0;
			int hi = keys.size() - 1;

			// Loop until decimal comes within 1/64th of a fraction
			while (low <= hi) { 
				int idx = (hi + low)/2;
				if (Math.abs(decimal - keys.get(idx)) <= .015625) {
					return num + " " + convTable.get(keys.get(idx));
				} else if (decimal > keys.get(idx)){
					low = idx + 1;
				} else {
					hi = idx - 1;
				}
			}
			return "Error: fractional equivalent not found.";
		}			
	}
	
	/**
	 * Converts string fraction to its decimal equivalent. Fraction must be a multiple 
	 * of 1/32 and simplified where possible.
	 * 
	 * @param fraction
	 * @return decimal the decimal equivalent.
	 */
	public static Double toDecimal (String fraction) {
		double decimal = 0;
		Scanner scan = new Scanner(fraction);
		if (!scan.hasNextInt()) {
			scan.close();
			throw new IllegalArgumentException();
		} else {
			decimal += scan.nextInt();
			if (scan.hasNext()) {
				decimal += getKeyFromValue(scan.next());
			}
		}
		scan.close();
		return decimal;
	}
	
	/**
	 * This method returns a decimal corresponding to a given fraction. This fraction must
	 * be a multiple of 1/32 and simplified where possible.
	 * 
	 * @param frac		a string representing a fraction.
	 * @return			a decimal equivalent of the entered fraction.
	 */
	private static double getKeyFromValue (String frac) {
		for (Entry<Double, String> entry: convTable.entrySet()) {
			if (frac.equalsIgnoreCase(entry.getValue())) {
				return entry.getKey();
			}
		}
		return 0.0; // Return 0 if no equivalent. Should fix???
	}
	
	/**
	 * Method for unit testing.
	 * 
	 * @param args	reads command line input.
	 */
	public static void main (String[] args) {
		System.out.println(toBinFraction(50.48));
		System.out.println(toBinFraction(50.23));
		System.out.println(toBinFraction(50.0));
		System.out.println(toBinFraction(50.99));
		System.out.println(toBinFraction(50.858));
		System.out.println(toDecimal("50 15/32"));
		System.out.println(toDecimal("50 1/3")); // Incompatible fraction
		System.out.println(toDecimal("50"));	 // No fraction
		System.out.println(toDecimal("50 1/2"));
		
	}
}
