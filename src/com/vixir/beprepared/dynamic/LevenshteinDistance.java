package com.vixir.beprepared.dynamic;

/**
 * Minimum number of add, edit and delete operations that can be performed on a string to obtain a second string
 */
public class LevenshteinDistance {

    public static int levenshteinDistance(String a, String b) {
        int[][] leven_distance = new int[a.length() + 1][b.length() + 1];
        for (int i = 0; i < a.length() + 1; i++) {
            for (int j = 0; j < b.length() + 1; j++) {
                if (i == 0 || j == 0) {
                    leven_distance[i][j] = Math.max(i, j);
                } else if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    leven_distance[i][j] = leven_distance[i - 1][j - 1];
                } else {
                    leven_distance[i][j] = Math.min(leven_distance[i - 1][j],
                            Math.min(leven_distance[i][j - 1], leven_distance[i - 1][j - 1])) + 1;
                }
            }
        }
        return leven_distance[a.length()][b.length()];
    }

}
