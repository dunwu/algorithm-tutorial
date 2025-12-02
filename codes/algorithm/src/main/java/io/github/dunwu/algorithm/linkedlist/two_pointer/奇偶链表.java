package io.github.dunwu.algorithm.linkedlist.two_pointer;

import io.github.dunwu.algorithm.linkedlist.ListNode;
import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/odd-even-linked-list/">328. 奇偶链表</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-07-08
 */
public class 奇偶链表 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertEquals(ListNode.buildList(1, 3, 5, 2, 4), s.oddEvenList(ListNode.buildList(1, 2, 3, 4, 5)));
        Assertions.assertEquals(ListNode.buildList(2, 3, 6, 7, 1, 5, 4),
            s.oddEvenList(ListNode.buildList(2, 1, 3, 5, 6, 4, 7)));
    }

    static class Solution {

        public ListNode oddEvenList(ListNode head) {
            ListNode oddDummy = new ListNode(-1);
            ListNode evenDummy = new ListNode(-1);
            ListNode p = head, o = oddDummy, e = evenDummy;
            int i = 1;
            while (p != null) {
                if (i % 2 == 0) {
                    e.next = p;
                    e = e.next;
                } else {
                    o.next = p;
                    o = o.next;
                }
                p = p.next;
                i++;
            }
            e.next = null;
            o.next = evenDummy.next;
            return oddDummy.next;
        }

    }

}
