package com.sy.leetcode.easy;

/*
    You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
    You may assume the two numbers do not contain any leading zero, except the number 0 itself.
    Example:

        Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
        Output: 7 -> 0 -> 8
        Explanation: 342 + 465 = 807.
*/
public class Add2Number {
    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode results = new ListNode(0);
        int carry = 0, tmp;
        ListNode currentNode = results;
        ListNode previousNode = results;
        while (l1 != null || l2 != null) {
            if (previousNode != currentNode) previousNode.next = currentNode;
            currentNode.val += carry;
            if (l1 != null) {
                currentNode.val += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                currentNode.val += l2.val;
                l2 = l2.next;
            }
            tmp = currentNode.val;
            currentNode.val = currentNode.val % 10;
            carry = tmp / 10;
            previousNode = currentNode;
            currentNode = new ListNode(0);
        }
        if (carry > 0) {
            currentNode.val += carry;
            previousNode.next = currentNode;
        }
        return results;
    }

    public static void main(String[] args) {
        Add2Number a2n = new Add2Number();
        ListNode l1, l2, l3, l4, l5, l6;
        l1 = a2n.new ListNode(3);
        l2 = a2n.new ListNode(3);
        l3 = a2n.new ListNode(7);
        l4 = a2n.new ListNode(7);
        l5 = a2n.new ListNode(2);
        l6 = a2n.new ListNode(8);
        l1.next = l2;
        l2.next = l3;
        l4.next = l5;
        l5.next = l6;

        ListNode ret = a2n.addTwoNumbers(l1, l4);
        while (ret != null) {
            System.out.print(ret.val + " ");
            ret = ret.next;
        }
    }

}
