package io.github.dunwu.algorithm.linkedlist.demo;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class DoublyLinkedList<E> {

    private int size = 0;
    private Node<E> first = null;
    private Node<E> last = null;

    public DoublyLinkedList() {
        first = new Node<>(null);
        last = new Node<>(null);
        first.next = last;
        last.prev = first;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int indexOf(E element) {
        int pos = 0;

        Node<E> p = first.next;
        while (p != null) {
            if (p.element.equals(element)) {
                return pos;
            }
            p = p.next;
            pos++;
        }
        return -1;
    }

    public E get(int index) {
        Node<E> node = node(index);
        return node == null ? null : node.element;
    }

    Node<E> node(int index) {
        int i = 0;

        Node<E> p = first;
        while (p != null && i != index) {
            p = p.next;
            i++;
        }
        return p;
    }

    public void addFirst(E element) {

        Node<E> node = new Node<>(element);
        Node<E> temp = first.next;

        node.next = temp;
        temp.prev = node;

        node.prev = first;
        first.next = node;

        size++;
    }

    public void addLast(E element) {

        Node<E> node = new Node<>(element);
        Node<E> temp = last.prev;

        temp.next = node;
        node.prev = temp;

        last.prev = node;
        node.next = last;

        size++;
    }

    public boolean add(int index, E element) {

        if (index == 0) {
            addFirst(element);
            return true;
        }

        Node<E> p = node(index);
        Node<E> node = new Node<>(element);
        node.next = p.next;
        p.next.prev = node;

        node.prev = p;
        p.next = node;

        size++;
        return true;
    }

    public boolean remove(E e) {
        if (e == null) {
            Node<E> p = first;
            while (p.next != null) {
                Node<E> x = p.next;
                if (x.element == null) {
                    p.next = x.next;
                    size--;
                    return true;
                }
                p = p.next;
            }
        } else {
            Node<E> p = first;
            while (p != null && p.next != null) {
                Node<E> x = p.next;
                if (e.equals(x.element)) {
                    p.next = x.next;
                    size--;
                    return true;
                }
                p = p.next;
            }
        }
        return false;
    }

    public boolean removeAll(E e) {

        if (first.next == null) {
            return false;
        }

        if (e == null) {
            Node<E> p = first;
            while (p.next != null) {
                Node<E> x = p.next;
                if (x.element == null) {
                    p.next = x.next;
                    size--;
                }
                p = p.next;
            }
        } else {
            Node<E> p = first;
            while (p != null && p.next != null) {
                if (e.equals(p.next.element)) {
                    p.next = p.next.next;
                    size--;
                } else {
                    p = p.next;
                }
            }
        }
        return true;
    }

    public void clear() {
        first.next = last;
        last.prev = first;
        size = 0;
    }

    public void printAll() {
        Node<E> p = first;
        while (p.next != null && p.next != last) {
            p = p.next;
            System.out.print(p.element + " ");
        }
        System.out.println();
    }

    public List<E> toList() {
        List<E> list = new ArrayList<>();
        Node<E> node = first.next;
        while (node != null && node != last) {
            list.add(node.element);
            node = node.next;
        }
        return list;
    }

    @Getter
    @Setter
    public static class Node<E> {

        private E element;
        private Node<E> next;
        private Node<E> prev;

        public Node(E element) {
            this.element = element;
            this.next = null;
            this.prev = null;
        }

        public Node(E element, Node<E> prev, Node<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }

    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5 };
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        DoublyLinkedList<Integer> reverseList = new DoublyLinkedList<>();
        for (int num : nums) {
            list.addLast(num);
            reverseList.addFirst(num);
        }

        list.add(5, 999);
        System.out.println("【队尾写入链表】");
        list.printAll();
        System.out.println("【队头写入链表】");
        reverseList.printAll();
        list.printAll();
        System.out.println("999 在队列中的位置：" + list.indexOf(999));
        System.out.println("队列中位置 5 的元素值：" + list.get(5));
    }

}
