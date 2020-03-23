package io.github.dunwu.leetcode.list;

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
        SingleLinkList<Integer> list = new SingleLinkList<>();
        list.addTail(2);
        list.addTail(3);
        list.addHead(1);
        List<Integer> result = list.toList();
        System.out.println(result);
        Assertions.assertArrayEquals(new Integer[] { 1, 2, 3 }, result.toArray());
    }

    @Test
    public void removeFirstTest() {
        SingleLinkList<Integer> list = new SingleLinkList<>();
        list.addTail(1);
        list.addTail(1);
        list.removeFirst(1);
        List<Integer> result = list.toList();
        System.out.println(result);
        Assertions.assertArrayEquals(new Integer[] { 1 }, result.toArray());

        list.clear();
        list.addTail(1);
        list.addTail(2);
        list.addTail(3);
        list.removeFirst(1);
        result = list.toList();
        System.out.println(result);
        Assertions.assertArrayEquals(new Integer[] { 2, 3 }, result.toArray());

        list.clear();
        list.addTail(1);
        list.addTail(2);
        list.addTail(3);
        list.removeFirst(3);
        result = list.toList();
        System.out.println(result);
        Assertions.assertArrayEquals(new Integer[] { 1, 2 }, result.toArray());

        list.clear();
        list.addTail(1);
        list.addTail(2);
        list.removeFirst(4);
        result = list.toList();
        System.out.println(result);
        Assertions.assertArrayEquals(new Integer[] { 1, 2 }, result.toArray());
    }

    @Test
    public void removeAllTest() {
        SingleLinkList<Integer> list = new SingleLinkList<>();
        list.addTail(1);
        list.addTail(1);
        list.addTail(1);
        list.removeAll(1);
        List<Integer> result = list.toList();
        System.out.println(result);
        Assertions.assertArrayEquals(new Integer[] {}, result.toArray());

        list.clear();
        list.addTail(1);
        list.addTail(2);
        list.addTail(3);
        list.removeAll(4);
        result = list.toList();
        System.out.println(result);
        Assertions.assertArrayEquals(new Integer[] { 1, 2, 3 }, result.toArray());
    }

}
