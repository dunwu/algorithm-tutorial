package io.github.dunwu.algorithm.linkedlist.two_pointer;

import io.github.dunwu.algorithm.linkedlist.ListNode;
import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii/">82. 删除排序链表中的重复元素 II</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-06-09
 */
public class 删除排序链表中的重复元素2 {

    public static void main(String[] args) {

        Solution s = new Solution();

        ListNode input = ListNode.buildList(1, 2, 3, 3, 4, 4, 5);
        Assertions.assertEquals(ListNode.buildList(1, 2, 5), s.deleteDuplicates(input));

        ListNode input2 = ListNode.buildList(1, 1, 1, 2, 3);
        Assertions.assertEquals(ListNode.buildList(2, 3), s.deleteDuplicates(input2));

        ListNode input3 = ListNode.buildList(1, 2, 2);
        Assertions.assertEquals(ListNode.buildList(1), s.deleteDuplicates(input3));
    }

    public static class Solution {

        public ListNode deleteDuplicates(ListNode head) {
            // 将原链表分解为两条链表
            // 一条链表存放不重复的节点，另一条链表存放重复的节点
            // 运用虚拟头结点技巧，题目说了 node.val <= 100，所以用 101 作为虚拟头结点
            ListNode dummyUniq = new ListNode(101);
            ListNode dummyDup = new ListNode(101);

            ListNode pUniq = dummyUniq, pDup = dummyDup;
            ListNode p = head;

            while (p != null) {
                if ((p.next != null && p.val == p.next.val) || p.val == pDup.val) {
                    // 发现重复节点，接到重复链表后面
                    pDup.next = p;
                    pDup = pDup.next;
                } else {
                    // 不是重复节点，接到不重复链表后面
                    pUniq.next = p;
                    pUniq = pUniq.next;
                }

                p = p.next;
                // 将原链表和新链表断开
                pUniq.next = null;
                pDup.next = null;
            }

            return dummyUniq.next;
        }

    }

}
