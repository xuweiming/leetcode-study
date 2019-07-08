package com.xu.leetcode.leetcode02;

import java.util.List;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);


        getRes(res,l1,l2,0);


        return res.next;
    }

    public void getRes(ListNode res,ListNode l1,ListNode l2,int mod) {
        if(l1==null) {
            l1 = new ListNode(0);
        }
        if(l2 == null) {
            l2 = new ListNode(0);
        }
        int sum = l1.val + l2.val + mod;
        mod = sum/10;
        res.next = new ListNode(sum%10);
        if(l1.next !=null || l2.next !=null || mod>0) {
            getRes(res.next,l1.next,l2.next,mod);
        }
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
