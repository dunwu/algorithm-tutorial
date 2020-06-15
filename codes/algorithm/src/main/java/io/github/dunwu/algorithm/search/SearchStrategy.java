package io.github.dunwu.algorithm.search;

import cn.hutool.core.util.ArrayUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 使用策略模式，对算法进行包装
 *
 * @author Zhang Peng
 */
public class SearchStrategy {

    private static final Logger logger = LoggerFactory.getLogger(SearchStrategy.class);

    private Search search;

    public SearchStrategy(Search search) {
        search = search;
    }

    public int find(Integer[] list, int key) {
        logger.info(search.getClass().getSimpleName() + " 查找开始：");
        logger.info("要查找的线性表：{}", ArrayUtil.toString(list));
        logger.info("要查找的 key：{}", key);

        int index = search.find(list, key);
        logger.info("{} 的位置是：{}", key, index);
        return index;
    }

}
