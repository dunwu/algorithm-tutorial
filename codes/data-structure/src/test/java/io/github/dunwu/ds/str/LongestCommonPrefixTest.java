package io.github.dunwu.ds.str;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Zhang Peng
 * @date 2018-11-05
 */
public class LongestCommonPrefixTest {
    @Test
    public void test() {
        String[] strs1 = {"flower", "flow", "flight"};
        String[] strs2 = {"dog", "racecar", "car"};

        Assert.assertEquals("fl", LongestCommonPrefix.longestCommonPrefix(strs1));
        Assert.assertEquals("", LongestCommonPrefix.longestCommonPrefix(strs2));
    }
}
