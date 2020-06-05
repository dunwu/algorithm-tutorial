package io.github.dunwu.algorithm.array;

//    【最大连续1的个数】

//
//    给定一个二进制数组， 计算其中最大连续1的个数。
//
//    示例 1:
//
//    输入: [1,1,0,1,1,1]
//    输出: 3
//    解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
//    注意：
//
//    输入的数组只包含 0 和1。
//    输入数组的长度是正整数，且不超过 10,000。

import org.junit.jupiter.api.Assertions;

/**
 * @author Zhang Peng
 * @since 2018-11-05
 */
public class 最大连续1的个数 {

    public static void main(String[] args) {
        Assertions.assertEquals(3, 最大连续1的个数.findMaxConsecutiveOnes(new int[] { 1, 1, 0, 1, 1, 1 }));
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
            } else {
                if (count > max) {
                    max = count;
                }
                count = 0;
            }
        }

        if (count > max) {
            max = count;
        }
        return max;
    }

}
