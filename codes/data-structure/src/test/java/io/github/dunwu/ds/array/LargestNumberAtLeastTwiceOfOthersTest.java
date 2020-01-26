package io.github.dunwu.ds.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Zhang Peng
 * @since 2018-11-05
 */
public class LargestNumberAtLeastTwiceOfOthersTest {

    @Test
    public void test() {
        int[] nums1 = { 3, 6, 1, 0 };
        int[] nums2 = { 1, 2, 3, 4 };

        Assertions.assertEquals(1, LargestNumberAtLeastTwiceOfOthers.dominantIndex(nums1));
        Assertions.assertEquals(-1, LargestNumberAtLeastTwiceOfOthers.dominantIndex(nums2));
    }

}
