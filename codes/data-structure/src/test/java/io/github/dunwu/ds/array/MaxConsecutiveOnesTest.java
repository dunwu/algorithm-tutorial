package io.github.dunwu.ds.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Zhang Peng
 * @since 2018-11-05
 */
public class MaxConsecutiveOnesTest {

    @Test
    public void test() {
        Assertions.assertEquals(3, MaxConsecutiveOnes.findMaxConsecutiveOnes(new int[] { 1, 1, 0, 1, 1, 1 }));
    }

}
