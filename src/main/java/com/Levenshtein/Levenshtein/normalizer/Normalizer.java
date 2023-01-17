package com.Levenshtein.Levenshtein.normalizer;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class Normalizer {
    private List<String> normalizedTitles ;

    public Normalizer() {
        this.normalizedTitles = Arrays.asList("Architect", "Software engineer", "Quantity surveyor", "Accountant");
    }

    public String normalize(String input) {
        final AtomicReference<String> closestMatch = new AtomicReference<>();
        AtomicInteger closestDistance = new AtomicInteger(Integer.MAX_VALUE);

        normalizedTitles.forEach(item ->{
            int distance = levenshteinDistance(input, item);
            if (distance < closestDistance.get()) {
                closestDistance.set(distance);
                closestMatch.set(item);
            }
        });

        return closestMatch.get();
    }

    private int levenshteinDistance(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else {
                    dp[i][j] = min(
                            dp[i - 1][j - 1] + (s1.charAt(i - 1) == s2.charAt(j - 1) ? 0 : 1),
                            dp[i - 1][j] + 1,
                            dp[i][j - 1] + 1
                    );
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }

    private int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }
}
