package com.vixir.beprepared.dynamic;

import java.util.stream.*;

/**
 * Find the minimum number of cuts for a string such that each partition is a palindrome.
 */
public class PalindromeMinCuts {

    public static void main(String[] args) {
        PalindromeMinCuts palindromeMinCuts = new PalindromeMinCuts();
        System.out.println(palindromeMinCuts.palindromeMinCuts("googdaadpop"));
        System.out.println(palindromeMinCuts.palindromeMinCuts("abcdefghij"));
    }

    public int palindromeMinCuts(String s) {
        int length = s.length();
        boolean[][] isPalindrome = new boolean[length][length];
        int[] cutsArray = new int[length];

        IntStream.range(0, length).forEach(i -> isPalindrome[i][i] = true);

        // I want to go diagonally down-right from isPalindrome[0][0]
        // and then increment index by one after one diagonal iteration is done.
        // So that by the time I reach isPalindrome[k][k], I have the solution for isPalindrome[k-1][k-1]
        for (int i = 0; i < length; i++) {
            for (int k = 0; k < length - i; k++) {
                boolean isCurrentIndexEqual = s.charAt(k) == s.charAt(k + i);
                if (i == 0) {
                    isPalindrome[k][k + i] = true;
                } else if (i == 1) {
                    isPalindrome[k][k + i] = isCurrentIndexEqual;
                } else {
                    // check the diagonally down element in the array for palindrome
                    isPalindrome[k][k + i] = isCurrentIndexEqual && isPalindrome[k + 1][k + i - 1];
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
