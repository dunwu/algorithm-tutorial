package io.github.dunwu.ds.search;

import io.github.dunwu.ds.util.ArrayUtil;
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
		this.search = search;
	}

	public int find(Integer[] list, int key) {
		logger.info(this.search.getClass().getSimpleName() + " 查找开始：");
		logger.info("要查找的线性表：{}", ArrayUtil.getArrayString(list, 0, list.length - 1));
		logger.info("要查找的 key：{}", key);

		int index = this.search.find(list, key);
		logger.info("{} 的位置是：{}", key, index);
		return index;
	}

}
