package io.github.dunwu.algorithm.linkedlist.base;

import io.github.dunwu.algorithm.linkedlist.ListNode;
import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/shan-chu-lian-biao-de-jie-dian-lcof/">LCR 136. 删除链表的节点</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-12-18
 */
public class 删除链表的节点 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertEquals(ListNode.buildList(4, 5, 1), s.deleteNode(ListNode.buildList(4, 5, 1, 9), 9));
        Assertions.assertEquals(ListNode.buildList(4, 1, 9), s.deleteNode(ListNode.buildList(4, 5, 1, 9), 5));
        Assertions.assertEquals(ListNode.buildList(4, 5, 9), s.deleteNode(ListNode.buildList(4, 5, 1, 9), 1));
        Assertions.assertEquals(ListNode.buildList(5, 1, 9), s.deleteNode(ListNode.buildList(4, 5, 1, 9), 4));
    }

    static class Solution {

        public ListNode deleteNode(ListNode head, int val) {
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode pre = dummy;
            while (pre != null && pre.next != null) {
                ListNode cur = pre.next;
                if (cur.val == val) {
                    pre.next = cur.next;
                    pre = cur.next;
                } else {
                    pre = pre.next;
                }
            }
            return dummy.next;
        }

    }

}
