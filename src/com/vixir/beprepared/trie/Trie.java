package com.vixir.beprepared.trie;

import java.util.HashMap;
import java.util.Map;

public class Trie {

	private final TrieNode root;

	class TrieNode {
		Map<Character, TrieNode> children;
		boolean isComplete;
		
		public TrieNode() {
			children = new HashMap<>();
			isComplete = false;
		}
	}

	public Trie() {
		root = new TrieNode();
	}

	public void insert(String word) {
		TrieNode current = root;
		int length = word.length();
		for (int i = 0; i < length; i++) {
			char ch = word.charAt(i);
			TrieNode node = current.children.get(ch);
			if (node == null) {
				node = new TrieNode();
				current.children.put(ch, node);
			}
			current = node;
		}
		current.isComplete = true;
	}

	public void inserRecursive(String word) {
		insertRecursive(root, word, 0);
	}

	private void insertRecursive(TrieNode node, String word, int i) {
		if (i == word.length()) {
			node.isComplete = true;
			return;
		} else {
			char ch = word.charAt(i);
			TrieNode x = node.children.get(ch);

			// if node does not exists in map then create one and put it into
			// map
			if (x == null) {
				x = new TrieNode();
				node.children.put(ch, x);
			}
			insertRecursive(node, word, i + 1);
		}
	}

	public static void main(String... s) {
	}

}
