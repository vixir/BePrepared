package com.vixir.beprepared.design_pattern;

import java.util.*;

public class LRUCache<Key extends Comparable<Key>, Value> {

    private Map<Key, DNode> cacheMap;

    private int capacity;

    private DNode first;

    private DNode last;

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
            node = new DNode();
            node.key = key;
            node.value = value;
            this.cacheMap.put(key, node);
            this.add(node);
            if (cacheMap.size() > capacity) {
                DNode last = this.removeLast();
                this.cacheMap.remove(last.key);
                capacity--;
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

    private void updateFirst(DNode node) {
        this.remove(node);
        this.add(node);
    }

    private void remove(DNode node) {
        DNode prev = node.left;
        prev.right = node.right;
        node.right.left = prev;
    }

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
