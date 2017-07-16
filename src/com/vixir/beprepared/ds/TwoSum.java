package com.vixir.beprepared.ds;

import java.util.HashMap;
import java.util.Map.Entry;

public class TwoSum {
	private HashMap<Integer, Integer> map = new HashMap<>();

	public void add(Integer a) {
		int count = map.containsKey(a) ? map.get(a) : 0;
		map.put(a, count + 1);
	}

	public boolean find(Integer value) {
		for (Entry<Integer, Integer> x : map.entrySet()) {
			int num = x.getKey();
			int y = value - num;
			if (y == num) {
				// for duplicates ensure that at least two individual numbers
				if (x.getValue() >= 2) {
					return true;
				} else if (map.containsKey(y)) {
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {

	}

}
