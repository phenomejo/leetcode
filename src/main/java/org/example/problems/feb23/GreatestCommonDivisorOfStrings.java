package org.example.problems.feb23;

/*
For two strings s and t, we say "t divides s" if and only if s = t + ... + t (i.e., t is concatenated with itself one or more times).
Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.
*/

/* Example 1:
Input: str1 = "ABCABC", str2 = "ABC"
Output: "ABC"
*/

/* Example 2:
Input: str1 = "ABABAB", str2 = "ABAB"
Output: "AB"
*/

/* Example 3:
Input: str1 = "LEET", str2 = "CODE"
Output: ""
*/
public class GreatestCommonDivisorOfStrings {

    public static void main(String[] args) {
        String outputEx1 = gcdOfStrings("ABCABC", "ABC");
        System.out.println("output 1: "+ outputEx1);

        String outputEx2 = gcdOfStrings("ABABAB", "ABAB");
        System.out.println("output 2: "+ outputEx2);

        String outputEx3 = gcdOfStrings("LEET", "CODE");
        System.out.println("output 3: "+ outputEx3);
    }

    public static String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }

        int gcd = gcd(str1.length(), str2.length());
        return str1.substring(0, gcd);
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

}
