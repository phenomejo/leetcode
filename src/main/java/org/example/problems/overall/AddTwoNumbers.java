package org.example.problems.overall;

/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.
*/

/* Example 1:
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
*/

/* Example 2:
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
*/

import java.util.List;

/* Example 3:
Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]
*/
public class AddTwoNumbers {

    public static void main(String[] args) {
//        int[] output1 = addTwoNumbers(new int[]{2,4,3}, new int[]{5,6,4});

        ListNode l1 = new ListNode();
        ListNode l1Dummy = l1;
        ListNode l1Node = new ListNode(2);
        l1Dummy.next = l1Node;
        l1Dummy = l1Dummy.next;
        l1Node = new ListNode(4);
        l1Dummy.next = l1Node;
        l1Dummy = l1Dummy.next;
        l1Node = new ListNode(3);
        l1Dummy.next = l1Node;

        ListNode l2 = new ListNode();
        ListNode l2Dummy = l2;
        ListNode l2Node = new ListNode(5);
        l2Dummy.next = l2Node;
        l2Dummy = l2Dummy.next;
        l2Node = new ListNode(6);
        l2Dummy.next = l2Node;
        l2Dummy = l2Dummy.next;
        ListNode l23 = new ListNode(4);
        l2Dummy.next = l23;

        addTwoNumbers(l1, l2);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode();
        ListNode temp = dummy;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int sum = 0;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            sum += carry;
            carry = sum / 10;
            ListNode node = new ListNode(sum % 10);
            temp.next = node;
            temp = temp.next;
        }

        return dummy.next;
    }

     public static class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
}
