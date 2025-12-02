package io.github.dunwu.algorithm.linkedlist.palindrome;

import io.github.dunwu.algorithm.linkedlist.ListNode;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
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
        Solution s = new Solution();
        ListNode input = ListNode.buildList(1, 2, 2, 1);
        Assertions.assertTrue(s.isPalindrome(input));
        ListNode input2 = ListNode.buildList(1, 2);
        Assertions.assertFalse(s.isPalindrome(input2));
    }

    static class Solution {

        public boolean isPalindrome(ListNode head) {
            List<Integer> list = new ArrayList<>();
            ListNode p = head;
            while (p != null) {
                list.add(p.val);
                p = p.next;
            }

            int left = 0, right = list.size() - 1;
            while (left < right) {
                if (!list.get(left).equals(list.get(right))) {
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }

    }

}
