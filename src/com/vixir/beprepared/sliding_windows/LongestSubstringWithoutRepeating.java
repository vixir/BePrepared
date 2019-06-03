package com.vixir.beprepared.sliding_windows;

import java.util.*;

/**
 * Length of the longest substring without repeating characters
 */
public class LongestSubstringWithoutRepeating {

    public int lengthOfLongestSubstring(String s) {
        int h = 0, l = 0, counter = 0, len = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (h < s.length()) {
            Character current = s.charAt(h);
            map.put(current, map.getOrDefault(current, 0) + 1);
            if (map.get(current) > 1) {
                counter++;
            }
            h++;
            while (counter > 0) {
                Character temp = s.charAt(l);
                if (map.get(temp) > 1) counter--;
                map.put(temp, map.get(temp) - 1);
                l++;
            }
            if (len < (h - l)) {
                len = h - l;
            }

        }
        return len;
    }


    public static void main(String[] args) {
        LongestSubstringWithoutRepeating var = new LongestSubstringWithoutRepeating();
        System.out.println(var.lengthOfLongestSubstring("abcabccbc"));
        System.out.println(var.lengthOfLongestSubstring("ccccccccc"));
        System.out.println(var.lengthOfLongestSubstring("abcccabcdef"));
        System.out.println(var.lengthOfLongestSubstring("lolololololul"));
    }
}
