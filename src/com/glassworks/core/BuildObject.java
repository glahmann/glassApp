/*
 * BuildObject.java
 * 
 * TODO:
 *  Determine methods to use
 *  Determine hierarchy
 *  
 */

package com.glassworks.core;

/**
 * This class provides basic structure for each major element of a given project, e.g. frames, doors, etc.
 * ********I'm mainly using it so that we can build a list in ProjectBuilder containing all major project objects.
 * 
 * @author Garrett Lahmann
 * @version June 27, 2016
 */
public abstract class BuildObject {
	public abstract double getWidth();
	public abstract double getHeight();
}
