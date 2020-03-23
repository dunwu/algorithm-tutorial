package io.github.dunwu.leetcode.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

/**
 * @author Zhang Peng
 */
public class ArrayUtil {

    private static final Logger logger = LoggerFactory.getLogger(ArrayUtil.class);

    public static <T> void debugLogArray(T[] list, int begin, int end, String tip) {
        String content = tip + getArrayString(list, begin, end);
        if (logger.isDebugEnabled()) {
            logger.debug(content);
        }
    }

    public static <T> String getArrayString(T[] list, int begin, int end) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        for (int i = 0; i < begin; i++) {
            sb.append("\t");
        }
        int count = 0;
        for (int i = begin; i <= end; i++) {
            sb.append(list[i] + "\t");
            if (++count == 10) {
                sb.append("\n");
                count = 0;
            }
        }

        return sb.toString();
    }

    public static String getArrayString(int[] list, int begin, int end) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < begin; i++) {
            sb.append("\t");
        }
        int count = 0;
        for (int i = begin; i < end; i++) {
            sb.append(list[i] + "\t");
            if (++count == 10) {
                sb.append("\n");
                count = 0;
            }
        }
        sb.append(list[end]);

        return sb.toString();
    }

    /**
     * 随机指定范围内N个不重复的Int数组。
     * <p>
     * 在初始化的无重复待选数组中随机产生一个数放入结果中，
     * </p>
     * <p>
     * 将待选数组被随机到的数，用待选数组(len-1)下标对应的数替换，
     * </p>
     * <p>
     * 然后从len-2里随机产生下一个随机数，如此类推
     * </p>
     *
     * @param min    指定范围最小值
     * @param max    指定范围最大值
     * @param length 随机数个数
     * @return int[] 随机数结果集
     */
    public static int[] randomNoRepeatIntArray(int min, int max, int length) {
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

    /**
     * 随机指定范围内N个重复的Int数组。
     *
     * @param min    指定范围最小值
     * @param max    指定范围最大值
     * @param length 随机数个数
     * @return 随机数结果集
     */
    public static int[] randomRepeatIntArray(int min, int max, int length) {
        int len = max - min + 1;

        if (max < min || length > len) {
            return null;
        }

        int[] result = new int[length];
        for (int i = 0; i < result.length; i++) {
            result[i] = (int) (Math.random() * max);
        }
        return result;
    }

    /**
     * 随机指定范围内N个不重复的Integer数组。
     * <p>
     * 在初始化的无重复待选数组中随机产生一个数放入结果中，
     * </p>
     * <p>
     * 将待选数组被随机到的数，用待选数组(len-1)下标对应的数替换，
     * </p>
     * <p>
     * 然后从len-2里随机产生下一个随机数，如此类推
     * </p>
     *
     * @param min    指定范围最小值
     * @param max    指定范围最大值
     * @param length 随机数个数
     * @return int[] 随机数结果集
     */
    public static Integer[] randomNoRepeatIntegerArray(int min, int max, int length) {
        int len = max - min + 1;

        if (max < min || length > len) {
            return null;
        }

        // 初始化给定范围的待选数组
        Integer[] source = new Integer[len];
        for (int i = min; i < min + len; i++) {
            source[i - min] = i;
        }

        Integer[] result = new Integer[length];
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

    /**
     * 随机指定范围内N个重复的Integer数组。
     *
     * @param min    指定范围最小值
     * @param max    指定范围最大值
     * @param length 随机数个数
     * @return 随机数结果集
     */
    public static Integer[] randomRepeatIntegerArray(int min, int max, int length) {
        int len = max - min + 1;

        if (max < min || length > len) {
            return null;
        }

        Integer[] result = new Integer[length];
        for (int i = 0; i < result.length; i++) {
            result[i] = (int) (Math.random() * max);
        }
        return result;
    }

}
