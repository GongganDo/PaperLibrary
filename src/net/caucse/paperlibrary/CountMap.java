package net.caucse.paperlibrary;

import java.util.HashMap;

public class CountMap<K> extends HashMap<K, Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3751739822642300612L;
	
	public int add(K key) {
		if (this.containsKey(key)) {
			int value = this.get(key);
			return this.put(key, ++value);
		} else {
			return this.put(key, 1);
		}
	}
}
