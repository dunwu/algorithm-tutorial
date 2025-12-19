package io.github.dunwu.algorithm.linkedlist.two_pointer;

import io.github.dunwu.algorithm.linkedlist.ListNode;
import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list">83. 删除排序链表中的重复元素</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-06-09
 */
public class 删除排序链表中的重复元素 {

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode input = ListNode.buildList(1, 1, 2);
        Assertions.assertEquals(ListNode.buildList(1, 2), s.deleteDuplicates(input));
        ListNode input2 = ListNode.buildList(1, 1, 2, 3, 3);
        Assertions.assertEquals(ListNode.buildList(1, 2, 3), s.deleteDuplicates(input2));
    }

    static class Solution {

        public ListNode deleteDuplicates(ListNode head) {
            ListNode pre = head, cur = head.next;
            while (cur != null) {
                pre.next = cur.next;
                pre = cur;
                cur = cur.next;
            }
            return head;
        }

    }

}
