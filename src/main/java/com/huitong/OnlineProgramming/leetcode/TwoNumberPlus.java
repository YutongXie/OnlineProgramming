package com.huitong.OnlineProgramming.leetcode;


import java.math.BigInteger;

//
//给出两个 非空 的链表用来表示两个非负的整数。其中，
// 它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 
// 一位 数字。
//  如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
//  您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
//  示例：
//
//  输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//  输出：7 -> 0 -> 8
//  原因：342 + 465 = 807
public class TwoNumberPlus {
    public static void main(String[] args) {
        TwoNumberPlus twoNumberPlus = new TwoNumberPlus();
        ListNode ln1 = new ListNode(2);
        ListNode ln2 = new ListNode(4);
        ListNode ln3 = new ListNode(3);
        ln1.next = ln2;
        ln2.next  = ln3;

        ListNode ln11 = new ListNode(5);
        ListNode ln12 = new ListNode(6);
        ListNode ln13 = new ListNode(4);
        ln11.next = ln12;
        ln12.next  = ln13;

        ListNode node = twoNumberPlus.addTwoNumbers(ln1, ln11);
        System.out.println(node);
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String s1 = extractListNodeStr(l1);
        String s2 = extractListNodeStr(l2);
        BigInteger n1 = new BigInteger(reverse(s1));
        BigInteger n2 = new BigInteger(reverse(s2));

        BigInteger finalNum = n1.add(n2);
        char[] numArray = String.valueOf(finalNum).toCharArray();
        ListNode firstNode = null;
        ListNode lastNode = null;
        for (int i = numArray.length -1; i >= 0; i--) {
            ListNode node = new ListNode(Integer.valueOf(numArray[i] - 48));
            if(lastNode != null) {
                lastNode.next = node;
            }
            if(i == numArray.length -1) {
                firstNode = node;
            }
            lastNode = node;
        }
        return firstNode;
    }

    private String reverse(String s) {
        char[] s1Array = s.toCharArray();
        int[] intArray = new int[s1Array.length];
        StringBuilder sb = new StringBuilder();
        for (int i = s1Array.length -1; i >= 0; i--) {
            sb.append(s1Array[i]);
        }
        return sb.toString();
    }

    private String extractListNodeStr(ListNode l1) {
        StringBuilder sb1 = new StringBuilder();
        sb1.append(l1.val);
        ListNode tempNode = l1.next;
        while(tempNode != null) {
            sb1.append(tempNode.val);
            tempNode = tempNode.next;
        }
        return sb1.toString();
    }

    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
}
