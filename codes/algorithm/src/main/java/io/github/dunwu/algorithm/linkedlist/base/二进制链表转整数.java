package io.github.dunwu.algorithm.linkedlist.base;

import io.github.dunwu.algorithm.linkedlist.ListNode;
import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode-cn.com/problems/convert-binary-number-in-a-linked-list-to-integer">二进制链表转整数</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-06-09
 */
public class 二进制链表转整数 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertEquals(5, s.getDecimalValue(ListNode.buildList(1, 0, 1)));
        Assertions.assertEquals(0, s.getDecimalValue(ListNode.buildList(0)));
    }

    static class Solution {

        public int getDecimalValue(ListNode head) {
            int res = 0;
            ListNode p = head;
            while (p != null) {
                res = res * 2 + p.val;
                p = p.next;
            }
            return res;
        }

    }

}
