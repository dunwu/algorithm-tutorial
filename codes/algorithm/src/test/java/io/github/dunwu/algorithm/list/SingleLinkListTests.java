package io.github.dunwu.algorithm.list;

import io.github.dunwu.algorithm.linkedlist.SinglyLinkedList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-01-26
 */
public class SingleLinkListTests {

    @Test
    public void addTest() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.addLast(2);
        list.addLast(3);
        list.addFirst(1);
        List<Integer> result = list.toList();
        System.out.println(result);
        Assertions.assertArrayEquals(new Integer[] { 1, 2, 3 }, result.toArray());
    }

    @Test
    public void removeFirstTest() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
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
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
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
