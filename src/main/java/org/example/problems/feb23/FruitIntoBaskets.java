package org.example.problems.feb23;

/*
You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are represented by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.

You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:

You only have two baskets, and each basket can only hold a single type of fruit. There is no limit on the amount of fruit each basket can hold.
Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree) while moving to the right. The picked fruits must fit in one of your baskets.
Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
Given the integer array fruits, return the maximum number of fruits you can pick.
*/

/* Example 1:
Input: fruits = [1,2,1]
Output: 3
Explanation: We can pick from all 3 trees.
*/

/* Example 2:
Input: fruits = [0,1,2,2]
Output: 3
Explanation: We can pick from trees [1,2,2].
If we had started at the first tree, we would only pick from trees [0,1].
*/

/* Example 3:
Input: fruits = [1,2,3,2,2]
Output: 4
Explanation: We can pick from trees [2,3,2,2].
If we had started at the first tree, we would only pick from trees [1,2].
*/

public class FruitIntoBaskets {

    public static void main(String[] args) {
        int output1 = totalFruit(new int[]{1,2,1});
        System.out.println("output1: "+ output1);

        int output2 = totalFruit(new int[]{0,1,2,2});
        System.out.println("output2: "+ output2);

        int output3 = totalFruit(new int[]{1,2,3,2,2});
        System.out.println("output3: "+ output3);

        int output4 = totalFruit(new int[]{1,2,3,2,2, 4, 2, 2, 5,2, 2, 3});
        System.out.println("output4: "+ output4);

        int output5 = totalFruit(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3});
        System.out.println("output5: "+ output5);
    }


    // Big(O n^2)
//    public static int totalFruit(int[] fruits) {
//        int treeLength = fruits.length;
//
//        if (treeLength == 1) {
//            return 1;
//        }
//
//        int totalFruit = 0;
//        for (int i = 1; i < treeLength; i++) {
//            int basket1 = fruits[i - 1];
//            int basket2 = fruits[i];
//            int sum = 2;
//            for (int j = i + 1; j < treeLength; j++) {
//                if (basket1 == basket2) {
//                    basket2 = fruits[j];
//                } else if (basket1 != fruits[j] && basket2 != fruits[j]) {;
//                    break;
//                }
//
//                sum++;
//            }
//
//            if (sum > totalFruit) {
//                totalFruit = sum;
//            }
//
//        }
//
//        return totalFruit;
//    }

    // optimized by using two pointers b1 b2
    public static int totalFruit(int[] fruits) {
        int treeLength = fruits.length;
        int[] index = new int[treeLength];
        int b1 = 0, b2 = 0, fruitType = 0, totalFruit = 0;

        while (b1 < treeLength) {
            if (index[fruits[b1]] == 0) {
                fruitType++;
            }
            index[fruits[b1]]++;
            b1++;

            while (fruitType > 2) {
                index[fruits[b2]]--;
                if (index[fruits[b2]] == 0) {
                    fruitType--;
                }
                b2++;
            }

            totalFruit = Math.max(totalFruit, b1 - b2);
        }

        return totalFruit;
    }

}
