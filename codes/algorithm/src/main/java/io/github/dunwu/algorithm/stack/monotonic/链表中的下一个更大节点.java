package io.github.dunwu.algorithm.stack.monotonic;

import io.github.dunwu.algorithm.linkedlist.ListNode;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.Stack;

/**
 * <a href="https://leetcode.cn/problems/next-greater-node-in-linked-list/">1019. 链表中的下一个更大节点</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-11-26
 */
public class 链表中的下一个更大节点 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertArrayEquals(new int[] { 5, 5, 0 },
            s.nextLargerNodes(ListNode.buildList(2, 1, 5)));
        Assertions.assertArrayEquals(new int[] { 7, 0, 5, 5, 0 },
            s.nextLargerNodes(ListNode.buildList(2, 7, 4, 3, 5)));
    }

    static class Solution {

        public int[] nextLargerNodes(ListNode head) {
            // 把单链表转化成数组，方便通过索引访问
            ArrayList<Integer> nums = new ArrayList<>();
            ListNode p = head;
            while (p != null) {
                nums.add(p.val);
                p = p.next;
            }

            // 存放答案的数组
            int[] res = new int[nums.size()];
            Stack<Integer> stack = new Stack<>();
            // 单调栈模板，求下一个更大元素，从后往前遍历
            for (int i = nums.size() - 1; i >= 0; i--) {
                while (!stack.isEmpty() && stack.peek() <= nums.get(i)) {
                    stack.pop();
                }
                // 本题要求没有下一个更大元素时返回 0
                res[i] = stack.isEmpty() ? 0 : stack.peek();
                stack.push(nums.get(i));
            }
            return res;
        }

    }

}
