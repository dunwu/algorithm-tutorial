package io.github.dunwu.algorithm.linkedlist.two_pointer;

import io.github.dunwu.algorithm.linkedlist.ListNode;
import org.junit.jupiter.api.Assertions;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode-cn.com/problems/remove-duplicate-node-lcci/">面试题 02.01. 移除重复节点</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-06-09
 */
public class 移除重复节点 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertEquals(ListNode.buildList(1, 2, 3),
            s.removeDuplicateNodes(ListNode.buildList(1, 2, 3, 3, 2, 1)));
        Assertions.assertEquals(ListNode.buildList(1, 2),
            s.removeDuplicateNodes(ListNode.buildList(1, 1, 1, 1, 2)));
    }

    static class Solution {

        public ListNode removeDuplicateNodes(ListNode head) {
            Set<Integer> set = new HashSet<>();
            ListNode dummy = new ListNode(-1);
            ListNode p = head, n = dummy;
            while (p != null) {
                if (!set.contains(p.val)) {
                    n.next = p;
                    n = n.next;
                    set.add(p.val);
                }
                p = p.next;
            }
            n.next = null;
            return dummy.next;
        }

    }

}
