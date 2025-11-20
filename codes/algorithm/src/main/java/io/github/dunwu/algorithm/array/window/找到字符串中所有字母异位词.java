package io.github.dunwu.algorithm.array.window;

import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/find-all-anagrams-in-a-string/">438. 找到字符串中所有字母异位词</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-10-14
 */
public class 找到字符串中所有字母异位词 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertArrayEquals(new Integer[] { 0, 6 }, s.findAnagrams("cbaebabacd", "abc").toArray());
        Assertions.assertArrayEquals(new Integer[] { 0, 1, 2 }, s.findAnagrams("abab", "ab").toArray());
    }

    static class Solution {

        public List<Integer> findAnagrams(String s, String t) {
            Map<Character, Integer> need = new HashMap<>();
            Map<Character, Integer> window = new HashMap<>();
            for (char c : t.toCharArray()) {
                need.put(c, need.getOrDefault(c, 0) + 1);
            }

            int left = 0, right = 0;
            int valid = 0;
            // 记录结果
            List<Integer> res = new ArrayList<>();
            while (right < s.length()) {
                char c = s.charAt(right);
                right++;
                // 进行窗口内数据的一系列更新
                if (need.containsKey(c)) {
                    window.put(c, window.getOrDefault(c, 0) + 1);
                    if (window.get(c).equals(need.get(c))) {
                        valid++;
                    }
                }
                // 判断左侧窗口是否要收缩
                while (right - left >= t.length()) {
                    // 当窗口符合条件时，把起始索引加入 res
                    if (valid == need.size()) {
                        res.add(left);
                    }
                    char d = s.charAt(left);
                    left++;
                    // 进行窗口内数据的一系列更新
                    if (need.containsKey(d)) {
                        if (window.get(d).equals(need.get(d))) {
                            valid--;
                        }
                        window.put(d, window.get(d) - 1);
                    }
                }
            }
            return res;
        }

    }

}
