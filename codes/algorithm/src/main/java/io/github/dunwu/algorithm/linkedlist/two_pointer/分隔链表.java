package io.github.dunwu.algorithm.linkedlist.two_pointer;

import io.github.dunwu.algorithm.linkedlist.ListNode;
import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode-cn.com/problems/partition-list/">86. 分隔链表</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-07-06
 */
public class 分隔链表 {

    public static void main(String[] args) {

        Solution s = new Solution();

        Assertions.assertEquals(ListNode.buildList(1, 2, 2, 4, 3, 5),
            s.partition(ListNode.buildList(1, 4, 3, 2, 5, 2), 3));
        Assertions.assertEquals(ListNode.buildList(1, 2), s.partition(ListNode.buildList(2, 1), 2));
        Assertions.assertEquals(ListNode.buildList(1, 2, 3), s.partition(ListNode.buildList(3, 1, 2), 3));
        Assertions.assertEquals(ListNode.buildList(1, 0, 4, 3, 5, 2),
            s.partition(ListNode.buildList(1, 4, 3, 0, 5, 2), 2));

        Solution2 s2 = new Solution2();
        Assertions.assertEquals(ListNode.buildList(1, 2, 2, 4, 3, 5),
            s2.partition(ListNode.buildList(1, 4, 3, 2, 5, 2), 3));
        Assertions.assertEquals(ListNode.buildList(1, 2), s2.partition(ListNode.buildList(2, 1), 2));
        Assertions.assertEquals(ListNode.buildList(1, 2, 3), s2.partition(ListNode.buildList(3, 1, 2), 3));
        Assertions.assertEquals(ListNode.buildList(1, 0, 4, 3, 5, 2),
            s2.partition(ListNode.buildList(1, 4, 3, 0, 5, 2), 2));
    }

    static class Solution {

        public ListNode partition(ListNode head, int x) {

            if (head == null) { return null; }

            ListNode dummy = new ListNode(-1);
            dummy.next = head;

            // 找到大于等于 x 的节点的前一个节点
            ListNode l = dummy, r = dummy.next;
            while (r != null) {

                while (l.next != null && l.next.val < x) {
                    l = l.next;
                }
                if (l.next == null) {
                    break;
                }

                r = l.next;
                while (r.next != null && r.next.val >= x) {
                    r = r.next;
                }
                if (r.next == null) {
                    break;
                }

                // 替换节点
                ListNode tmp = r.next;
                r.next = tmp.next;
                tmp.next = l.next;
                l.next = tmp;

                l = l.next;
                r = r.next;
            }

            return dummy.next;
        }

    }

    static class Solution2 {

        public ListNode partition(ListNode head, int x) {
            ListNode dummy1 = new ListNode(-1);
            ListNode dummy2 = new ListNode(-1);

            ListNode d1 = dummy1, d2 = dummy2, p = head;
            while (p != null) {
                if (p.val < x) {
                    d1.next = p;
                    d1 = d1.next;
                } else {
                    d2.next = p;
                    d2 = d2.next;
                }
                p = p.next;
            }
            d2.next = null;
            d1.next = dummy2.next;
            return dummy1.next;
        }

    }

}
