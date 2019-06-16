package com.vixir.beprepared;

public class KMPSubstringSearch {

    /**
     * @return array that maintains size of prefix which is same as suffix
     */
    private int[] pattern(String s) {
        char[] cArray = s.toCharArray();
        int[] pattern = new int[cArray.length];
        int n = pattern.length;
        int i = 0;
        int j = 1;
        while (j < n) {
            // If there is a match pattern of jth index will be index of i + 1,
            // If the index at pattern string and given string doesn't match then which index to start lookup from
            if (cArray[i] == cArray[j]) {
                pattern[j] = i + 1;
                j++;
                i++;
            } else {
                if (i != 0) {
                    i = pattern[i - 1];
                } else {
                    j = j + 1;
                }
            }
        }
        return pattern;
    }

    /**
     * @param text
     * @param pattern
     * @return whether text matches given pattern
     */
    public boolean KMP(String text, String pattern) {
        int[] lps = pattern(pattern);
        char[] patternArr = pattern.toCharArray();
        char[] textArr = text.toCharArray();
        int i = 0;
        int j = 0;
        while (i < textArr.length && j < patternArr.length) {
            if (textArr[i] == patternArr[j]) {
                i++;
                j++;
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return j == patternArr.length;
    }

    public static void main(String[] args) {
        KMPSubstringSearch substringSearch = new KMPSubstringSearch();
        String pattern = new String("aabcddcddaa");
        String text = new String("aabcddcddaaaaa");
        System.out.println(substringSearch.KMP(text, pattern));
        String str = "abcxabcdabcdabcy";
        String subString = "abcdabcy";
        System.out.println(substringSearch.KMP(str, subString));
    }

}
