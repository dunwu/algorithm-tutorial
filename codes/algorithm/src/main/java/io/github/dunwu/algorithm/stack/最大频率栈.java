package io.github.dunwu.algorithm.stack;

import io.github.dunwu.algorithm.list.ListNode;
import io.github.dunwu.algorithm.list.ListUtil;
import org.junit.jupiter.api.Assertions;

import java.util.List;
import java.util.Stack;

/**
 * <a href="https://leetcode.cn/problems/reorder-list/">143. 重排链表</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-08-11
 */
public class 最大频率栈 {

    public static void main(String[] args) {
        ListNode input = ListUtil.buildList(1, 2, 3, 4);
        reorderList(input);
        List<Integer> list = ListUtil.toList(input);
        System.out.println(list);
        Assertions.assertArrayEquals(new Integer[] { 1, 4, 2, 3 }, list.toArray());
    }

    public static void reorderList(ListNode head) {

        if (head == null || head.next == null) {
            return;
        }

        ListNode p = head;
        int total = 0;
        Stack<ListNode> stack = new Stack<>();
        while (p != null) {
            stack.push(p);
            total++;
            p = p.next;
        }

        p = head;
        int cnt = 0;
        while (p != null && cnt < total) {
            if (cnt % 2 == 0) {
                ListNode node = stack.pop();
                node.next = p.next;
                p.next = node;
            }
            p = p.next;
            cnt++;
        }
        p.next = null;
    }

}
