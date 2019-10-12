package io.github.dunwu.ds.str;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Zhang Peng
 * @date 2018-11-05
 */
public class ImplementStrstrTest {

	@Test
	public void test() {
		Assert.assertEquals(0, ImplementStrstr.strStr("", ""));
		Assert.assertEquals(-1, ImplementStrstr.strStr("aaa", "aaaa"));
		Assert.assertEquals(0, ImplementStrstr.strStr("aaa", ""));
		Assert.assertEquals(2, ImplementStrstr.strStr("hello", "ll"));
		Assert.assertEquals(-1, ImplementStrstr.strStr("aaaaa", "bba"));
		Assert.assertEquals(1, ImplementStrstr.strStr("mississippi", "issi"));
		Assert.assertEquals(9, ImplementStrstr.strStr("mississippi", "pi"));
	}

}
