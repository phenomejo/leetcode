package org.example.problems.feb23;

/*
Given the array nums consisting of 2n elements in the form [x1,x2,...,xn,y1,y2,...,yn].
Return the array in the form [x1,y1,x2,y2,...,xn,yn].
*/

/* Example 1:
Input: nums = [2,5,1,3,4,7], n = 3
Output: [2,3,5,4,1,7]
Explanation: Since x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 then the answer is [2,3,5,4,1,7].
*/

/* Example 2:
Input: nums = [1,2,3,4,4,3,2,1], n = 4
Output: [1,4,2,3,3,2,4,1]
 */

import java.util.Arrays;
import java.util.stream.IntStream;

/* Example 3:
Input: nums = [1,1,2,2], n = 2
Output: [1,2,1,2]
*/
public class ShuffleTheArray {

    public static void main(String[] args) {
        int[] output1 = shuffle(new int[]{2,5,1,3,4,7}, 3);
        System.out.println(Arrays.toString(output1));

        int[] output2 = shuffle(new int[]{1,2,3,4,4,3,2,1}, 4);
        System.out.println(Arrays.toString(output2));

        int[] output3 = shuffle(new int[]{1,1,2,2}, 2);
        System.out.println(Arrays.toString(output3));
    }

    public static int[] shuffle(int[] nums, int n) {
        int[] output = new int[nums.length];

        int i = 0;
        int x = 0;
        while (i < n) {
            output[x] = nums[i];
            x++;
            output[x] = nums[i + n];
            x++;

            i++;
        }

//        output = IntStream.range(0, n).flatMap(i -> IntStream.of(nums[i], nums[i + n])).toArray();

        return output;
    }
}
