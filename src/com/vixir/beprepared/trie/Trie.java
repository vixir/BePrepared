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

    /**
     * @param word inserts given ord to a trie
     */
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

    /**
     * @param word Inserts a work recursively to a trie
     */
    public void insertRecursive(String word) {
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

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode t = searchNode(word);

        if (t != null && t.isComplete)
            return true;
        else
            return false;
    }

    private TrieNode searchNode(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
			Character ch = word.charAt(i);
			if(node.children.containsKey(ch)){
			    node = node.children.get(ch);
            }else {
			    return null;
            }
        }
        return node;
    }


    public static void main(String... s) {
        Trie trie = new Trie();
        trie.insert("cat");
        trie.insert("catfish");
        trie.insert("catpaw");
        trie.insert("catwalk");
        System.out.println("Trie has Catwalk word? "+trie.search("catwalk"));
        System.out.println("Trie has Cataline word? "+trie.search("Cataline"));
        System.out.println("Trie has Catalogue word? "+trie.search("Catalogue"));
    }

}
