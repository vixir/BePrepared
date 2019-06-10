package com.vixir.beprepared.dynamic;

import java.util.stream.*;

/**
 * Find the minimum number of cuts for a string such that each partition is a palindrome.
 */
public class PalindromeMinCuts {

    public static void main(String[] args) {
        PalindromeMinCuts palindromeMinCuts = new PalindromeMinCuts();
        System.out.println(palindromeMinCuts.palindromeMinCuts("googdaadp"));
    }

    public int palindromeMinCuts(String s) {
        int length = s.length();
        boolean[][] isPalindrome = new boolean[length][length];
        int[] cutsArray = new int[length];

        IntStream.range(0, length).forEach(i -> isPalindrome[i][i] = true);

        for (int i = 2; i < length - 1; i++) {
            for (int j = 0; j < length - i + 1; j++) {
                int k = i + j - 1;
                boolean isCurrentIndexEqual = s.charAt(j) == s.charAt(k);
                if (i == 2) {
                    isPalindrome[j][k] = isCurrentIndexEqual;
                } else {
                    isPalindrome[j][k] = isCurrentIndexEqual && isPalindrome[j + 1][k - 1];
                }
            }
        }

        IntStream.range(0, length).forEach(i -> cutsArray[i] = i);

        for (int i = 0; i < length; i++) {
            if (isPalindrome[0][i]) {
                cutsArray[i] = 0;
            } else {
                for (int j = 0; j <= i; j++) {
                    if (isPalindrome[j][i]) {
                        cutsArray[i] = Math.min(cutsArray[j - 1] + 1, cutsArray[i]);
                    }
                }
            }
        }

        return cutsArray[length - 1];
    }
}
