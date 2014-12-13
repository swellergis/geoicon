package com.swellergis.geoicon.domain;

/**
 * Class defining 3D location objects.
 * 
 * @author Shaun
 *
 */
public class Location {
	private double x;
	private double y;
	private double z;
	
	// default constructor
	public Location() {
		this.x = Double.parseDouble("0.0");
		this.y = Double.parseDouble("0.0");
		this.z = Double.parseDouble("0.0");
	}
	
	// longitude
	public double getX() {
		return x;
	}
	// latitude
	public double getY() {
		return y;
	}
	// altitude
	public double getZ() {
		return z;
	}

}
