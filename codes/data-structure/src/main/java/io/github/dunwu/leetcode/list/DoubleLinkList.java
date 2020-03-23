package io.github.dunwu.leetcode.list;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-01-26
 */
public class DoubleLinkList<E> {

    /** 头节点 */
    private DListNode<E> head;

    /** 尾节点 */
    private DListNode<E> tail;

    public DoubleLinkList() {
        this.head = new DListNode<>();
        this.tail = new DListNode<>();

        this.head.value = null;
        this.head.prev = null;
        this.head.next = this.tail;

        this.tail.value = null;
        this.tail.prev = this.head;
        this.tail.next = null;
    }

    private static class DListNode<E> {

        E value;

        DListNode<E> prev;

        DListNode<E> next;

        DListNode() {}

        DListNode(DListNode<E> prev, E value, DListNode<E> next) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }

    }

    /**
     * 头插法
     *
     * @param value 数据值
     */
    public void addHead(E value) {
        DListNode<E> newNode = new DListNode<>(null, value, null);

        this.head.next.prev = newNode;
        newNode.next = this.head.next;

        this.head.next = newNode;
        newNode.prev = this.head;
    }

    /**
     * 尾插法
     *
     * @param value 数据值
     */
    public void addTail(E value) {
        DListNode<E> newNode = new DListNode<>(null, value, null);

        this.tail.prev.next = newNode;
        newNode.prev = this.tail.prev;

        this.tail.prev = newNode;
        newNode.next = this.tail;
    }

    /**
     * 删除节点
     *
     * @param value 数据值
     */
    public void remove(E value) {
        DListNode<E> prev = this.head;
        while (prev.next != this.tail) {
            DListNode<E> curr = prev.next;
            if (curr.value.equals(value)) {
                prev.next = curr.next;
                curr.next.prev = prev;
                curr.next = null;
                curr.prev = null;
                break;
            }
            prev = prev.next;
        }
    }

    /**
     * 查找节点
     *
     * @param value 数据值
     */
    public DListNode<E> find(E value) {
        DListNode<E> node = this.head.next;
        while (node != this.tail) {
            if (node.value.equals(value)) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public void printList() {
        DListNode<E> node = this.head.next;
        while (node != this.tail) {
            System.out.println(node.value);
            node = node.next;
        }
    }

    public static void main(String[] args) {
        DoubleLinkList<Integer> list = new DoubleLinkList<>();
        list.addTail(2);
        list.addTail(3);
        list.addHead(1);

        list.remove(1);
        System.out.println("list.find(1) = " + list.find(1));
        System.out.println("list.find(2) = " + list.find(2));
        list.printList();
    }

}
