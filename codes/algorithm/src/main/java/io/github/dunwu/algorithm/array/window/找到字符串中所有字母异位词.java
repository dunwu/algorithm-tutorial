package io.github.dunwu.algorithm.array.window;

import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/find-all-anagrams-in-a-string/">438. 找到字符串中所有字母异位词</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-10-14
 */
public class 找到字符串中所有字母异位词 {

    public static void main(String[] args) {
        Assertions.assertArrayEquals(new Integer[] { 0, 6 }, findAnagrams("cbaebabacd", "abc").toArray());
        Assertions.assertArrayEquals(new Integer[] { 0, 1, 2 }, findAnagrams("abab", "ab").toArray());
    }

    public static List<Integer> findAnagrams(String s, String p) {
        // 定义窗口：条件窗口、临时窗口
        HashMap<Character, Integer> need = new HashMap<>(p.length());
        HashMap<Character, Integer> window = new HashMap<>(p.length());
        for (char c : p.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        // 符合条件字符数
        int valid = 0;
        // 窗口边界
        int left = 0, right = 0;
        // 符合条件的子串起始位置（长度固定，和 p 相等）
        List<Integer> res = new ArrayList<>();

        while (right < s.length()) {
            char r = s.charAt(right);
            // 窗口扩展
            right++;
            if (need.containsKey(r)) {
                window.put(r, window.getOrDefault(r, 0) + 1);
                if (window.get(r).equals(need.get(r))) {
                    valid++;
                }
            }

            while (valid == need.size()) {
                // 更新信息
                if (right - left == p.length()) {
                    // System.out.format("窗口：[left: %s, right: %s), 子串：%s\n",
                    //     left, right, s.substring(left, left + p.length()));
                    res.add(left);
                }

                char l = s.charAt(left);
                // 窗口收缩
                left++;
                if (need.containsKey(l)) {
                    if (window.get(l).equals(need.get(l))) {
                        valid--;
                    }
                    window.put(l, window.get(l) - 1);
                }
            }
        }
        return res;
    }

}
