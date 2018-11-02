package io.github.dunwu.ds.sort.strategy;

import io.github.dunwu.ds.util.ArrayUtil;
import io.github.dunwu.ds.sort.Sort;

/**
 * 冒泡排序的优化算法
 * @author Zhang Peng
 */
public class BubbleSort2 implements Sort {
    @Override
    public <T extends Comparable<T>> void sort(T[] list) {
        // 交换标志
        boolean bChange = false;

        // 要遍历的次数
        for (int i = 0; i < list.length - 1; i++) {
            bChange = false;
            // 从后向前依次的比较相邻两个数的大小，遍历一次后，把数组中第i小的数放在第i个位置上
            for (int j = list.length - 1; j > i; j--) {
                // 比较相邻的元素，如果前面的数大于后面的数，则交换
                if (list[j - 1].compareTo(list[j]) > 0) {
                    T temp = list[j - 1];
                    list[j - 1] = list[j];
                    list[j] = temp;
                    bChange = true;
                }
            }

            // 如果标志为false，说明本轮遍历没有交换，已经是有序数列，可以结束排序
            if (false == bChange) {
                break;
            }

            ArrayUtil.debugLogArray(list, 0, list.length - 1, String.format("第 %d 趟：", i + 1));
        }
    }
}
