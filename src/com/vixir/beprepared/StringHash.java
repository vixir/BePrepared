package com.vixir.beprepared;

public class StringHash {

	private int hash = 0;
	private final char[] value;
	private String s;

	// How to properly implement hashing with cache.
	public StringHash(String s) {
		this.s = s;
		value = s.toCharArray();
	}

	public int hashCode() {
		int h = hash;
		if (h != 0) {
			return h;											// return cached value
		}
		for (int i = 0; i < value.length; i++) {
			h = value[i] + (31 * h);
		}
		hash = h;											    // store cache	
		return h;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
