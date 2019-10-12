package io.github.dunwu.ds.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Zhang Peng
 * @date 2018-11-05
 */
public class RotateArrayTest {

	@Test
	public void test() {
		int[] nums1 = { 1, 2, 3, 4, 5, 6, 7 };
		int[] expected1 = { 5, 6, 7, 1, 2, 3, 4 };
		RotateArray.rotate(nums1, 3);
		Assert.assertArrayEquals(expected1, nums1);

		int[] nums2 = { -1, -100, 3, 99 };
		int[] expected2 = { 3, 99, -1, -100 };
		RotateArray.rotate(nums2, 2);
		Assert.assertArrayEquals(expected2, nums2);
	}

}
