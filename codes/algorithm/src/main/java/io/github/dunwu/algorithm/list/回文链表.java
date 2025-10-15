package io.github.dunwu.algorithm.list;

import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode-cn.com/problems/palindrome-linked-list/">234. 回文链表</a>
 * <a href="https://leetcode-cn.com/problems/palindrome-linked-list-lcci/submissions/">面试题 02.06. 回文链表</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-06-09
 */
public class 回文链表 {

    public static void main(String[] args) {
        ListNode head = ListUtil.buildList(1, 2, 2, 1);
        Assertions.assertTrue(isPalindrome(head));

        head = ListUtil.buildList(1, 2);
        Assertions.assertFalse(isPalindrome(head));
    }

    public static boolean isPalindrome(ListNode list) {
        ListNode rlist = reverse(list);
        ListNode p = list, q = rlist;
        while (p != null && q != null) {
            if (p.val != q.val) {
                return false;
            }
            p = p.next;
            q = q.next;
        }
        return true;
    }

    static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

}
