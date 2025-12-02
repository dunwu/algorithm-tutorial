package io.github.dunwu.algorithm.list;

import io.github.dunwu.algorithm.linkedlist.demo.DoublyLinkedList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-01-26
 */
public class DoubleLinkListTests {

    @Test
    public void addTest() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.addLast(2);
        list.addLast(3);
        list.addFirst(1);
        List<Integer> result = list.toList();
        System.out.println(result);
        Assertions.assertArrayEquals(new Integer[] { 1, 2, 3 }, result.toArray());
    }

    @Test
    public void removeFirstTest() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.addLast(1);
        list.addLast(1);
        list.remove(new Integer(1));
        List<Integer> result = list.toList();
        System.out.println(result);
        Assertions.assertArrayEquals(new Integer[] { 1 }, result.toArray());

        list.clear();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.remove(new Integer(1));
        result = list.toList();
        System.out.println(result);
        Assertions.assertArrayEquals(new Integer[] { 2, 3 }, result.toArray());

        list.clear();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.remove(new Integer(3));
        result = list.toList();
        System.out.println(result);
        Assertions.assertArrayEquals(new Integer[] { 1, 2 }, result.toArray());

        list.clear();
        list.addLast(1);
        list.addLast(2);
        list.remove(new Integer(4));
        result = list.toList();
        System.out.println(result);
        Assertions.assertArrayEquals(new Integer[] { 1, 2 }, result.toArray());
    }

    @Test
    public void removeAllTest() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.addLast(1);
        list.addLast(1);
        list.addLast(1);
        list.removeAll(1);
        List<Integer> result = list.toList();
        System.out.println(result);
        Assertions.assertArrayEquals(new Integer[] {}, result.toArray());

        list.clear();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.removeAll(4);
        result = list.toList();
        System.out.println(result);
        Assertions.assertArrayEquals(new Integer[] { 1, 2, 3 }, result.toArray());
    }

}
