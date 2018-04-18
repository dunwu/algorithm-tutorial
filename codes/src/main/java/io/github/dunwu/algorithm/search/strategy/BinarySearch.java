package io.github.dunwu.algorithm.search.strategy;

import io.github.dunwu.algorithm.search.Search;

/**
 * @author Zhang Peng
 * @date 2018/4/18
 */
public class BinarySearch implements Search {

    @Override
    public int search(int[] list, int key) {
        int low = 0, mid = 0, high = list.length - 1;
        while (low <= high) {
            mid = (low + high) / 2;
            if (list[mid] == key) {
                return mid; // 查找成功，直接返回位置
            } else if (list[mid] < key) {
                low = mid + 1; // 关键字大于中间位置的值，则在大值区间[mid+1, high]继续查找
            } else {
                high = mid - 1; // 关键字小于中间位置的值，则在小值区间[low, mid-1]继续查找
            }
        }
        return -1;
    }
}
