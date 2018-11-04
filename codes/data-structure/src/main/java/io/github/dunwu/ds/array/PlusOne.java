package io.github.dunwu.ds.array;

//    【加一】
//
//    给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
//
//    最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
//
//    你可以假设除了整数 0 之外，这个整数不会以零开头。
//
//    示例 1:
//
//    输入: [1,2,3]
//    输出: [1,2,4]
//    解释: 输入数组表示数字 123。
//    示例 2:
//
//    输入: [4,3,2,1]
//    输出: [4,3,2,2]
//    解释: 输入数组表示数字 4321。


import io.github.dunwu.ds.util.ArrayUtil;

/**
 * @author Zhang Peng
 * @date 2018-11-04
 */
public class PlusOne {
    private static int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        int[] newNumber = new int[n + 1];
        newNumber[0] = 1;

        return newNumber;
    }

    private static String getArrayString(int[] array) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length - 1; i++) {
            sb.append(array[i] + ", ");
        }
        sb.append(array[array.length - 1]);
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {4, 3, 2, 1};
        int[] nums3 = {9, 9, 9, 9};

        int[] result1 = plusOne(nums1);
        int[] result2 = plusOne(nums2);
        int[] result3 = plusOne(nums3);

        System.out.println("nums1 = [" + ArrayUtil.getArrayString(result1, 0, result1.length - 1) + "]");
        System.out.println("nums2 = [" + ArrayUtil.getArrayString(result2, 0, result2.length - 1) + "]");
        System.out.println("nums3 = [" + ArrayUtil.getArrayString(result3, 0, result3.length - 1) + "]");
    }
}
