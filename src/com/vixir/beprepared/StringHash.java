package com.vixir.beprepared;

import java.util.HashMap;

class NameBean {
	private int i;

	NameBean(int i) {
		this.i = i;
	}

	@Override
	public boolean equals(Object arg0) {
		return i % 2 == 0;
	}

	@Override
	public int hashCode() {
		return i % 10;
	}
}

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
			return h; // return cached value
		}
		for (int i = 0; i < value.length; i++) {
			h = value[i] + (31 * h);
		}
		hash = h; // store cache
		return h;
	}

	public static void main(String[] args) {
		HashMap map = new HashMap();
		NameBean bean = new NameBean(1);
		NameBean bean2 = new NameBean(1);
		map.put(bean, "");
		map.put(bean2, "");
		NameBean bean3 = new NameBean(2);
		NameBean bean4 = new NameBean(2);
		map.put(bean3, "");
		map.put(bean4, "");
		System.out.println(map.size());
	}

}
