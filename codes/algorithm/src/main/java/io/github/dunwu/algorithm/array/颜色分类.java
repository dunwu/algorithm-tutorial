package io.github.dunwu.algorithm.array;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.ReflectUtil;
import org.junit.jupiter.api.Assertions;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * <a href="https://leetcode.cn/problems/sort-colors/">75. 颜色分类</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2025-08-06
 */
public class 颜色分类 {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        test(颜色分类.class, "sortColors2");
        test(颜色分类.class, "sortColors3");
    }

    public static void test(Class<?> clazz, String methodName)
        throws InvocationTargetException, IllegalAccessException {

        Method method = ReflectUtil.getMethodByName(clazz, methodName);

        int[] arr1 = new int[] { 2, 0, 2, 1, 1, 0 };
        method.invoke(clazz, arr1);
        Assertions.assertTrue(ArrayUtil.equals(new int[] { 0, 0, 1, 1, 2, 2 }, arr1));

        int[] arr2 = new int[] { 2, 0, 1 };
        method.invoke(clazz, arr2);
        Assertions.assertTrue(ArrayUtil.equals(new int[] { 0, 1, 2 }, arr2));

        int[] arr3 = new int[] { 1, 2 };
        method.invoke(clazz, arr3);
        Assertions.assertTrue(ArrayUtil.equals(new int[] { 1, 2 }, arr3));
    }

    /**
     * 先将 2 往后移，再将 1 往后移：时间复杂度 O(2N)
     */
    public static void sortColors2(int[] nums) {
        int len = moveToTail(nums, nums.length, 2);
        int len2 = moveToTail(nums, len, 1);
    }

    public static int moveToTail(int[] nums, int len, int val) {
        if (nums == null || len <= 1) {
            return len;
        }
        int slow = 0, fast = 0;
        while (fast < len) {
            if (nums[fast] != val) {
                int temp = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = temp;
                slow++;
            }
            fast++;
        }
        return slow;
    }

    /**
     * 冒泡排序：时间复杂度 O(N^2)
     */
    public static void sortColors3(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }

}
