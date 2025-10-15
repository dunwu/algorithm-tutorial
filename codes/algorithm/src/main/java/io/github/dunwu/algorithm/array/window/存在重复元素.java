package io.github.dunwu.algorithm.array.window;

import org.junit.jupiter.api.Assertions;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode-cn.com/problems/contains-duplicate/">217. 存在重复元素</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-06-05
 */
public class 存在重复元素 {

    public static void main(String[] args) {
        Assertions.assertTrue(containsDuplicate(new int[] { 1, 2, 3, 1 }));
        Assertions.assertFalse(containsDuplicate(new int[] { 1, 2, 3, 4 }));
        Assertions.assertTrue(containsDuplicate(new int[] { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 }));
    }

    public static boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }

}
