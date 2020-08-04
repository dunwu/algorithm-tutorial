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

}
