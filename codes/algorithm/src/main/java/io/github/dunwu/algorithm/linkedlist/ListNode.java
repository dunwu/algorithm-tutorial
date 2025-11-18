package io.github.dunwu.algorithm.linkedlist;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int val) { this.val = val; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ListNode)) return false;
        ListNode listNode = (ListNode) o;
        return val == listNode.val &&
            Objects.equals(next, listNode.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, next);
    }

    public List<Integer> toList() {
        return ListNode.toList(this);
    }

    public static ListNode createLinkedList(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        ListNode head = new ListNode(arr[0]);
        ListNode cur = head;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
        return head;
    }

    public static void addLast() {

    }

    public static ListNode buildList(int... list) {
        ListNode head = new ListNode(-1);
        ListNode node = head;
        for (int val : list) {
            node.next = new ListNode(val);
            node = node.next;
        }
        return head.next;
    }

    public static ListNode buildCycleList(int cyclePoint, int[] list) {
        ListNode head = new ListNode(-1);
        ListNode node = head;
        ListNode cycleBeginNode = null;
        for (int val : list) {
            ListNode item = new ListNode(val);
            if (cyclePoint == 0 && cycleBeginNode == null) {
                cycleBeginNode = item;
            } else {
                cyclePoint--;
            }
            node.next = item;
            node = node.next;
        }
        if (cycleBeginNode != null) {
            node.next = cycleBeginNode;
        }
        return head.next;
    }

    public static List<Integer> toList(ListNode listNode) {
        List<Integer> list = new ArrayList<>();
        while (listNode != null) {
            list.add(listNode.val);
            listNode = listNode.next;
        }
        return list;
    }

    public static void buildMetPot(ListNode listA, ListNode listB, int skipA, int skipB) {
        ListNode pA = listA;
        for (int i = 0; i < skipA; i++) {
            pA = pA.next;
        }
        ListNode pB = listB;
        for (int i = 0; i < skipB - 1; i++) {
            pB = pB.next;
        }
        pB.next = pA;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        ListNode head = createLinkedList(arr);
        ListNode p = head;
        while (p.next != null) {
            p = p.next;
        }
        p.next = new ListNode(6);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

}
