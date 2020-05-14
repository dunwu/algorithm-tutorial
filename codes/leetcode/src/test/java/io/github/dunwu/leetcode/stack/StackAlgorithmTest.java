package io.github.dunwu.leetcode.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-05-13
 */
public class StackAlgorithmTest {

    @Test
    public void test() {
        StackAlgorithm.SortedStack demo = new StackAlgorithm.SortedStack();
        demo.push(1);
        System.out.println(demo.stack1);
        demo.push(2);
        System.out.println(demo.stack1);
        // Assertions.assertEquals(1, demo.peek());
        // Assertions.assertEquals(-1, demo.pop());
        // Assertions.assertEquals(2, demo.peek());
    }

}
