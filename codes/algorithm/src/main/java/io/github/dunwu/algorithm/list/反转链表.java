package io.github.dunwu.algorithm.list;

import org.junit.jupiter.api.Assertions;

import java.util.List;
import java.util.Stack;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @see <a href="https://leetcode-cn.com/problems/reverse-linked-list/">206. 反转链表</a>
 * @since 2020-06-09
 */
public class 反转链表 {

    public static void main(String[] args) {
        ListNode head = ListUtil.buildList(1, 2, 3, 4);
        System.out.println(ListUtil.toList(head));
        ListNode result = reverseList2(head);
        List<Integer> list = ListUtil.toList(result);
        System.out.println(list);
        Assertions.assertArrayEquals(new Integer[] { 4, 3, 2, 1 }, list.toArray(new Integer[0]));
    }

    // 借助栈来实现
    public static ListNode reverseList(ListNode head) {
        if (head == null) return null;
        Stack<ListNode> stack = new Stack<>();
        ListNode node = head;
        while (node != null) {
            stack.push(node);
            node = node.next;
        }

        ListNode dummy = new ListNode(-1);
        node = dummy;
        while (!stack.isEmpty()) {
            node.next = stack.pop();
            node.next.next = null;
            node = node.next;
        }
        return dummy.next;
    }

    public static ListNode reverseList2(ListNode head) {
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
