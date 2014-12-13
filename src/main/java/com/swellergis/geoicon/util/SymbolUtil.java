package com.swellergis.geoicon.util;

public class SymbolUtil {
	private static long counter = 0;

	private SymbolUtil() {}; // Prevents instantiation
	
	public static long getCounter() {
		return counter++;
	}

}
