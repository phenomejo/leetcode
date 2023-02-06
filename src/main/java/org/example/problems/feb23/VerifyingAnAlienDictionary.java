package org.example.problems.feb23;

/*
In an alien language, surprisingly, they also use English lowercase letters, but possibly in a different order. The order of the alphabet is some permutation of lowercase letters.
Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only if the given words are sorted lexicographically in this alien language.
*/

/* Example 1:
Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
Output: true
Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
*/

/* Example 2:
Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
Output: true
Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.
*/

/* Example 3:
Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
Output: false
Explanation: The first three characters "app" match, and the second string is shorter (in size.) According to lexicographical rules "apple" > "app", because 'l' > '∅', where '∅' is defined as the blank character which is less than any other character (More info).
*/

public class VerifyingAnAlienDictionary {

    public static void main(String[] args) {
        boolean isAlenSorted1 = isAlienSorted(new String[]{"hello", "leetcode"}, "hlabcdefgijkmnopqrstuvwxyz");
        System.out.println("isAlenSorted 1 : "+ isAlenSorted1);

        boolean isAlenSorted2 = isAlienSorted(new String[]{"word", "word", "row"}, "worldabcefghijkmnpqstuvxyz");
        System.out.println("isAlenSorted 2 : "+ isAlenSorted2);

        boolean isAlenSorted3 = isAlienSorted(new String[]{"apple", "app"}, "abcdefghijklmnopqrstuvwxyz");
        System.out.println("isAlenSorted 3 : "+ isAlenSorted3);

        boolean isAlenSorted4 = isAlienSorted(new String[]{"kuvp", "q"}, "abcdefghijklmnopqrstuvwxyz");
        System.out.println("isAlenSorted 4 : "+ isAlenSorted4);

        boolean isAlenSorted5 = isAlienSorted(new String[]{"fxasxpc","dfbdrifhp","nwzgs","cmwqriv","ebulyfyve","miracx","sxckdwzv","dtijzluhts","wwbmnge","qmjwymmyox"}, "zkgwaverfimqxbnctdplsjyohu");
        System.out.println("isAlenSorted 5 : "+ isAlenSorted5);

        boolean isAlenSorted6 = isAlienSorted(new String[]{"apap", "app"}, "abcdefghijklmnopqrstuvwxyz");
        System.out.println("isAlenSorted 6 : "+ isAlenSorted6);
    }
    public static boolean isAlienSorted(String[] words, String order) {
        int[] index = new int[26];
        for (int i = 0; i < order.length(); i++) {
            // i  = charCode xx, 'a' = charCode 97
            // using human alphabet order as a reference
            index[order.charAt(i) - 'a'] = i;
        }

        for (int i = 1; i < words.length; i++) {
            String word1 = words[i - 1];
            String word2 = words[i];

            boolean flag = false;
            int minLength = Math.min(word1.length(), word2.length());
            for (int j = 0; j < minLength; j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    int indexWord1 = index[word1.charAt(j) - 'a'];
                    int indexWord2 = index[word2.charAt(j) - 'a'];
                    if (indexWord1 < indexWord2) {
                        flag = true;
                        break;
                    } else if (indexWord1 > indexWord2) {
                         return false;
                    }
                }
            }

            if (!flag && word1.length() > word2.length()) {
                return false;
            }
        }

        return true;
    }

}
