package io.github.dunwu.algorithm.string;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-01-18
 */
public class StringAlgorithmTest {

    @Test
    public void lengthOfLongestSubstring() {
        int len = StringAlgorithm.lengthOfLongestSubstring("abcabcbb");
        Assert.assertEquals(3, len);

        len = StringAlgorithm.lengthOfLongestSubstring("bbbbb");
        Assert.assertEquals(1, len);

        len = StringAlgorithm.lengthOfLongestSubstring("pwwkew");
        Assert.assertEquals(3, len);
    }

    @Test
    public void longestCommonPrefix() {
        String str = StringAlgorithm.longestCommonPrefix(new String[] { "flower", "flow", "flight" });
        Assert.assertEquals("fl", str);

        str = StringAlgorithm.longestCommonPrefix(new String[] { "dog", "racecar", "car" });
        Assert.assertEquals("", str);
    }

    @Test
    public void checkInclusion() {
        boolean result = StringAlgorithm.checkInclusion("ab", "eidbaooo");
        Assert.assertEquals(true, result);

        result = StringAlgorithm.checkInclusion("ab", "eidboaoo");
        Assert.assertEquals(false, result);
    }

    @Test
    public void multiply() {
        String result = StringAlgorithm.multiply("2", "3");
        Assert.assertEquals("6", result);

        result = StringAlgorithm.multiply("333", "2");
        Assert.assertEquals("666", result);

        result = StringAlgorithm.multiply("123", "456");
        Assert.assertEquals("56088", result);

        result = StringAlgorithm.multiply("123456789", "987654321");
        Assert.assertEquals("121932631112635269", result);

        result = StringAlgorithm.multiply("498828660196", "840477629533");
        Assert.assertEquals("419254329864656431168468", result);
    }

    @Test
    public void add() {
        String result = StringAlgorithm.add("100000000000000000000", "8888");
        Assert.assertEquals("100000000000000008888", result);

        result = StringAlgorithm.add("1368", "9120");
        Assert.assertEquals("10488", result);
    }

    @Test
    public void reverseWords() {
        String result = StringAlgorithm.reverseWords("the sky is blue");
        Assert.assertEquals("blue is sky the", result);

        result = StringAlgorithm.reverseWords("  hello world!  ");
        Assert.assertEquals("world! hello", result);

        result = StringAlgorithm.reverseWords("a good   example");
        Assert.assertEquals("example good a", result);
    }

    @Test
    public void simplifyPath() {
        String result = StringAlgorithm.simplifyPath("/home/");
        Assert.assertEquals("/home", result);

        result = StringAlgorithm.simplifyPath("/../");
        Assert.assertEquals("/", result);

        result = StringAlgorithm.simplifyPath("/home//foo/");
        Assert.assertEquals("/home/foo", result);

        result = StringAlgorithm.simplifyPath("/a/./b/../../c/");
        Assert.assertEquals("/c", result);
    }

}
