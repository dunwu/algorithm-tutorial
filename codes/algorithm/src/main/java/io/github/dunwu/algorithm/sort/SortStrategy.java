package io.github.dunwu.algorithm.sort;

import io.github.dunwu.algorithm.util.ArrayUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * 使用策略模式，对算法进行包装
 *
 * @author Zhang Peng
 */
@Slf4j
public class SortStrategy {

    private final Sort sort;

    public SortStrategy(Sort sort) {
        this.sort = sort;
    }

    public void sort(Integer[] list) {
        System.out.printf("=================== %s 排序开始 ===================\n", this.sort.getClass().getSimpleName());
        System.out.printf("【排序前】\n%s\n", ArrayUtil.getArrayString(list, 0, list.length - 1));
        this.sort.sort(list);
        System.out.printf("【排序后】\n%s\n", ArrayUtil.getArrayString(list, 0, list.length - 1));
    }

}
