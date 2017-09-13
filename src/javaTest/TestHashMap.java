package javaTest;

import java.util.HashMap;

public class TestHashMap<K,V> extends HashMap<K, V>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	public V put(K key, V value) {
		throw new UnsupportedOperationException();
	}



}
