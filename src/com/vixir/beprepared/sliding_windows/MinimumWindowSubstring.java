package com.vixir.beprepared.sliding_windows;

import java.util.*;

/*Given a string S and a string T, find the minimum window in S
which will contain all the characters in T in complexity O(n).*/
public class MinimumWindowSubstring {

    private static final String BLANK = "";

    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return BLANK;
        }

        int start = 0, end = 0, counter = 0, head = 0, length = Integer.MAX_VALUE;

        Map<Character, Integer> tMap = new HashMap<>();

        for (Character c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        counter = tMap.size();

        while (end < s.length()) {
            Character current = s.charAt(end);
            if (tMap.containsKey(current)) {
                tMap.put(current, tMap.get(current) - 1);
                if (tMap.get(current) == 0) {
                    counter--;
                }
            }
            end++;
            while (counter == 0) {
                Character first = s.charAt(start);
                if (tMap.containsKey(first)) {
                    tMap.put(first, tMap.get(first) + 1);
                    if (tMap.get(first) > 0) {
                        counter++;
                    }
                }
                if (end - start < length) {
                    length = end - start;
                    head = start;
                }
                start++;
            }
        }
        if (length == Integer.MAX_VALUE) {
            return BLANK;
        }
        return s.substring(head, head + length);
    }
}
