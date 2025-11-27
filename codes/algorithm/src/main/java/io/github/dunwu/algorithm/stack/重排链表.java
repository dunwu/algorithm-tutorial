package io.github.dunwu.algorithm.stack;

import io.github.dunwu.algorithm.linkedlist.ListNode;
import org.junit.jupiter.api.Assertions;

import java.util.List;
import java.util.Stack;

/**
 * <a href="https://leetcode.cn/problems/reorder-list/">143. 重排链表</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-08-11
 */
public class 重排链表 {

    public static void main(String[] args) {

        Solution s = new Solution();
        ListNode input = ListNode.buildList(1, 2, 3, 4);
        s.reorderList(input);
        List<Integer> list = ListNode.toList(input);
        Assertions.assertArrayEquals(new Integer[] { 1, 4, 2, 3 }, list.toArray());

        ListNode input2 = ListNode.buildList(1, 2, 3, 4, 5);
        s.reorderList(input2);
        List<Integer> list2 = ListNode.toList(input2);
        Assertions.assertArrayEquals(new Integer[] { 1, 5, 2, 4, 3 }, list2.toArray());
    }

    static class Solution {

        public void reorderList(ListNode head) {
            Stack<ListNode> stack = new Stack<>();
            // 先把所有节点装进栈里，得到倒序结果
            ListNode p = head;
            while (p != null) {
                stack.push(p);
                p = p.next;
            }

            p = head;
            while (p != null) {
                // 链表尾部的节点
                ListNode last = stack.pop();
                ListNode next = p.next;
                if (last == next || last.next == next) {
                    // 结束条件，链表节点数为奇数或偶数时均适用
                    last.next = null;
                    break;
                }
                p.next = last;
                last.next = next;
                p = next;
            }
        }

    }

}
