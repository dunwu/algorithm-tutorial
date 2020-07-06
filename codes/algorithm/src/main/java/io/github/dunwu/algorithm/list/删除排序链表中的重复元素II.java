package io.github.dunwu.algorithm.list;

import org.junit.jupiter.api.Assertions;

import java.util.List;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-07-06
 */
public class 删除排序链表中的重复元素II {

    public static void main(String[] args) {
        ListNode head = ListUtil.buildList(1, 1, 2);
        System.out.println(ListUtil.toList(head));
        ListNode result = deleteDuplicates(head);
        List<Integer> list = ListUtil.toList(result);
        System.out.println(list);
        Assertions.assertArrayEquals(new Integer[] { 2 }, list.toArray(new Integer[0]));
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;  // 若head为空则直接返回null
        ListNode dummy = new ListNode(-1);  // 建立一个虚拟头结点
        ListNode tail = dummy;  // 定义一个尾巴，用于尾插法。
        for (ListNode l = head, r = head; l != null; l = r) {
            while (r != null && r.val == l.val) r = r.next;  // 只要r不为空并且与l的值相等则一直向后移动
            if (l.next == r) {  // 若长度为1，则通过尾插法加入。
                tail.next = l;  // 基本的尾插法
                tail = l;
                tail.next = null;  // 这里记得将尾部的后面置为null，不然可能后面会带着一些其他的节点。
            }
        }
        return dummy.next;
    }

}
