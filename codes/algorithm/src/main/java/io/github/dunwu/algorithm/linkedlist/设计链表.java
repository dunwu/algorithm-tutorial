package io.github.dunwu.algorithm.linkedlist;

import org.junit.jupiter.api.Assertions;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-07-08
 */
public class 设计链表 {

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.addAtHead(1);
        list.print();
        list.addAtTail(3);
        list.print();
        list.addAtIndex(1, 2);   //链表变为1-> 2-> 3
        list.print();
        System.out.println(list.get(1));//返回2
        Assertions.assertEquals(2, list.get(1));
        list.deleteAtIndex(1);  //现在链表是1-> 3
        list.print();
        Assertions.assertEquals(3, list.get(1));
    }

    static class MyLinkedList {

        private Node head;

        /**
         * Initialize your data structure here.
         */
        public MyLinkedList() {
            head = new Node(-1);
        }

        /**
         * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
         */
        public int get(int index) {
            int i = 0;
            Node p = head.next;
            while (p.next != null && i < index) {
                p = p.next;
                i++;
            }
            return p.val;
        }

        /**
         * Add a node of value val before the first element of the linked list. After the insertion, the new node will
         * be the first node of the linked list.
         */
        public void addAtHead(int val) {
            Node node = new Node(val);
            if (head.next == null) {
                head.next = node;
            } else {
                node.next = head.next;
                head.next = node;
            }
        }

        /**
         * Append a node of value val to the last element of the linked list.
         */
        public void addAtTail(int val) {
            Node p = head;
            while (p.next != null) {
                p = p.next;
            }
            p.next = new Node(val);
        }

        /**
         * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked
         * list, the node will be appended to the end of linked list. If index is greater than the length, the node will
         * not be inserted.
         */
        public void addAtIndex(int index, int val) {
            int i = 0;
            Node p = head.next;
            while (p.next != null && i < index - 1) {
                p = p.next;
            }

            Node node = new Node(val);
            node.next = p.next;
            p.next = node;
        }

        /**
         * Delete the index-th node in the linked list, if the index is valid.
         */
        public void deleteAtIndex(int index) {
            int i = 0;
            Node p = head.next;
            while (p.next != null && i < index - 1) {
                p = p.next;
            }

            if (p.next != null) {
                p.next = p.next.next;
            } else {
                p.next = null;
            }
        }

        public void print() {
            Node p = head;
            while (p.next != null) {
                p = p.next;
                System.out.print(p.val + "\t");
            }
            System.out.println();
        }

        static class Node {

            int val;
            Node next;

            public Node(int val) {
                this.val = val;
                next = null;
            }

        }

    }

}
