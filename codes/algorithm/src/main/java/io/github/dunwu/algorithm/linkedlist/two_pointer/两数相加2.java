package io.github.dunwu.algorithm.linkedlist.two_pointer;

import io.github.dunwu.algorithm.linkedlist.ListNode;
import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/add-two-numbers-ii/">445. 两数相加 II</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-01-21
 */
public class 两数相加2 {

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode result = s.addTwoNumbers(ListNode.buildList(7, 2, 4, 3), ListNode.buildList(5, 6, 4));
        Assertions.assertEquals(ListNode.buildList(7, 8, 0, 7), result);
        ListNode result2 = s.addTwoNumbers(ListNode.buildList(2, 4, 3), ListNode.buildList(5, 6, 4));
        Assertions.assertEquals(ListNode.buildList(8, 0, 7), result2);
        ListNode result3 = s.addTwoNumbers(ListNode.buildList(0), ListNode.buildList(0));
        Assertions.assertEquals(ListNode.buildList(0), result3);
    }

    public static class Solution {

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode r1 = reverse(l1);
            ListNode r2 = reverse(l2);
            ListNode res = doAddTwoNumbers(r1, r2);
            return reverse(res);
        }

        public ListNode reverse(ListNode head) {
            ListNode pre = null, cur = head;
            while (cur != null) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            return pre;
        }

        public ListNode doAddTwoNumbers(ListNode l1, ListNode l2) {
            // 在两条链表上的指针
            ListNode p1 = l1, p2 = l2;
            // 虚拟头结点（构建新链表时的常用技巧）
            ListNode dummy = new ListNode(-1);
            // 指针 p 负责构建新链表
            ListNode p = dummy;
            // 记录进位
            int carry = 0;
            // 开始执行加法，两条链表走完且没有进位时才能结束循环
            while (p1 != null || p2 != null || carry > 0) {

                int val = 0;
                if (p1 != null) {
                    val += p1.val;
                    p1 = p1.next;
                }
                if (p2 != null) {
                    val += p2.val;
                    p2 = p2.next;
                }
                if (carry > 0) {
                    val += carry;
                }

                carry = val / 10;
                val = val % 10;
                p.next = new ListNode(val);
                p = p.next;
            }
            return dummy.next;
        }

    }

}
