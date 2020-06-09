package io.github.dunwu.algorithm.list;

import org.junit.jupiter.api.Assertions;

import java.util.List;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-06-09
 */
public class 删除排序链表中的重复元素 {

    public static void main(String[] args) {
        ListNode head = ListUtil.buildList(1, 1, 2);
        System.out.println(ListUtil.toList(head));
        ListNode result = deleteDuplicates(head);
        List<Integer> list = ListUtil.toList(result);
        System.out.println(list);
        Assertions.assertArrayEquals(new Integer[] { 1, 2 }, list.toArray(new Integer[0]));
    }

    /**
     * <code>83. 删除排序链表中的重复元素</code> 算法实现
     * <p>
     * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
     * <p>
     * 示例 1:
     * <pre>
     * 输入: 1->1->2
     * 输出: 1->2
     * </pre>
     * <p>
     * 示例 2:
     * <pre>
     * 输入: 1->1->2->3->3
     * 输出: 1->2->3
     * </pre>
     *
     * @see <a href="https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list">83. 删除排序链表中的重复元素</a>
     */
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode node = head;
        while (node != null && node.next != null) {
            if (node.next.val == node.val) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
        return head;
    }

}
