package io.github.dunwu.algorithm.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Zhang Peng
 * @since 2018-11-05
 */
public class RemoveElementTest {

    @Test
    public void test() {
        int[] nums1 = { 3, 2, 2, 3 };
        Assertions.assertEquals(2, RemoveElement.removeElement(nums1, 3));
    }

}
