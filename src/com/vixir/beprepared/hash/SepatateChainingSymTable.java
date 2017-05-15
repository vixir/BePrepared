package com.vixir.beprepared.hash;

public class SepatateChainingSymTable<K, V> {

	private int M = 127; // number of chains Dynamic increasing code omitted
	private Node[] st = new Node[M]; // array of chains

	private static class Node {
		private Object key;
		private Object value;
		private Node next;

		public Node(Object key, Object value, Node next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}

	}

	private int hash(K key) {
		return (key.hashCode() & 0x7fffffff) % M;
	}

	public V get(K key) {
		int i = hash(key);
		for (Node x = st[i]; x != null; x = x.next) {
			if (key.equals(x.key))
				return (V) x.value;
		}
		return null;
	}

	public void put(K key, V val) {
		int i = hash(key);
		for (Node x = st[i]; x != null; x = x.next) {
			if (key.equals(x.key)) {
				x.value = val;
				return;
			}
		}
		st[i] = new Node(key, val, st[i]);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
