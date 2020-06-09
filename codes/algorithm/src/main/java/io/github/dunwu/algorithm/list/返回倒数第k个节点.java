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
    }

    /**
     * @see <a href="https://leetcode-cn.com/problems/remove-duplicate-node-lcci/">面试题 02.02. 返回倒数第 k 个节点</a>
     */
    public static int kthToLast(ListNode head, int k) {
        int length = length(head);
        if (k > length) {
            return -1;
        }
        int pos = length - k;
        ListNode node = head;
        while (node != null && pos > 0) {
            node = node.next;
            pos--;
        }
        if (node != null) {
            return node.val;
        } else {
            return -1;
        }
    }

    public static int length(ListNode head) {
        if (head == null) {
            return 0;
        }

        int count = 1;
        ListNode node = head.next;
        while (node != null) {
            count++;
            node = node.next;
        }
        return count;
    }

}
