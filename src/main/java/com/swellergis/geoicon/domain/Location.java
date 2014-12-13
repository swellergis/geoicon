package com.swellergis.geoicon.domain;

/**
 * Class defining unprojected (geographic) 3D location objects.
 * 
 * @author Shaun
 *
 */
public class Location {
	private static final String DEF_COORDINATE = "0";
	private static final int THRESHOLD_MIN_X = -180;
	private static final int THRESHOLD_MIN_Y = -90;
	private double x;
	private double y;
	private double z;
	
	/**
	 * default constructor
	 */
	public Location() {
		this(DEF_COORDINATE, DEF_COORDINATE, DEF_COORDINATE);
	}
	/**
	 * Location constructor accepting longitude (x), latitude (y), and elevation (z) parameters.
	 * 
	 * @param x
	 * @param y
	 * @param z
	 */
	public Location(String x, String y, String z) {
		verifyCoordinateInput(x, y, z);
		this.x = Double.parseDouble(x);
		this.y = Double.parseDouble(y);
		this.z = Double.parseDouble(z);
	}

	// verify client input for coordinate values are valid
	private void verifyCoordinateInput(String sx, String sy, String sz) {
		double dx = Double.parseDouble(sx);
		if (dx < THRESHOLD_MIN_X) {
			throw new IllegalArgumentException("Longitude (x) cannot be < -180. Input value: " + sx);
		}

		double dy = Double.parseDouble(sy);
		if (dy < THRESHOLD_MIN_Y) {
			throw new IllegalArgumentException("Latitude (y) cannot be < -90. Input value: " + sy);
		}
	}

	// longitude
	public double getX() {
		return x;
	}
	// latitude
	public double getY() {
		return y;
	}
	// elevation
	public double getZ() {
		return z;
	}

}
