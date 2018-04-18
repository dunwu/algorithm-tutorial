package io.github.dunwu.algorithm.sort;

import io.github.dunwu.algorithm.util.ArrayUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 使用策略模式，对算法进行包装
 * @author Zhang Peng
 */
public class SortStrategy {
    private Sort sort;
    private static final Logger logger = LoggerFactory.getLogger(SortStrategy.class);

    public SortStrategy(Sort sort) {
        this.sort = sort;
    }

    public void sort(int[] list) {
        logger.info(this.sort.getClass().getSimpleName() + " 排序开始：");
        logger.info("排序前: {}", ArrayUtil.getArrayString(list, 0, list.length - 1));
        this.sort.sort(list);
        logger.info("排序后: {}", ArrayUtil.getArrayString(list, 0, list.length - 1));
    }
}
