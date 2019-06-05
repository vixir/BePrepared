package com.vixir.beprepared.design_pattern;

import java.util.*;

/**
 * @param <Key>   Comparable keys
 * @param <Value> Values to keep in the cache
 */
public class LRUCache<Key extends Comparable<Key>, Value> {

    /**
     * This will be our data structure for storing keys and values,
     * we are not storing the values directly but wrapping it around a doubly linked list node
     */
    private Map<Key, DNode> cacheMap;

    /**
     * Capacity of the LRU cache
     */
    private int capacity;

    /**
     * link ot the first node
     */
    private DNode first;

    /**
     * link to the last node
     */
    private DNode last;

    /**
     * @param capacity initialize LRU cache with desired capcacity
     */
    public LRUCache(int capacity) {
        this.capacity = capacity;
        cacheMap = new HashMap<>();
        first = new DNode();
        last = new DNode();
        first.right = last;
        last.left = first;
    }

    public void put(Key key, Value value) {
        DNode node = this.cacheMap.get(key);
        if (node == null) {
            node = new DNode(key, value);
            this.cacheMap.put(key, node);
            this.add(node);

            // if map size becomes larger than the given capacity,
            // then we need to remove last node and also remove it from the map
            if (cacheMap.size() > capacity) {
                DNode last = this.removeLast();
                this.cacheMap.remove(last.key);
            }
        } else {
            node.value = value;
            this.updateFirst(node);
        }
    }

    public Value get(Key key) {
        DNode node = cacheMap.get(key);
        if (node == null) {
            return null;
        }
        this.updateFirst(node);
        return node.value;
    }

    /**
     * @param node For updating first node, we need to remove the given node from the doubly linked list
     *             and then add it to right of the first
     */
    private void updateFirst(DNode node) {
        this.remove(node);
        this.add(node);
    }

    private void remove(DNode node) {
        DNode prev = node.left;
        prev.right = node.right;
        node.right.left = prev;
    }

    /**
     * @param node add is simple pointing first node to the given node and update the existing node.
     */
    private void add(DNode node) {
        node.left = first;
        node.right = first.right;

        first.right.left = node;
        first.right = node;
    }

    private DNode removeLast() {
        DNode node = last.left;
        this.remove(node);
        return node;
    }

    class DNode {
        Key key;
        Value value;
        DNode left;
        DNode right;

        public DNode() {
        }

        public DNode(Key key, Value value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        LRUCache<Integer, String> lruCache = new LRUCache<>(4);
        lruCache.put(1, "Design");
        lruCache.put(2, "Pattern");
        lruCache.put(3, "Cache");
        // [Cache, Pattern, Design]
        System.out.println(lruCache.get(2));
        // [Pattern, Cache, Design]
        lruCache.put(1, "Mapper");
        // [Mapper, Pattern, Cache]
        lruCache.put(4, "Distributed");
        // [Distributed, Mapper, Pattern, Cache]
        lruCache.put(5, "System");
        // [System, Distributed, Mapper, Pattern]
        System.out.println(lruCache.get(3));
    }

}
