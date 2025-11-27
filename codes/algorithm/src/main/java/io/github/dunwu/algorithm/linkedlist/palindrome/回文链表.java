package io.github.dunwu.algorithm.linkedlist.palindrome;

import io.github.dunwu.algorithm.linkedlist.ListNode;
import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode-cn.com/problems/palindrome-linked-list/">234. 回文链表</a>
 * <a href="https://leetcode-cn.com/problems/palindrome-linked-list-lcci/submissions/">面试题 02.06. 回文链表</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-06-09
 */
public class 回文链表 {

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode head = ListNode.buildList(1, 2, 2, 1);
        Assertions.assertTrue(s.isPalindrome(head));

        ListNode input2 = ListNode.buildList(1, 2);
        Assertions.assertFalse(s.isPalindrome(input2));
    }

    static class Solution {

        public boolean isPalindrome(ListNode head) {
            ListNode slow, fast;
            slow = fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            if (fast != null) { slow = slow.next; }

            ListNode left = head;
            ListNode right = reverse(slow);
            while (right != null) {
                if (left.val != right.val) { return false; }
                left = left.next;
                right = right.next;
            }

            return true;
        }

        ListNode reverse(ListNode head) {
            ListNode pre = null, cur = head;
            while (cur != null) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            return pre;
        }

    }

}
