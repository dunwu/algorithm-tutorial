package io.github.dunwu.algorithm.search.strategy;

import io.github.dunwu.algorithm.search.Search;

/**
 * @author Zhang Peng
 * @date 2018/4/18
 */
public class OrderSearch implements Search {

    @Override
    public int search(int[] list, int key) {
        // 从前往后扫描list数组，如果有元素的值与key相等，直接返回其位置
        for (int i = 0; i < list.length; i++) {
            if (key == list[i]) {
                return i;
            }
        }

        // 如果扫描完，说明没有元素的值匹配key，返回-1，表示查找失败
        return -1;
    }
}
