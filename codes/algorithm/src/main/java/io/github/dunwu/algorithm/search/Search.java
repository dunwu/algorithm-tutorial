package io.github.dunwu.algorithm.search;

/**
 * @author Zhang Peng
 */
public interface Search {

    /**
     * @param array 要查找的数组
     * @param key   要查找的 key
     * @return 返回第一个匹配 key 值的数组元素所在位置
     */
    <T extends Comparable<T>> int find(T[] array, T key);

}
