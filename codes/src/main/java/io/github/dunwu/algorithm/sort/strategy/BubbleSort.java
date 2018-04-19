package io.github.dunwu.algorithm.sort.strategy;

import io.github.dunwu.algorithm.util.ArrayUtil;
import io.github.dunwu.algorithm.sort.Sort;

/**
 * 冒泡排序算法
 * @author Zhang Peng
 */
public class BubbleSort implements Sort {
    @Override
    public <T extends Comparable<T>> void sort(T[] list) {
        // 要遍历的次数
        for (int i = 0; i < list.length - 1; i++) {
            // 从后向前依次的比较相邻两个数的大小，遍历一次后，把数组中第i小的数放在第i个位置上
            for (int j = list.length - 1; j > i; j--) {
                // 比较相邻的元素，如果前面的数大于后面的数，则交换
                if (list[j - 1].compareTo(list[j]) > 0) {
                    T temp = list[j - 1];
                    list[j - 1] = list[j];
                    list[j] = temp;
                }
            }

            ArrayUtil.debugLogArray(list, 0, list.length - 1, String.format("第 %d 趟：", i + 1));
        }
    }
}
