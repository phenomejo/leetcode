package org.example.problems.feb23;

/*
Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.

In other words, return true if one of s1's permutations is the substring of s2.
*/

/* Example 1:
Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").
*/

/* Example 2:
Input: s1 = "ab", s2 = "eidboaoo"
Output: false
*/

public class PermutationInString {

    public static void main(String[] args) {
        boolean isPermutation1 = checkInclusion("ab", "eidbaooo");
        System.out.println("output 1: "+ isPermutation1);

        boolean isPermutation2 = checkInclusion("ab", "eidboaoo");
        System.out.println("output 2: "+ isPermutation2);

        boolean isPermutation3 = checkInclusion("ab", "ab");
        System.out.println("output 3: "+ isPermutation3);

        boolean isPermutation4 = checkInclusion("abc", "bbbca");
        System.out.println("output 4: "+ isPermutation4);
    }

    public static boolean checkInclusion(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }

        if (s1.length() > s2.length()) {
            return false;
        }

        int s1Length = s1.length();
        int s2Length = s2.length();
        int[] index = new int[26];
        for (int i = 0; i < s1Length; i++) {
            index[s1.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s2Length; i++) {
            index[s2.charAt(i) - 'a']--;
            int total = i - s1Length;
            if (total >= 0) {
                index[s2.charAt(total) - 'a']++;
            }

            if (zero(index)) {
                return true;
            }
        }

        return false;
    }

    public static boolean zero(int[] index) {
        for (int j = 0; j < index.length; j++) {
            if (index[j] != 0) {
                return false;
            }
        }

        return true;
    }

}
