package io.github.dunwu.algorithm.list;

import org.junit.jupiter.api.Assertions;

import java.util.List;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-06-09
 */
public class 反转链表 {

    public static void main(String[] args) {
        ListNode head = ListUtil.buildList(1, 2, 4);
        System.out.println(ListUtil.toList(head));
        ListNode result = reverseList(head);
        List<Integer> list = ListUtil.toList(result);
        System.out.println(list);
        Assertions.assertArrayEquals(new Integer[] { 4, 2, 1 }, list.toArray(new Integer[0]));
    }

    /**
     * <code>206. 反转链表</code> 算法实现
     *
     * @see <a href="https://leetcode-cn.com/problems/reverse-linked-list/">206. 反转链表</a>
     */
    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

}
