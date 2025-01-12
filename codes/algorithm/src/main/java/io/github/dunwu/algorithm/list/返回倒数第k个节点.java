package io.github.dunwu.algorithm.list;

import org.junit.jupiter.api.Assertions;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-06-09
 */
public class 返回倒数第k个节点 {

    public static void main(String[] args) {
        ListNode head = ListUtil.buildList(1, 2, 3, 4, 5);
        int val = kthToLast(head, 2);
        Assertions.assertEquals(4, val);

        ListNode head2 = ListUtil.buildList(1);
        int val2 = kthToLast(head2, 1);
        Assertions.assertEquals(1, val2);
    }

    /**
     * @see <a href="https://leetcode.cn/problems/kth-node-from-end-of-list-lcci/description/">面试题 02.02. 返回倒数第 k
     * 个节点</a>
     */
    public static int kthToLast(ListNode head, int k) {
        ListNode fast = head;
        // fast 指针先走 k 步
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        // fast、slow 同时走，直到结束
        ListNode slow = head;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        // slow 现在指向第 n - k + 1 个节点，即倒数第 k 个节点
        return slow.val;
    }

}
