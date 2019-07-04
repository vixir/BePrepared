package com.vixir.beprepared.string;

/**
 * Find how many elements we need to cut from the end of given string, which when added to the beginning makes the string palindrome
 * Example:
 * string  = "abaaa"
 * 0 1 2 3   4
 * a b a a | a
 * 4   0 1 2 3
 * a | a b c c is a palindrome
 * Ans = 1 element from last
 */
public class PrefixCutPalindrome {

    private static final String FILLER = "$";

    /**
     * @return array that maintains size of prefix which is same as suffix
     */
    private static int[] pattern(String s) {
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
     * @param input input String
     * @return -1 -> if there is no palindrome possible
     * index of the cut element if palindrome is possible
     */
    private static int findCutPalindrome(String input) {
        if (input == null || input.length() == 0) {
            return -1;
        }
        String modifiedInput = input.concat(FILLER).concat(new StringBuffer(input).reverse().toString());
        int[] pattern = pattern(modifiedInput);
        int lastIndex = pattern[pattern.length - 1];
        if (isPalindrome(input.substring(lastIndex))) {
            return (input.length() - lastIndex) / 2;
        }
        return -1;
    }

    private static boolean isPalindrome(String input) {
        return input.equals(new StringBuffer(input).reverse().toString());
    }

    public static void main(String[] args) {
        System.out.println(findCutPalindrome("abaaa"));
        System.out.println(findCutPalindrome("baabcddddddc"));
        System.out.println(findCutPalindrome("AACEEECAAAACCAA"));
    }

}
