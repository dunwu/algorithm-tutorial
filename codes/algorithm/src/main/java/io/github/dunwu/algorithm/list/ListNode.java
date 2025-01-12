package io.github.dunwu.algorithm.list;

import java.util.Objects;

public final class ListNode {

    int val;
    ListNode next;

    ListNode(int val) { this.val = val; }

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
