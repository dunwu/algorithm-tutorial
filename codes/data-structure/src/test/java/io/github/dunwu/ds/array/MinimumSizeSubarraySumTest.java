package io.github.dunwu.ds.array;

import org.junit.Test;

/**
 * @author Zhang Peng
 * @date 2018-11-05
 */
public class MinimumSizeSubarraySumTest {

	@Test
	public void test() {
		MinimumSizeSubarraySum.minSubArrayLen(7, new int[] { 2, 3, 1, 2, 4, 3 });
		MinimumSizeSubarraySum.minSubArrayLen(11, new int[] { 2, 3, 1, 2, 4, 3 });
	}

}
