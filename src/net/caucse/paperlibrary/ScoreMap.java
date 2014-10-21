package net.caucse.paperlibrary;

import java.util.HashMap;

public class ScoreMap<K> extends HashMap<K, Double> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8508325982320215960L;
	public double add(K key) {
		if (this.containsKey(key)) {
			double value = this.get(key);
			this.put(key, ++value);
			return value;
		} else {
			this.put(key, 1.0);
			return 1.0;
		}
	}
}
