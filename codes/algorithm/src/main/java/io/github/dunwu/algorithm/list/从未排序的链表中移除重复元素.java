package io.github.dunwu.algorithm.list;

import org.junit.jupiter.api.Assertions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list">83. 删除排序链表中的重复元素</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-06-09
 */
public class 从未排序的链表中移除重复元素 {

    public static void main(String[] args) {
        ListNode head = ListUtil.buildList(1, 2, 3, 2);
        System.out.println(ListUtil.toList(head));
        ListNode result = deleteDuplicates2(head);
        List<Integer> list = ListUtil.toList(result);
        System.out.println(list);
        Assertions.assertArrayEquals(new Integer[] { 1, 3 }, list.toArray(new Integer[0]));

        ListNode head2 = ListUtil.buildList(2, 1, 1, 2);
        System.out.println(ListUtil.toList(head2));
        ListNode result2 = deleteDuplicates2(head2);
        List<Integer> list2 = ListUtil.toList(result2);
        System.out.println(list2);
        Assertions.assertArrayEquals(new Integer[] {}, list2.toArray(new Integer[0]));

        ListNode head3 = ListUtil.buildList(3, 2, 2, 1, 3, 2, 4);
        System.out.println(ListUtil.toList(head3));
        ListNode result3 = deleteDuplicates2(head3);
        List<Integer> list3 = ListUtil.toList(result3);
        System.out.println(list3);
        Assertions.assertArrayEquals(new Integer[] { 1, 4 }, list3.toArray(new Integer[0]));
    }

    public static ListNode deleteDuplicates(ListNode head) {
        Map<Integer, Integer> map = new HashMap<>();
        ListNode p = head;
        while (p != null) {
            map.put(p.val, map.getOrDefault(p.val, 0) + 1);
            p = p.next;
        }

        ListNode dup = new ListNode(101);
        ListNode nodup = new ListNode(101);
        ListNode pDup = dup, pNodup = nodup;
        p = head;
        while (p != null) {
            if (map.get(p.val) > 1) {
                pDup.next = p;
                pDup = pDup.next;
            } else {
                pNodup.next = p;
                pNodup = pNodup.next;
            }

            p = p.next;
            pDup.next = null;
            pNodup.next = null;
        }
        return nodup.next;
    }

    public static ListNode deleteDuplicates2(ListNode head) {
        ListNode dupList = new ListNode(0);
        ListNode nodupList = new ListNode(0);
        ListNode dup = dupList, nodup = nodupList;
        ListNode p = head;
        Map<Integer, Integer> map = new HashMap<>();
        while (p != null) {
            map.put(p.val, map.getOrDefault(p.val, 0) + 1);
            p = p.next;
        }
        p = head;
        while (p != null) {
            if (map.get(p.val) > 1) {
                dup.next = p;
                dup = dup.next;
            } else {
                nodup.next = p;
                nodup = nodup.next;
            }
            p = p.next;
            dup.next = null;
            nodup.next = null;
        }
        return nodupList.next;
    }

}
