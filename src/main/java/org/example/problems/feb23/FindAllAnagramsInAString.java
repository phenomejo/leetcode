package org.example.problems.feb23;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
*/

/* Example 1:
Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
*/

/* Example 2:
Input: s = "abab", p = "ab"
Output: [0,1,2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
*/
public class FindAllAnagramsInAString {

    public static void main(String[] args) {
        List<Integer> output1 = findAnagrams("cbaebabacd", "abc");
        System.out.println("output1: "+ output1);

        List<Integer> output2 = findAnagrams("abab", "ab");
        System.out.println("output2: "+ output2);
    }

    public static List<Integer> findAnagrams(String s, String p) {
        int sLength = s.length();
        int pLength = p.length();
        int[] index = new int[26];
        for (int i = 0; i < pLength; i++) {
            index[p.charAt(i) - 'a']++;
        }
        System.out.println(Arrays.toString(index));
        List<Integer> outputList = new ArrayList<>();
        for (int i = 0; i < sLength; i++) {
            index[s.charAt(i) - 'a']--;
            int total = i - pLength;
            if (total >= 0) {
                index[s.charAt(total) - 'a']++;
            }

            if (zero(index)) {
                outputList.add(total + 1);
            }
        }

        return outputList;
    }

    public static boolean zero(int[] index) {
        for (int i = 0; i < index.length; i++) {
            if (index[i] != 0) {
                return false;
            }
        }

        return true;
    }

}
