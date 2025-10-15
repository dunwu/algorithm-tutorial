package io.github.dunwu.algorithm.list;

import org.junit.jupiter.api.Assertions;

import java.util.List;
import java.util.Stack;

/**
 * <a href="https://leetcode-cn.com/problems/reverse-linked-list/">206. 反转链表</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-06-09
 */
public class 反转链表 {

    public static void main(String[] args) {
        ListNode head = ListUtil.buildList(1, 2, 3, 4);
        System.out.println(ListUtil.toList(head));
        ListNode result = reverseList3(head);
        List<Integer> list = ListUtil.toList(result);
        System.out.println(list);
        Assertions.assertArrayEquals(new Integer[] { 4, 3, 2, 1 }, list.toArray(new Integer[0]));

        ListNode head2 = ListUtil.buildList(1, 2);
        System.out.println(ListUtil.toList(head2));
        ListNode result2 = reverseList3(head2);
        List<Integer> list2 = ListUtil.toList(result2);
        System.out.println(list2);
        Assertions.assertArrayEquals(new Integer[] { 2, 1 }, list2.toArray(new Integer[0]));

        ListNode head3 = ListUtil.buildList();
        System.out.println(ListUtil.toList(head3));
        ListNode result3 = reverseList3(head3);
        List<Integer> list3 = ListUtil.toList(result3);
        System.out.println(list3);
        Assertions.assertArrayEquals(new Integer[] {}, list3.toArray(new Integer[0]));
    }

    /**
     * 借助栈来实现，时间复杂度：O(2N)
     */
    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }

        Stack<ListNode> stack = new Stack<>();
        ListNode node = head;
        while (node != null) {
            stack.push(node);
            node = node.next;
        }

        ListNode dummy = new ListNode(5001);
        ListNode n = dummy;
        while (!stack.isEmpty()) {
            n.next = stack.pop();
            n = n.next;
            n.next = null;
        }
        return dummy.next;
    }

    public static ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode pre = null, cur = head, next = head.next;
        while (cur != null) {
            cur.next = pre;
            pre = cur;
            cur = next;
            if (next != null) {
                next = next.next;
            }
        }
        return pre;
    }

    public static ListNode reverseList3(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode reverse = reverseList3(head.next);
        head.next.next = head;
        head.next = null;
        return reverse;
    }

}
