package io.github.dunwu.algorithm.linkedlist.divide;

import io.github.dunwu.algorithm.linkedlist.ListNode;
import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode-cn.com/problems/sort-list/">148.排序链表</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-06-09
 */
public class 排序链表 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertEquals(ListNode.buildList(1, 2, 3, 4), s.sortList(ListNode.buildList(4, 2, 1, 3)));
        Assertions.assertEquals(ListNode.buildList(-1, 0, 3, 4, 5), s.sortList(ListNode.buildList(-1, 5, 3, 4, 0)));
        Assertions.assertEquals(ListNode.buildList(), s.sortList(ListNode.buildList()));
    }

    public static class Solution {

        public ListNode sortList(ListNode head) {
            // 如果链表为空或者只有一个节点，无需排序
            if (head == null || head.next == null) {
                return head;
            }
            // 找到中间节点 head2，并断开 head2 与其前一个节点的连接
            // 比如 head=[4,2,1,3]，那么 middleNode 调用结束后 head=[4,2] head2=[1,3]
            ListNode mid = middleNode(head);
            // 分治
            head = sortList(head);
            mid = sortList(mid);
            // 合并
            return mergeTwoLists(head, mid);
        }

        // 876. 链表的中间结点（快慢指针）
        private ListNode middleNode(ListNode head) {
            ListNode pre = head;
            ListNode slow = head;
            ListNode fast = head;
            while (fast != null && fast.next != null) {
                pre = slow; // 记录 slow 的前一个节点
                slow = slow.next;
                fast = fast.next.next;
            }
            pre.next = null; // 断开 slow 的前一个节点和 slow 的连接
            return slow;
        }

        // 21. 合并两个有序链表（双指针）
        private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode dummy = new ListNode(-1); // 用哨兵节点简化代码逻辑
            ListNode cur = dummy; // cur 指向新链表的末尾
            while (list1 != null && list2 != null) {
                if (list1.val < list2.val) {
                    cur.next = list1; // 把 list1 加到新链表中
                    list1 = list1.next;
                } else { // 注：相等的情况加哪个节点都是可以的
                    cur.next = list2; // 把 list2 加到新链表中
                    list2 = list2.next;
                }
                cur = cur.next;
            }
            cur.next = list1 != null ? list1 : list2; // 拼接剩余链表
            return dummy.next;
        }

    }

}
