package io.github.dunwu.algorithm.linkedlist.two_pointer;

import io.github.dunwu.algorithm.linkedlist.ListNode;
import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/remove-nth-node-from-end-of-list/">19. 删除链表的倒数第 N 个结点</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-06-09
 */
public class 删除链表的倒数第N个结点 {

    public static void main(String[] args) {

        Solution s = new Solution();

        ListNode input1 = ListNode.buildList(1, 2, 3, 4, 5);
        ListNode output1 = s.removeNthFromEnd(input1, 2);
        Assertions.assertEquals(ListNode.buildList(1, 2, 3, 5), output1);

        ListNode input2 = ListNode.buildList(1);
        ListNode output2 = s.removeNthFromEnd(input2, 1);
        Assertions.assertEquals(ListNode.buildList(), output2);

        ListNode input3 = ListNode.buildList(1, 2);
        ListNode output3 = s.removeNthFromEnd(input3, 1);
        Assertions.assertEquals(ListNode.buildList(1), output3);
    }

    static class Solution {

        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode node = findFromEnd(dummy, n + 1);
            node.next = node.next.next;
            return dummy.next;
        }

        public ListNode findFromEnd(ListNode head, int k) {
            ListNode p1 = head;
            // p1 先走 k 步
            for (int i = 0; i < k; i++) {
                p1 = p1.next;
            }
            ListNode p2 = head;
            // p1 和 p2 同时走 n - k 步
            while (p1 != null) {
                p2 = p2.next;
                p1 = p1.next;
            }
            // p2 现在指向第 n - k + 1 个节点，即倒数第 k 个节点
            return p2;
        }

    }

}
