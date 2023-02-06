package org.example.problems.feb23;

/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);
*/

/* Example 1:
Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
*/

/* Example 2:
Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:
P     I    N
A   L S  I G
Y A   H R
P     I
*/

import java.util.*;
import java.util.stream.Collectors;

/* Example 3:
Input: s = "A", numRows = 1
Output: "A"
*/
public class ZigzagConversion {

    public static void main(String[] args) {
        String output1 = convert("PAYPALISHIRING", 3);
        System.out.println("output 1: "+ output1);

        String output2 = convert("PAYPALISHIRING", 4);
        System.out.println("output 2: "+ output2);

        String output3 = convert("A", 1);
        System.out.println("output 3: "+ output3);
    }

    public static String convert(String s, int numRows) {
        Map<Integer, String> map = new HashMap<>();
        int step = 0;
        int row = 0;
        for (int i = 0; i < s.length(); i++) {
            String str = String.valueOf(s.charAt(i));
            if (map.containsKey(row)) {
                String tempStr = map.get(row);
                map.replace(row, tempStr + str);
            } else {
                map.put(row, str);
            }

            if (row == 0) {
                step = 1;
            } else if (row == numRows - 1) {
                step = -1;
            }

            row += step;
        }

        StringBuilder output = new StringBuilder();
        for (Integer i : map.keySet()) {
            output.append(String.join("", map.get(i)));
        }

        return output.toString();
    }

}
