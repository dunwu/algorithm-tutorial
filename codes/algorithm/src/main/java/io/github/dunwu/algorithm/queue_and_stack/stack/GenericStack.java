package io.github.dunwu.algorithm.queue_and_stack.stack;

/**
 * 简化版泛型栈
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-06-09
 */
public class GenericStack<T> {

    private int size = 0;
    private Node<T> top = null;

    public void push(T value) {
        Node<T> node = new Node<>(value, null);
        if (top == null) {
            top = node;
        } else {
            node.next = top;
            top = node;
        }
        size++;
    }

    public T pop() {
        if (top == null) {
            return null;
        }
        T val = top.data;
        top = top.next;
        size--;
        return val;
    }

    public T peek() {
        if (top == null) {
            return null;
        }
        return top.data;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void printAll() {
        Node<T> p = top;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    private static class Node<T> {

        private T data;
        private Node<T> next;

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        public T getData() {
            return data;
        }

    }

}
