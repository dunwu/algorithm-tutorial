package io.github.dunwu.algorithm.list;

import org.junit.jupiter.api.Assertions;

import java.util.List;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @see <a href="https://leetcode-cn.com/problems/sort-list/">148.排序链表</a>
 * @since 2020-06-09
 */
public class 排序链表 {

    public static void main(String[] args) {
        ListNode head = ListUtil.buildList(4, 2, 1, 3);
        System.out.println(ListUtil.toList(head));
        ListNode result = sortList(head);
        List<Integer> list = ListUtil.toList(result);
        System.out.println(list);
        Assertions.assertArrayEquals(new Integer[] { 1, 2, 3, 4 }, list.toArray(new Integer[0]));

        head = ListUtil.buildList(-1, 5, 3, 4, 0);
        System.out.println(ListUtil.toList(head));
        result = sortList(head);
        list = ListUtil.toList(result);
        System.out.println(list);
        Assertions.assertArrayEquals(new Integer[] { -1, 0, 3, 4, 5 }, list.toArray(new Integer[0]));
    }

    public static ListNode sortList(ListNode head) {
        if (head == null) {return head;}
        return mergeSort(head);
    }

    static ListNode mergeSort(ListNode head) {
        //回归条件
        if (head.next == null) {
            return head;
        }
        //快指针,考虑到链表为2时的情况，fast比slow早一格
        ListNode fast = head.next;
        //慢指针
        ListNode slow = head;
        //快慢指针开跑
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //找到右子链表头元素，复用fast引用
        fast = slow.next;
        //将中点后续置空，切割为两个子链表
        slow.next = null;
        //递归分解左子链表,得到新链表起点
        head = mergeSort(head);
        //递归分解右子链表,得到新链表起点
        fast = mergeSort(fast);
        //并归两个子链表
        return merge(head, fast);
    }

    static ListNode merge(ListNode left, ListNode right) {
        //维护临时序列的头元素
        ListNode head;
        if (left.val <= right.val) {
            head = left;
            left = left.next;
        } else {
            head = right;
            right = right.next;
        }
        //两个子链表均存在剩余元素
        ListNode temp = head;
        while (left != null && right != null) {
            //将较小的元素加入临时序列
            if (left.val <= right.val) {
                temp.next = left;
                left = left.next;
                temp = temp.next;
            } else {
                temp.next = right;
                right = right.next;
                temp = temp.next;
            }
        }
        //左子序列用完将右子序列余下元素加入临时序列
        if (left == null) {
            temp.next = right;
        }
        //右子序列用完将左子序列余下元素加入临时序列
        if (right == null) {
            temp.next = left;
        }
        return head;
    }

}
