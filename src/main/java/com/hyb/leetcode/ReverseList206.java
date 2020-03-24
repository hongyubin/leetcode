package com.hyb.leetcode;

/**
 * @Author : hongyb
 * @Description
 * @Date Created  in 22:35 2020/3/10
 * 206. 反转链表
 */
public class ReverseList206 {
    public ListNode reverseList(ListNode head) {
        if(head.next == null||head.next == null)
            return head;
        //node 始终指向最后一个
        ListNode node = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
}
