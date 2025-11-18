package io.github.dunwu.algorithm.linkedlist;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class SinglyLinkedList<E> {

    private int size = 0;
    private Node<E> first = null;

    public SinglyLinkedList() {
        this.size = 0;
        this.first = new Node<>(null);
    }

    public SinglyLinkedList(E[] elementArray) {
        this.size = 0;
        this.first = new Node<>(null);
        for (E element : elementArray) {
            addLast(element);
        }
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
        node.next = first.next;
        first.next = node;
        size++;
    }

    public void addLast(E element) {
        Node<E> node = new Node<>(element);
        Node<E> p = first;
        while (p.next != null) {
            p = p.next;
        }
        p.next = node;
        size++;
    }

    public boolean add(int index, E element) {

        checkPositionIndex(index);

        if (index == 0) {
            addFirst(element);
            return true;
        }

        Node<E> p = node(index - 1);
        Node<E> node = new Node<>(element);
        node.next = p.next;
        p.next = node;
        size++;
        return true;
    }

    public void removeFirst() {
        first = first.next;
        size--;
    }

    public void removeLast() {
        Node<E> p = first;
        while (p.next.next != null) {
            p = p.next;
        }
        p.next = null;
        size--;
    }

    public boolean remove(int index) {

        checkElementIndex(index);

        if (index == 0) {
            removeFirst();
        }

        int pos = 0;
        Node<E> p = first;
        while (pos < index - 1) {
            p = p.next;
            pos++;
        }
        p.next = p.next.next;
        size--;
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
            while (p.next != null) {
                Node<E> x = p.next;
                if (x.element.equals(e)) {
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
                if (p.next.element.equals(e)) {
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
        first.next = null;
        size = 0;
    }

    private void checkElementIndex(int index) {
        if (index >= 0 && index < size) { return; }
        throw new RuntimeException("超出边界！");
    }

    private void checkPositionIndex(int index) {
        if (index >= 0 && index <= size) { return; }
        throw new RuntimeException("超出边界！");
    }

    public void printAll() {
        Node<E> p = first.next;
        while (p != null) {
            System.out.print(p.element + " ");
            p = p.next;
        }
        System.out.println();
    }

    public List<E> toList() {
        List<E> list = new ArrayList<>();
        Node<E> node = first.next;
        while (node != null) {
            list.add(node.element);
            node = node.next;
        }
        return list;
    }

    @Getter
    @Setter
    private static class Node<E> {

        private E element;
        private Node<E> next;

        public Node(E element) {
            this.element = element;
            this.next = null;
        }

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }

    }

    public static void main(String[] args) {

        Integer[] nums = { 1, 2, 3, 4, 5 };
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>(nums);
        SinglyLinkedList<Integer> reverseList = new SinglyLinkedList<>();
        for (int num : nums) {
            reverseList.addFirst(num);
        }

        list.add(5, 999);
        System.out.println("【队尾写入链表】");
        list.printAll();
        System.out.println("【队头写入链表】");
        reverseList.printAll();
        System.out.println("999 在队列中的位置：" + list.indexOf(999));
        System.out.println("队列中位置 5 的元素值：" + list.get(5));

        System.out.println("【删除指定位置元素】");
        list.removeLast();
        list.printAll();
        list.remove(new Integer(999));
        list.printAll();
    }

}
