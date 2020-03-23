package io.github.dunwu.leetcode.str;

//    【最长公共前缀】

//
//    编写一个函数来查找字符串数组中的最长公共前缀。
//
//    如果不存在公共前缀，返回空字符串 ""。
//
//    示例 1:
//
//    输入: ["flower","flow","flight"]
//    输出: "fl"
//    示例 2:
//
//    输入: ["dog","racecar","car"]
//    输出: ""
//    解释: 输入不存在公共前缀。
//    说明:
//
//    所有输入只包含小写字母 a-z 。

/**
 * @author Zhang Peng
 * @since 2018-11-05
 */
public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        int index = 0;
        StringBuilder sb = new StringBuilder();

        while (index < strs[0].length()) {
            char c = strs[0].charAt(index);
            boolean flag = true;
            for (String str : strs) {
                if (index >= str.length()) {
                    flag = false;
                    break;
                }
                if (str.charAt(index) != c) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                sb.append(c);
                index++;
            } else {
                break;
            }
        }
        return sb.toString();
    }

}
