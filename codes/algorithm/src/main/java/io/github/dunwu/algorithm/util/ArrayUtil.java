package io.github.dunwu.algorithm.util;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 数组工具类
 *
 * @author Zhang Peng
 */
@Slf4j
public class ArrayUtil {

    public static int[] toIntArray(List<Integer> list) {
        if (list == null || list.isEmpty()) { return new int[0]; }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static List<List<Integer>> toIntMatrixList(int[][] arr) {
        if (arr == null || arr.length == 0) { return new ArrayList<>(); }
        List<List<Integer>> listlist = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            List<Integer> list = new ArrayList<>();
            listlist.add(list);
            for (int j = 0; j < arr[i].length; j++) {
                list.add(arr[i][j]);
            }
        }
        return listlist;
    }

    public static int[][] toIntMatrixArray(List<List<Integer>> listlist) {
        if (listlist == null || listlist.size() == 0) { return new int[0][0]; }
        List<int[]> arrList = new ArrayList<>();
        for (List<Integer> list : listlist) {
            arrList.add(toIntArray(list));
        }
        return arrList.toArray(new int[listlist.size()][]);
    }

    public static String[] toStringArray(List<String> list) {
        if (list == null || list.isEmpty()) { return new String[0]; }
        String[] res = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static String[][] toStringMatrixArray(List<List<String>> listlist) {
        if (listlist == null || listlist.size() == 0) { return new String[0][0]; }
        List<String[]> arrList = new ArrayList<>();
        for (List<String> list : listlist) {
            arrList.add(toStringArray(list));
        }
        return arrList.toArray(new String[listlist.size()][]);
    }

    public static <T> void printArray(T[] arr, int begin, int end, String tip) {
        System.out.printf("%s -> %s\n", tip, getArrayString(arr, begin, end));
    }

    public static <T> String getArrayString(T[] arr) {
        return getArrayString(arr, 0, arr.length);
    }

    public static <T> String getArrayString(T[] arr, int begin, int end) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = begin; i <= end; i++) {
            if (count != 0 && count % 10 == 0) {
                sb.append("\n");
            }
            sb.append("\t" + arr[i]);
            count++;
        }

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
