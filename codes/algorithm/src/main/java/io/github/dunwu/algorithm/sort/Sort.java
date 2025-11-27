package io.github.dunwu.algorithm.sort;

/**
 * 排序通用泛型接口
 *
 * @author Zhang Peng
 */
public interface Sort {

    /**
     * 排序接口
     *
     * @param list 要排序的数组
     */
    <T extends Comparable<T>> void sort(T[] list);

}
