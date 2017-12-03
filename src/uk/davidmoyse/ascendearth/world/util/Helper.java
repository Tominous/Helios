package uk.davidmoyse.ascendearth.world.util;

public class Helper {

	public static <T extends Comparable<T>> T clamp(T value, T min, T max) {
		if (value.compareTo(max) == 1) {
			return max;
		}

		if (value.compareTo(min) == -1) {
			return min;
		}

		return value;
	}

	public static int getRandomNumberBetween(int max, int min) {
		return ((int) (Math.random() * (max - min))) + min;
	}

}
