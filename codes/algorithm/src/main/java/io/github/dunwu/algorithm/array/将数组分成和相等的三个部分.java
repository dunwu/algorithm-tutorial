package io.github.dunwu.algorithm.array;

import org.junit.jupiter.api.Assertions;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-06-05
 */
public class 将数组分成和相等的三个部分 {

    public static void main(String[] args) {
        Assertions.assertTrue(canThreePartsEqualSum(new int[] { 0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1 }));
        Assertions.assertTrue(canThreePartsEqualSum(new int[] { 3, 3, 6, 5, -2, 2, 5, 1, -9, 4 }));
        Assertions.assertFalse(canThreePartsEqualSum(new int[] { 0, 2, 1, -6, 6, 7, 9, -1, 2, 0, 1 }));
    }

    /**
     * 题目：<a href="https://leetcode-cn.com/problems/partition-array-into-three-parts-with-equal-sum/">1013.
     * 将数组分成和相等的三个部分</a>
     * <p>
     * 给你一个整数数组 A，只有可以将其划分为三个和相等的非空部分时才返回 true，否则返回 false。
     * <p>
     * 形式上，如果可以找出索引 i+1 < j 且满足 (A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1] + ... +
     * A[A.length - 1]) 就可以将数组三等分。
     */
    public static boolean canThreePartsEqualSum(int[] array) {
        return false;
    }

}
