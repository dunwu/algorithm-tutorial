package io.github.dunwu.ds.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Zhang Peng
 * @since 2018-11-05
 */
public class LargestNumberAtLeastTwiceOfOthersTest {

	@Test
	public void test() {
		int[] nums1 = {3, 6, 1, 0}
		int[] nums2 = {1, 2, 3, 4}

		Assert.assertEquals(1, LargestNumberAtLeastTwiceOfOthers.dominantIndex(nums1));
		Assert.assertEquals(-1, LargestNumberAtLeastTwiceOfOthers.dominantIndex(nums2));
	}

}
