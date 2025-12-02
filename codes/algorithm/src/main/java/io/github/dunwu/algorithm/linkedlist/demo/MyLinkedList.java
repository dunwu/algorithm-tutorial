package io.github.dunwu.algorithm.linkedlist.demo;

import java.util.NoSuchElementException;

public class MyLinkedList<T> {

    // 虚拟头尾节点
    private int size;
    final private Node<T> head, tail;

    // 双链表节点
    private static class Node<E> {

        E data;
        Node<E> next;
        Node<E> prev;

        Node(E data) {
            this.data = data;
        }

    }

    // 构造函数初始化虚拟头尾节点
    public MyLinkedList() {
        this.head = new Node<>(null);
        this.tail = new Node<>(null);
        head.next = tail;
        tail.prev = head;
        this.size = 0;
    }

    // ***** 增 *****

    public void addLast(T data) {
        Node<T> node = new Node<>(data);
        Node<T> temp = tail.prev;
        // temp <-> x
        temp.next = node;
        node.prev = temp;

        node.next = tail;
        tail.prev = node;
        // temp <-> x <-> tail
        size++;
    }

    public void addFirst(T e) {
        Node<T> x = new Node<>(e);
        Node<T> temp = head.next;
        // head <-> temp
        temp.prev = x;
        x.next = temp;

        head.next = x;
        x.prev = head;
        // head <-> x <-> temp
        size++;
    }

    public void add(int index, T element) {
        checkPositionIndex(index);
        if (index == size) {
            addLast(element);
            return;
        }

        // 找到 index 对应的 Node
        Node<T> p = getNode(index);
        Node<T> temp = p.prev;
        // temp <-> p

        // 新要插入的 Node
        Node<T> x = new Node<>(element);

        p.prev = x;
        temp.next = x;

        x.prev = temp;
        x.next = p;

        // temp <-> x <-> p

        size++;
    }

    // ***** 删 *****

    public T removeFirst() {
        if (size < 1) {
            throw new NoSuchElementException();
        }
        // 虚拟节点的存在是我们不用考虑空指针的问题
        Node<T> x = head.next;
        Node<T> temp = x.next;
        // head <-> x <-> temp
        head.next = temp;
        temp.prev = head;

        x.prev = null;
        x.next = null;
        // head <-> temp

        size--;
        return x.data;
    }

    public T removeLast() {
        if (size < 1) {
            throw new NoSuchElementException();
        }
        Node<T> x = tail.prev;
        Node<T> temp = tail.prev.prev;
        // temp <-> x <-> tail

        tail.prev = temp;
        temp.next = tail;

        x.prev = null;
        x.next = null;
        // temp <-> tail

        size--;
        return x.data;
    }

    public T remove(int index) {
        checkElementIndex(index);
        // 找到 index 对应的 Node
        Node<T> x = getNode(index);
        Node<T> prev = x.prev;
        Node<T> next = x.next;
        // prev <-> x <-> next
        prev.next = next;
        next.prev = prev;

        x.prev = x.next = null;
        // prev <-> next

        size--;

        return x.data;
    }

    // ***** 查 *****

    public T get(int index) {
        checkElementIndex(index);
        // 找到 index 对应的 Node
        Node<T> p = getNode(index);

        return p.data;
    }

    public T getFirst() {
        if (size < 1) {
            throw new NoSuchElementException();
        }

        return head.next.data;
    }

    public T getLast() {
        if (size < 1) {
            throw new NoSuchElementException();
        }

        return tail.prev.data;
    }

    // ***** 改 *****

    public T set(int index, T val) {
        checkElementIndex(index);
        // 找到 index 对应的 Node
        Node<T> p = getNode(index);

        T oldVal = p.data;
        p.data = val;

        return oldVal;
    }

    // ***** 其他工具函数 *****

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private Node<T> getNode(int index) {
        checkElementIndex(index);
        Node<T> p = head.next;
        // TODO: 可以优化，通过 index 判断从 head 还是 tail 开始遍历
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        return p;
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }

    // 检查 index 索引位置是否可以存在元素
    private void checkElementIndex(int index) {
        if (!isElementIndex(index)) { throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size); }
    }

    // 检查 index 索引位置是否可以添加元素
    private void checkPositionIndex(int index) {
        if (!isPositionIndex(index)) { throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size); }
    }

    private void display() {
        System.out.println("size = " + size);
        for (Node<T> p = head.next; p != tail; p = p.next) {
            System.out.print(p.data + " <-> ");
        }
        System.out.println("null");
        System.out.println();
    }

    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addFirst(0);
        list.add(2, 100);

        list.display();
        // size = 5
        // 0 <-> 1 <-> 100 <-> 2 -> 3 -> null
    }

}
