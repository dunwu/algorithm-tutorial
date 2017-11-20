package io.github.dunwu.algorithm.sort;

/**
 * 使用策略模式，对算法进行包装
 * @author Zhang Peng
 */
public class SortStrategy {
    private Sort sort;

    public SortStrategy(Sort sort) {
        this.sort = sort;
    }

    public void sort(int[] list) {
        System.out.print("排序前:\n");
        ArrayUtil.printArray(list, 0, list.length - 1);
        this.sort.sort(list);
        System.out.print("排序后:\n");
        ArrayUtil.printArray(list, 0, list.length - 1);
    }
}
