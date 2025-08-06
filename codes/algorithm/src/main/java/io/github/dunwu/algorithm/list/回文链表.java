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

    public static boolean isPalindrome(ListNode head) {
        LinkedList<Integer> l1 = new LinkedList<>();
        LinkedList<Integer> l2 = new LinkedList<>();
        while (head != null) {
            l1.offerFirst(head.val);
            l2.offerFirst(head.val);
            head = head.next;
        }

        while (!l1.isEmpty() && !l2.isEmpty()) {
            Integer num1 = l1.pollFirst();
            Integer num2 = l2.pollLast();
            if (num1 != num2) {
                return false;
            }
        }
        return true;
    }

}
