package io.github.dunwu.algorithm.divide;

import org.junit.jupiter.api.Assertions;

import java.util.Arrays;

/**
 * 多数元素
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @see <a href="https://leetcode-cn.com/problems/majority-element/">多数元素</a>
 * @since 2020-07-02
 */
public class 多数元素 {

    public static void main(String[] args) {
        Assertions.assertEquals(3, majorityElement(new int[] { 3, 2, 3 }));
        Assertions.assertEquals(2, majorityElement(new int[] { 2, 2, 1, 1, 1, 2, 2 }));
        Assertions.assertEquals(6, majorityElement(new int[] { 6, 6, 6, 7, 7 }));
    }

    // 暴力破解法
    // 时间复杂度：O(N) + O(log N)
    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int max = 1;
        int count = 0;
        int currElem = nums[0];
        int maxElem = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != currElem) {
                count = 1;
                currElem = nums[i];
            } else {
                count++;
                if (maxElem == currElem) {
                    max = count;
                } else {
                    if (max < count) {
                        maxElem = currElem;
                    }
                }
            }
        }
        return maxElem;
    }

}
