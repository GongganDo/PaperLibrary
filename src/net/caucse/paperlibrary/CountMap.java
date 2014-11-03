package net.caucse.paperlibrary;

import java.util.HashMap;

public class CountMap<K> extends HashMap<K, Integer> {
	
	public CountMap() {
		super();
	}
	
	public CountMap(int initialCapacity) {
		super(initialCapacity);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -3751739822642300612L;
	
	public int add(K key) {
		if (this.containsKey(key)) {
			int value = this.get(key);
			this.put(key, ++value);
			return value;
		} else {
			this.put(key, 1);
			return 1;
		}
	}
}
