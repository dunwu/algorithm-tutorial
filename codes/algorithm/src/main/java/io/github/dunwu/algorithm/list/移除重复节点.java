package io.github.dunwu.algorithm.list;

import org.junit.jupiter.api.Assertions;

import java.util.List;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-06-09
 */
public class 移除重复节点 {

    public static void main(String[] args) {
        ListNode head = ListUtil.buildList(1, 2, 3, 3, 2, 1);
        ListNode listNode = removeDuplicateNodes(head);
        List<Integer> result = ListUtil.getValues(listNode);
        System.out.println(result);
        Assertions.assertArrayEquals(new Integer[] { 1, 2, 3 }, result.toArray());
    }

    /**
     * @see <a href="https://leetcode-cn.com/problems/remove-duplicate-node-lcci/">面试题 02.01. 移除重复节点</a>
     */
    public static ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode list = new ListNode(-1);
        list.next = null;

        ListNode node = head;
        while (node != null) {
            if (!exists(list, node.val)) {
                addToTail(list, node.val);
            }
            node = node.next;
        }
        return list.next;
    }

    private static boolean exists(ListNode head, int val) {
        ListNode node = head;
        while (node != null) {
            if (node.val == val) { return true; }
            node = node.next;
        }
        return false;
    }

    private static void addToTail(ListNode head, int val) {
        if (head == null) {
            return;
        }
        ListNode node = head;
        while (node.next != null) {
            node = node.next;
        }
        ListNode newNode = new ListNode(val);
        node.next = newNode;
    }

}
