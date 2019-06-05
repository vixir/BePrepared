package com.vixir.beprepared.dynamic;

public class CountSubsequence {

    public static void main(String[] args) {
        String a = "abcabbbcabc";
        String b = "abbc";
        char[] aArr = a.toCharArray();
        char[] bArr = b.toCharArray();
        System.out.println(count(aArr, bArr, aArr.length, bArr.length));
    }

    public static int count(char[] input, char[] pattern, int aLen, int bLen) {
        int sol[][] = new int[aLen + 1][bLen + 1];

        // if both strings are empty
        for (int i = 0; i <= aLen; i++) {
            sol[i][0] = 1;
        }
        for (int i = 1; i <= aLen; i++) {
            for (int j = 1; j <= bLen; j++) {
                if (input[i - 1] == pattern[j - 1]) {
                    sol[i][j] = sol[i - 1][j] + sol[i - 1][j - 1];
                } else {
                    sol[i][j] = sol[i - 1][j];
                }
            }
        }
        return sol[aLen][bLen];
    }

}
