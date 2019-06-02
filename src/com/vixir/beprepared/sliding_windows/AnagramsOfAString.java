package com.vixir.beprepared.sliding_windows;

import java.util.*;

/**
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
 * The order of output does not matter.
 */
public class AnagramsOfAString {
    private static final String BLANK = "";


    public List<Integer> findAnagrams(String s, String p) {
        int start = 0, end = 0, counter = 0, head = 0;

        Map<Character, Integer> tMap = new HashMap();
        List<Integer> sol = new ArrayList<>();

        if (s.length() < p.length()) {
            return sol;
        }

        for (Character c : p.toCharArray()) {
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
                if (end - start == p.length()) {
                    sol.add(start);
                }
                start++;
            }
        }
        return sol;
    }
}
