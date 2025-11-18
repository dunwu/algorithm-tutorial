package io.github.dunwu.algorithm.linkedlist.two_pointer;

import io.github.dunwu.algorithm.linkedlist.ListNode;
import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/kth-node-from-end-of-list-lcci/">面试题 02. 返回倒数第 k 个节点</a>
 * <a href="https://leetcode.cn/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/">LCR 140. 训练计划 II</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-06-09
 */
public class 返回倒数第k个节点 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertEquals(4, s.kthToLast(ListNode.buildList(1, 2, 3, 4, 5), 2));
        Assertions.assertEquals(1, s.kthToLast(ListNode.buildList(1), 1));
    }

    static class Solution {

        public int kthToLast(ListNode head, int k) {
            ListNode slow = head, fast = head;
            for (int i = 0; i < k && fast != null; i++) {
                fast = fast.next;
            }
            while (fast != null) {
                fast = fast.next;
                slow = slow.next;
            }
            return slow == null ? -1 : slow.val;
        }

    }

}
