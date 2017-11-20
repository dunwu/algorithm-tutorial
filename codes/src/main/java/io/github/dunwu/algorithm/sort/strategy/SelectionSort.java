package io.github.dunwu.algorithm.sort.strategy;

import io.github.dunwu.algorithm.sort.ArrayUtil;
import io.github.dunwu.algorithm.sort.Sort;

public class SelectionSort implements Sort {
    @Override
    public void sort(int[] list) {
        // 需要遍历获得最小值的次数
        // 要注意一点，当要排序 N 个数，已经经过 N-1 次遍历后，已经是有序数列
        for (int i = 0; i < list.length - 1; i++) {
            int temp = 0;
            // 用来保存最小值得索引
            int index = i;

            // 寻找第i个小的数值
            for (int j = i + 1; j < list.length; j++) {
                if (list[index] > list[j]) {
                    index = j;
                }
            }

            // 将找到的第i个小的数值放在第i个位置上
            temp = list[index];
            list[index] = list[i];
            list[i] = temp;

            System.out.format("第 %d 趟:\n", i + 1);
            ArrayUtil.printArray(list, 0, list.length - 1);
        }
    }
}
