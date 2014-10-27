package net.caucse.paperlibrary;

import java.util.HashMap;

public class ScoreMap<K> extends HashMap<K, Double> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8508325982320215960L;
	public double add(K key) {
		return add(key, 1.0);
	}
	public double add(K key, double addingValue) {
		if (this.containsKey(key)) {
			double value = this.get(key);
			this.put(key, value += addingValue);
			return value;
		} else {
			this.put(key, addingValue);
			return addingValue;
		}
	}
	public double mul(K key, double mulValue) {
		if (this.containsKey(key)) {
			double value = this.get(key);
			this.put(key, value *= mulValue);
			return value;
		} else {
			this.put(key, mulValue);
			return mulValue;
		}
	}
}
