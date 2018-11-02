package io.github.dunwu.ds.search.strategy;

import io.github.dunwu.ds.search.Search;

/**
 * 顺序查找是一种最简单的查找算法。它的查找效率不高。
 * 算法：
 * 从数据结构线形表的一端开始，顺序扫描，依次将扫描到的结点关键字与给定值k相比较，若相等则表示查找成功；
 * 若扫描结束仍没有找到关键字等于k的结点，表示查找失败。
 * 算法分析：
 * 最坏情况	O(n)
 * 最好情况	O(1)
 * 平均情况	O(n)
 * 最坏情况下的空间复杂性
 *
 * @author Zhang Peng
 */
public class OrderSearch implements Search {

    /**
     * 查找方法
     *
     * @param array 被查找的线性表
     * @param key 被查找的 key
     * @return 成功返回 key 的位置；失败返回 -1
     */
    @Override
    public <T extends Comparable<T>> int find(T[] array, T key) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].compareTo(key) == 0) {
                return i;
            }
        }
        return -1;
    }
}
