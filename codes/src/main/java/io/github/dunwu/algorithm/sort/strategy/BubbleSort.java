package io.github.dunwu.algorithm.sort.strategy;

import io.github.dunwu.algorithm.sort.ArrayUtil;
import io.github.dunwu.algorithm.sort.Sort;

public class BubbleSort implements Sort {
    @Override
    public void sort(int[] list) {
        // 用来交换的临时数
        int temp = 0;

        // 要遍历的次数
        for (int i = 0; i < list.length - 1; i++) {
            // 从后向前依次的比较相邻两个数的大小，遍历一次后，把数组中第i小的数放在第i个位置上
            for (int j = list.length - 1; j > i; j--) {
                // 比较相邻的元素，如果前面的数大于后面的数，则交换
                if (list[j - 1] > list[j]) {
                    temp = list[j - 1];
                    list[j - 1] = list[j];
                    list[j] = temp;
                }
            }

            System.out.format("第 %d 趟：\n", i);
            ArrayUtil.printArray(list, 0, list.length - 1);
        }
    }
}
