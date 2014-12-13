package com.swellergis.geoicon.domain;

/**
 * Class defining unprojected (geographic) 3D location objects.
 * 
 * @author Shaun
 *
 */
public class Location {
	private static final double DEF_COORDINATE = 0;
	private double x;
	private double y;
	private double z;
	
	// default constructor
	public Location() {
		this.x = DEF_COORDINATE;
		this.y = DEF_COORDINATE;
		this.z = DEF_COORDINATE;
	}
	public Location(String x, String y, String z) {
		this.x = Double.parseDouble(x);
		this.y = Double.parseDouble(y);
		this.z = Double.parseDouble(z);
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
