package org.example.problems.overall;

/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.
*/

/* Example 1:
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
*/

/* Example 2:
Input: nums = [3,2,4], target = 6
Output: [1,2]
*/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* Example 3:
Input: nums = [3,3], target = 6
Output: [0,1]
*/
public class TwoSum {

    public static void main(String[] args) {
        int[] output1 = twoSum(new int[]{2,7,11,15}, 9);
        System.out.println("output1: "+ Arrays.toString(output1));

        int[] output2 = twoSum(new int[]{3,2,4}, 6);
        System.out.println("output2: "+ Arrays.toString(output2));

        int[] output3 = twoSum(new int[]{3,3}, 6);
        System.out.println("output3: "+ Arrays.toString(output3));
    }

    public static int[] twoSum(int[] nums, int target) {
        int numsLength = nums.length;
        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < numsLength; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] {map.get(target - nums[i]), i};
            }

            map.put(nums[i], i);
        }
        
        return new int[]{};
    }

}
