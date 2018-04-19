package io.github.dunwu.algorithm.search.strategy;

import io.github.dunwu.algorithm.search.Search;

/**
 * 二分查找又称折半查找，它是一种效率较高的查找方法。
 * 二分查找需要两个前提：(1) 必须是顺序存储结构。(2) 必须是有序的表。
 * 算法：
 * 从数据结构线形表的一端开始，顺序扫描，依次将扫描到的结点关键字与给定值k相比较，若相等则表示查找成功；
 * 若扫描结束仍没有找到等于关键字的结点，表示查找失败。
 * 算法分析：
 * 最坏情况	O(log n)
 * 最好情况	O(1)
 * 平均情况	O(log n)
 * 最坏情况下的空间复杂性 O(1)
 *
 * @author Zhang Peng
 */
public class BinarySearch implements Search {

    /**
     * 查找方法
     *
     * @param array 被查找的线性表
     * @param key 被查找的 key
     * @return 成功返回 key 的位置；失败返回 -1
     */
    @Override
    public <T extends Comparable<T>> int find(T array[], T key) {
        return search(array, key, 0, array.length);
    }

    private <T extends Comparable<T>> int search(T array[], T key, int left, int right) {
        // this means that the key not found
        if (right < left) {
            return -1;
        }

        int mid = (left + right) >>> 1;
        int comp = key.compareTo(array[mid]);

        if (comp < 0) {
            return search(array, key, left, mid - 1);
        }

        if (comp > 0) {
            return search(array, key, mid + 1, right);
        }

        return mid;
    }
}
