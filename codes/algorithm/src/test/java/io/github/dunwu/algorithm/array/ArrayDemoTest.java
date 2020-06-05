package io.github.dunwu.algorithm.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-03-11
 */
public class ArrayDemoTest {

    @Test
    public void containsDuplicateTest() {
        Assertions.assertTrue(ArrayDemo.containsDuplicate(new Integer[] { 1, 2, 3, 1 }));
        Assertions.assertFalse(ArrayDemo.containsDuplicate(new Integer[] { 1, 2, 3, 4 }));
        Assertions.assertTrue(ArrayDemo.containsDuplicate(new Integer[] { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 }));
    }

    @Test
    public void statisticsTest() {
        Assertions.assertEquals(2, ArrayDemo.count(8, new Integer[] { 7, 8, 5, 10, 7, 8 }));
        Assertions.assertEquals(0, ArrayDemo.count(6, new Integer[] { 5, 7, 7, 8, 8, 10 }));
        Assertions.assertEquals(2, ArrayDemo.count("abc", new String[] { "abc", "xyz", "lmn", "abc" }));
    }

    @Test
    public void test() {
    }

}
