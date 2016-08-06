package com.glassworks.core;

import java.awt.List;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/*
 * BinFractionConverter.java
 * 
 * TODO:
 * 	Determine if better to round up or down when converting to fractions
 * 	Complete toDecimal() method
 *  Debug: VERY slow!!!
 * 
 */

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
		Scanner deciScan = new Scanner(deci);
		Scanner fractScan = new Scanner(fract);
		while(deciScan.hasNextDouble()) {
			aMap.put(deciScan.nextDouble(), fractScan.next());
		}
		
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
		String fraction = "";
		
		if (Math.abs(decimal - 0) < .00000001) { // Return whole number if no decimal
			return num + "";
		} else if((1 - decimal) < .015625){
			return num + 1 + "";
		} else {							// Return closest fractional approximation
			LinkedList<Double> keys = new LinkedList<Double>(convTable.keySet());
			int low = 0;
			int hi = keys.size() - 1;

			// Loop until decimal comes within 1/64th of a fraction
			while (low <= hi) { // Fix me!!!!!!!!!!!!!!!!!!!!!
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
	 * Converts string fraction to its decimal equivalent.
	 * 
	 * @param fraction
	 * @return decimal the decimal equivalent.
	 */
	public static Double toDecimal (String fraction) {
		double decimal = 0;
		
		return decimal;
	}
	
	/**
	 * Method for unit testing.
	 * 
	 * @param args	reads command line input.
	 */
	public static void main (String[] args) {
		System.out.println(toBinFraction(50.5));
		System.out.println(toBinFraction(50.23));
		System.out.println(toBinFraction(50.0));
		System.out.println(toBinFraction(50.99));
		System.out.println(toBinFraction(50.86));
		
	}
}
