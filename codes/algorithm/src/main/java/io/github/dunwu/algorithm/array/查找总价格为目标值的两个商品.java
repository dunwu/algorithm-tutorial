package io.github.dunwu.algorithm.array;

import org.junit.jupiter.api.Assertions;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/he-wei-sde-liang-ge-shu-zi-lcof/description/">LCR 179. 查找总价格为目标值的两个商品</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-01-13
 */
public class 查找总价格为目标值的两个商品 {

    public static void main(String[] args) {
        Assertions.assertArrayEquals(new int[] { 3, 15 }, twoSum(new int[] { 3, 9, 12, 15 }, 18));
        Assertions.assertArrayEquals(new int[] { 27, 34 }, twoSum(new int[] { 8, 21, 27, 34, 52, 66 }, 61));

        Assertions.assertArrayEquals(new int[] { 3, 15 }, twoSum2(new int[] { 3, 9, 12, 15 }, 18));
        Assertions.assertArrayEquals(new int[] { 27, 34 }, twoSum2(new int[] { 8, 21, 27, 34, 52, 66 }, 61));
    }

    /**
     * 时间复杂度：O(N)
     */
    public static int[] twoSum(int[] price, int target) {
        Map<Integer, Integer> map = new HashMap<>(price.length);
        for (int i = 0; i < price.length; i++) {
            int diff = target - price[i];
            if (map.containsKey(diff)) {
                return new int[] { diff, price[i] };
            } else {
                map.put(price[i], i);
            }
        }
        return new int[0];
    }

    public static int[] twoSum2(int[] price, int target) {
        int left = 0, right = price.length - 1;
        while (left < right) {
            int sum = price[left] + price[right];
            if (sum == target) {
                return new int[] { price[left], price[right] };
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[0];
    }

}
