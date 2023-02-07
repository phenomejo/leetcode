package org.example.problems.overall;

/*
Given a string s, find the length of the longest substring without repeating characters.
*/

/* Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
*/

/* Example 2:
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
*/

import java.util.Arrays;

/* Example 3:
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        int output1 = lengthOfLongestSubstring("abcabcbb");
        System.out.println("output1: "+ output1);

        int output2 = lengthOfLongestSubstring("bbbbb");
        System.out.println("output2: "+ output2);

        int output3 = lengthOfLongestSubstring("pwwkew");
        System.out.println("output3: "+ output3);

        int output4 = lengthOfLongestSubstring("bbbbbabababababababcabcabcabcabcabcabcabcabc");
        System.out.println("output4: "+ output4);
//
        int output5 = lengthOfLongestSubstring("dvdf");
        System.out.println("output5: "+ output5);
    }

    public static int lengthOfLongestSubstring(String s) {
        int sLength = s.length();
        int[] index = new int[95];

        int max = 0;
        int r = 0, l = 0;
        for (int i = 0; i < sLength; i++) {
            int idx = s.charAt(i) - ' ';
            index[idx]++;
            r++;

            while (index[idx] > 1) {
                int jdx = s.charAt(l) - ' ';
                index[jdx]--;
                l++;
            }

            max = Math.max(max, r - l);
        }

        return max;
    }

//    public static boolean zer
}
