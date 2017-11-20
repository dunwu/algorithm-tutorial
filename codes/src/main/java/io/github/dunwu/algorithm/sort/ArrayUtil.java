package io.github.dunwu.algorithm.sort;

import java.util.Random;

/**
 * @author Zhang Peng
 */
public class ArrayUtil {
    public static void printArray(int[] list, int begin, int end) {
        for (int i = 0; i < begin; i++) {
            System.out.print("\t");
        }
        int count = 0;
        for (int i = begin; i <= end; i++) {
            System.out.print(list[i] + "\t");
            if (++count == 10) {
                System.out.println();
                count = 0;
            }
        }
        System.out.println();
    }

    /**
     * 随机指定范围内N个不重复的数 在初始化的无重复待选数组中随机产生一个数放入结果中， 将待选数组被随机到的数，用待选数组(len-1)下标对应的数替换
     * 然后从len-2里随机产生下一个随机数，如此类推
     * 
     * @param max 指定范围最大值
     * @param min 指定范围最小值
     * @param length 随机数个数
     * @return int[] 随机数结果集
     */
    public static int[] randomArray(int min, int max, int length) {
        int len = max - min + 1;

        if (max < min || length > len) {
            return null;
        }

        // 初始化给定范围的待选数组
        int[] source = new int[len];
        for (int i = min; i < min + len; i++) {
            source[i - min] = i;
        }

        int[] result = new int[length];
        Random rd = new Random();
        int index = 0;
        for (int i = 0; i < result.length; i++) {
            // 待选数组0到(len-2)随机一个下标
            index = Math.abs(rd.nextInt() % len--);
            // 将随机到的数放入结果集
            result[i] = source[index];
            // 将待选数组中被随机到的数，用待选数组(len-1)下标对应的数替换
            source[index] = source[len];
        }
        return result;
    }
}
