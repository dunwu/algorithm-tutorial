package io.github.dunwu.algorithm.sort.strategy;

import io.github.dunwu.algorithm.sort.Sort;

/**
 * 基数排序算法
 * @author Zhang Peng
 */
public class RadixSort implements Sort {

    /**
     * 获取x这个数的d位数上的数字，比如获取123的1位数，结果返回3
     * @param x
     * @param d
     * @return
     */
    private int getDigit(int x, int d) {
        // 本实例中的最大数是百位数，所以只要到100就可以了
        int[] a = { 1, 1, 10, 100 };
        return ((x / a[d]) % 10);
    }

    private void radixSort(int[] list, int begin, int end, int digit) {
        // 基数
        final int radix = 10;
        int i = 0, j = 0;
        // 存放各个桶的数据统计个数
        int[] count = new int[radix];
        int[] bucket = new int[end - begin + 1];

        // 按照从低位到高位的顺序执行排序过程
        for (int d = 1; d <= digit; d++) {

            // 置空各个桶的数据统计
            for (i = 0; i < radix; i++) {
                count[i] = 0;
            }

            // 统计各个桶将要装入的数据个数
            for (i = begin; i <= end; i++) {
                j = getDigit(list[i], d);
                count[j]++;
            }

            // count[i]表示第i个桶的右边界索引
            for (i = 1; i < radix; i++) {
                count[i] = count[i] + count[i - 1];
            }

            // 将数据依次装入桶中
            // 这里要从右向左扫描，保证排序稳定性
            for (i = end; i >= begin; i--) {
                // 求出关键码的第k位的数字， 例如：576的第3位是5
                j = getDigit(list[i], d);
                // 放入对应的桶中，count[j]-1是第j个桶的右边界索引
                bucket[count[j] - 1] = list[i];
                // 对应桶的装入数据索引减一
                count[j]--;
            }

            // 将已分配好的桶中数据再倒出来，此时已是对应当前位数有序的表
            for (i = begin, j = 0; i <= end; i++, j++) {
                list[i] = bucket[j];
            }
        }
    }

    @Override
    public void sort(int[] list) {
        radixSort(list, 0, list.length - 1, 3);
    }
}
