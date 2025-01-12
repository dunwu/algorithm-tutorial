package io.github.dunwu.algorithm.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-06-09
 */
public class ListUtil {

    private ListUtil() { }

    public static ListNode buildList(int... list) {
        ListNode head = new ListNode(-1);
        ListNode node = head;
        for (int val : list) {
            node.next = new ListNode(val);
            node = node.next;
        }
        return head.next;
    }

    public static List<Integer> toList(ListNode result) {
        List<Integer> list = new ArrayList<>();
        while (result != null) {
            list.add(result.val);
            result = result.next;
        }
        return list;
    }

    public static List<Integer> getValues(ListNode listNode) {
        List<Integer> list = new ArrayList<>();
        ListNode item = listNode;
        while (item != null) {
            list.add(item.val);
            item = item.next;
        }
        return list;
    }

    public static ListNode buildCycleList(int pos, int[] list) {
        ListNode head = new ListNode(-1);
        ListNode node = head;
        ListNode cycleBeginNode = null;
        for (int val : list) {
            ListNode item = new ListNode(val);
            if (pos == 0 && cycleBeginNode == null) {
                cycleBeginNode = item;
            } else {
                pos--;
            }
            node.next = item;
            node = node.next;
        }
        if (cycleBeginNode != null) {
            node.next = cycleBeginNode;
        }
        return head.next;
    }

}
