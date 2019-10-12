package io.github.dunwu.ds.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Zhang Peng
 * @date 2018-11-05
 */
public class RemoveElementTest {

	@Test
	public void test() {
		int[] nums1 = { 3, 2, 2, 3 };
		Assert.assertEquals(2, RemoveElement.removeElement(nums1, 3));
	}

}
