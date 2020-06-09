package io.github.dunwu.algorithm.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-01-26
 */
public class 单链表示例<E> {

    /** 头节点 */
    private ListNode<E> head;

    public 单链表示例() {
        this.head = new ListNode<>(null, null);
    }

    public 单链表示例(ListNode<E> head) {
        this.head = head;
    }

    /**
     * 头插法
     *
     * @param value 数据值
     */
    public void addHead(E value) {
        ListNode<E> newNode = new ListNode<>(value, null);
        newNode.next = this.head.next;
        this.head.next = newNode;
    }

    /**
     * 尾插法
     *
     * @param value 数据值
     */
    public void addTail(E value) {
        // init new node
        ListNode<E> newNode = new ListNode<>(value, null);

        // find the last node
        ListNode<E> node = this.head;
        while (node.next != null) {
            node = node.next;
        }

        // add new node to tail
        node.next = newNode;
    }

    public void remove(ListNode<E> node) {
        ListNode<E> prev = this.head;
        while (prev.next != null) {
            ListNode<E> curr = prev.next;
            if (curr == node) {
                prev.next = curr.next;
            }
            prev = prev.next;
        }
    }

    /**
     * 删除首个值为 value 的节点
     *
     * @param value 数据值
     * @return {@link ListNode<E>}
     */
    public ListNode<E> removeFirst(E value) {
        ListNode<E> prev = this.head;
        while (prev.next != null) {
            ListNode<E> curr = prev.next;
            if (curr.value.equals(value)) {
                prev.next = curr.next;
                return curr;
            }
            prev = prev.next;
        }
        return null;
    }

    /**
     * 删除所有值为 value 的节点
     * <p>
     * 示例:
     * <pre>
     * 输入: 1->2->6->3->4->5->6, val = 6
     * 输出: 1->2->3->4->5
     * </pre>
     *
     * @see <a href="https://leetcode-cn.com/problems/intersection-of-two-linked-lists">移除链表元素</a>
     */
    public void removeAll(E val) {
        if (head.next == null) {
            return;
        }

        ListNode<E> root = head;
        ListNode<E> prev = root;
        while (prev != null && prev.next != null) {
            if (prev.next.value.equals(val)) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }

        head = root;
    }

    /**
     * 清空除头节点以外的所有节点
     */
    public void clear() {
        if (head != null) {
            head.next = null;
        }
    }

    /**
     * find element
     * <p>
     * 从头开始查找，一旦发现有数值与查找值相等的节点，直接返回此节点。如果遍历结束，表明未找到节点，返回 null。
     *
     * @param value 数据值
     * @return {@link ListNode}
     */
    public ListNode<E> find(E value) {
        ListNode<E> node = this.head.next;
        while (node != null) {
            if (node.value.equals(value)) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    /**
     * <code>反转链表</code> 算法实现
     *
     * @see <a href="https://leetcode-cn.com/explore/featured/card/bytedance/244/linked-list-and-tree/1038/">反转链表</a>
     */
    public ListNode<E> reverse() {
        if (head == null) {
            return null;
        }

        ListNode<E> prev = null;
        ListNode<E> curr = head;
        while (curr != null) {
            ListNode<E> temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    public List<E> toList() {
        List<E> list = new ArrayList<>();
        ListNode<E> node = head.next;
        while (node != null) {
            list.add(node.value);
            node = node.next;
        }
        return list;
    }

    private static class ListNode<E> {

        E value;

        /** point to next node */
        ListNode<E> next;

        public ListNode(E value, ListNode<E> next) {
            this.value = value;
            this.next = next;
        }

    }

}
