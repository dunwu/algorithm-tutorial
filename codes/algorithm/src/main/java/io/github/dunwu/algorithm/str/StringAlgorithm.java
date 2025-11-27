package io.github.dunwu.algorithm.str;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-01-18
 */
public class StringAlgorithm {

    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     * <p>
     * 示例 1:
     * <p>
     * 输入: "abcabcbb" 输出: 3 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。 示例 2:
     * <p>
     * 输入: "bbbbb" 输出: 1 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。 示例 3:
     * <p>
     * 输入: "pwwkew" 输出: 3 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     * <p>
     * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     *
     * @see <a href="https://leetcode-cn.com/explore/featured/card/bytedance/242/string/1012/">无重复字符的最长子串</a>
     */
    public static int lengthOfLongestSubstring(String s) {
        if (null == s || s.length() == 0) {
            return 0;
        }

        int max = 0;
        int left = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }

    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     * <p>
     * 如果不存在公共前缀，返回空字符串 ""。
     * <p>
     * 示例 1:
     * <p>
     * 输入: ["flower","flow","flight"] 输出: "fl" 示例 2:
     * <p>
     * 输入: ["dog","racecar","car"] 输出: "" 解释: 输入不存在公共前缀。 说明:
     * <p>
     * 所有输入只包含小写字母 a-z 。
     *
     * @see <a href="https://leetcode-cn.com/explore/featured/card/bytedance/242/string/1014/">最长公共前缀</a>
     */
    public static String longestCommonPrefix(String[] array) {
        if (array == null || array.length == 0) {
            return "";
        } else if (array.length == 1) {
            return array[0];
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < array[0].length(); i++) {
                char c = array[0].charAt(i);
                boolean end = false;
                for (int index = 1; index < array.length; index++) {
                    if (array[index].length() - 1 < i) {
                        end = true;
                        break;
                    }

                    if (array[index].charAt(i) != c) {
                        end = true;
                        break;
                    }
                }
                if (end) {
                    break;
                } else {
                    sb.append(c);
                }
            }
            return sb.toString();
        }
    }

    /**
     * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
     * <p>
     * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
     * <p>
     * 示例1: 输入: s1 = "ab" s2 = "eidbaooo" 输出: True 解释: s2 包含 s1 的排列之一 ("ba").
     * <p>
     * 示例2: 输入: s1= "ab" s2 = "eidboaoo" 输出: False
     * <p>
     * 注意：输入的字符串只包含小写字母，两个字符串的长度都在 [1, 10,000] 之间
     *
     * @see <a href="https://leetcode-cn.com/explore/featured/card/bytedance/242/string/1016/">字符串的排列</a>
     */
    public static boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0) {
            return false;
        }

        int len1 = s1.length();
        int len2 = s2.length();

        // 字母命中数统计
        int[] count1 = new int[26];
        int[] count2 = new int[26];

        for (char c : s1.toCharArray()) {
            count1[c - 'a']++;
        }

        for (int i = 0; i < len2; i++) {
            if (i >= len1) {
                count2[s2.charAt(i - len1) - 'a']--;
            }

            count2[s2.charAt(i) - 'a']++;
            if (Arrays.equals(count1, count2)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
     * <p>
     * 示例 1:
     * <p>
     * 输入: num1 = "2", num2 = "3" 输出: "6" 示例 2:
     * <p>
     * 输入: num1 = "123", num2 = "456" 输出: "56088"
     * <p>
     * 说明：num1 和 num2 的长度小于110。 num1 和 num2 只包含数字 0-9。 num1 和 num2 均不以零开头，除非是数字 0 本身。
     * <p>
     * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
     *
     * @see <a href="https://leetcode-cn.com/explore/featured/card/bytedance/242/string/1015/">字符串相乘</a>
     */
    public static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        String result = "0";
        for (int i = num1.length() - 1; i >= 0; i--) {

            int carry = 0;

            StringBuilder tempBuilder = new StringBuilder();
            int value1 = num1.charAt(i) - '0';

            for (int temp = i; temp < num1.length() - 1; temp++) {
                tempBuilder.append("0");
            }

            for (int j = num2.length() - 1; j >= 0; j--) {
                int value2 = num2.charAt(j) - '0';
                int value = value1 * value2 + carry;
                int current = value % 10;
                carry = value / 10;
                tempBuilder.append(current);
            }

            if (carry > 0) {
                tempBuilder.append(carry);
            }

            result = add(result, tempBuilder.reverse().toString());
        }

        return result;
    }

    public static String add(String num1, String num2) {
        StringBuilder builder = new StringBuilder();
        int carry = 0;

        for (int i = num1.length() - 1, j = num2.length() - 1;
            i >= 0 || j >= 0;
            i--, j--) {

            int result = carry;
            if (i >= 0) {
                result += num1.charAt(i) - '0';
            }
            if (j >= 0) {
                result += num2.charAt(j) - '0';
            }
            carry = result / 10;
            int current = result % 10;
            builder.append(current);
        }
        if (carry > 0) {
            builder.append(carry);
        }
        return builder.reverse().toString();
    }

    /**
     * 给定一个字符串，逐个翻转字符串中的每个单词。
     * <p>
     * 示例 1： 输入: "the sky is blue" 输出: "blue is sky the"
     * <p>
     * 示例 2： 输入: "  hello world!  " 输出: "world! hello" 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
     * <p>
     * 示例 3： 输入: "a good   example" 输出: "example good a" 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
     * <p>
     * 说明： 无空格字符构成一个单词。 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
     * <p>
     * 进阶： 请选用 C 语言的用户尝试使用 O(1) 额外空间复杂度的原地解法。
     *
     * @see <a href="https://leetcode-cn.com/explore/featured/card/bytedance/242/string/1011/">翻转字符串里的单词</a>
     */
    public static String reverseWords(String s) {
        StringBuilder builder = new StringBuilder();
        List<String> list = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (c != ' ') {
                builder.append(c);
            } else {
                if (!builder.toString().equals("")) {
                    list.add(builder.toString());
                }
                builder = new StringBuilder();
            }
        }
        if (!builder.toString().equals("")) {
            list.add(builder.toString());
        }

        builder = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--) {

            builder.append(list.get(i));
            if (i != 0) {
                builder.append(" ");
            }
        }
        return builder.toString();
    }

    /**
     * 以 Unix 风格给出一个文件的绝对路径，你需要简化它。或者换句话说，将其转换为规范路径。
     * <p>
     * 在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；两者都可以是复杂相对路径的组成部分。更多信息请参阅：Linux / Unix中的绝对路径 vs
     * 相对路径
     * <p>
     * 请注意，返回的规范路径必须始终以斜杠 / 开头，并且两个目录名之间必须只有一个斜杠 /。最后一个目录名（如果存在）不能以 / 结尾。此外，规范路径必须是表示绝对路径的最短字符串。
     * <p>
     * 示例 1： 输入："/home/" 输出："/home" 解释：注意，最后一个目录名后面没有斜杠。
     * <p>
     * 示例 2： 输入："/../" 输出："/" 解释：从根目录向上一级是不可行的，因为根是你可以到达的最高级。
     * <p>
     * 示例 3： 输入："/home//foo/" 输出："/home/foo" 解释：在规范路径中，多个连续斜杠需要用一个斜杠替换。
     * <p>
     * 示例 4： 输入："/a/./b/../../c/" 输出："/c"
     * <p>
     * 示例 5： 输入："/a/../../b/../c//.//" 输出："/c"
     * <p>
     * 示例 6： 输入："/a//b////c/d//././/.." 输出："/a/b/c"
     *
     * @see <a href="https://leetcode-cn.com/explore/featured/card/bytedance/242/string/1013/">简化路径</a>
     */
    public static String simplifyPath(String path) {
        if (path.equals("/")) {
            return path;
        }

        if (path.endsWith("/")) {
            path = path.substring(0, path.length() - 1);
        }

        if (path.startsWith("/../")) {
            path = path.replaceFirst("/../", "/");
        }

        path = path.replaceAll("//", "/");
        return path;
    }

}
