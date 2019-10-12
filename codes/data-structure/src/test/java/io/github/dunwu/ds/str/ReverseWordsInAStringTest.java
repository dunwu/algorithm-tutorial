package io.github.dunwu.ds.str;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Zhang Peng
 * @date 2018-11-05
 */
public class ReverseWordsInAStringTest {

	@Test
	public void test() {
		Assert.assertEquals("blue is sky the", ReverseWordsInAString.reverseWords("the sky is blue"));
		Assert.assertEquals("  ", ReverseWordsInAString.reverseWords("  "));
		Assert.assertEquals("1", ReverseWordsInAString.reverseWords("1 "));
	}

}
