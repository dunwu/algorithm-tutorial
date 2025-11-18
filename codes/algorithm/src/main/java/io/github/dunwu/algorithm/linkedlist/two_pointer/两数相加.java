package io.github.dunwu.algorithm.linkedlist.two_pointer;

import io.github.dunwu.algorithm.linkedlist.ListNode;
import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/add-two-numbers/submissions/594544269/">2. 两数相加</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-06-09
 */
public class 两数相加 {

    public static void main(String[] args) {

        Solution s = new Solution();

        ListNode output1 = s.addTwoNumbers(ListNode.buildList(2, 4, 3), ListNode.buildList(5, 6, 4));
        Assertions.assertEquals(ListNode.buildList(7, 0, 8), output1);

        ListNode output2 = s.addTwoNumbers(ListNode.buildList(0), ListNode.buildList(0));
        Assertions.assertEquals(ListNode.buildList(0), output2);

        ListNode output3 = s.addTwoNumbers(ListNode.buildList(9, 9, 9, 9, 9, 9, 9), ListNode.buildList(9, 9, 9, 9));
        Assertions.assertEquals(ListNode.buildList(8, 9, 9, 9, 0, 0, 0, 1), output3);
    }

    static class Solution {

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
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
