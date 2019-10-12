package io.github.dunwu.ds.search;

import io.github.dunwu.ds.search.strategy.BinarySearch;
import io.github.dunwu.ds.search.strategy.OrderSearch;
import io.github.dunwu.ds.util.ArrayUtil;
import org.junit.*;
import org.junit.runners.MethodSorters;

import java.util.Random;

/**
 * 排序算法单元测试 如果需要打印每趟排序的结果，可以修改 logback.xml 中
 * <logger name="io.github.dunwu" level="INFO" additivity="false"> 的 level 级别，改为 DEBUG，
 * 日志就会打印 debug 信息。
 *
 * @author Zhang Peng
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SearchStrategyTest {

	/**
	 * 随机样本一
	 */
	private static Integer[] origin01;

	private static int expected01;

	/**
	 * 随机样本二
	 */
	private static Integer[] origin02;

	private static int expected02;

	/**
	 * 随机样本三
	 */
	private static Integer[] origin03;

	private static int expected03;

	/**
	 * 生成随机数组样本，并调用 JDK api 生成期望的有序数组
	 */
	@BeforeClass
	public static void beforeClass() {
		Random random = new Random();

		// 在 [0, 100] 间生成长度为 10 的不重复的随机数组
		origin01 = ArrayUtil.randomNoRepeatIntegerArray(0, 10, 10);
		expected01 = random.nextInt(origin01.length);

		// 在 [0, 100] 间生成长度为 17 的不重复的随机数组
		origin02 = ArrayUtil.randomNoRepeatIntegerArray(0, 100, 20);
		expected02 = random.nextInt(origin02.length);

		// 在 [0, 100] 间生成长度为 100 的不重复的随机数组
		origin03 = ArrayUtil.randomNoRepeatIntegerArray(0, 100, 100);
		expected03 = random.nextInt(origin03.length);
	}

	/**
	 * 每次执行 @Test 前都使用生成的随机样本初始化实际用于排序的数组
	 */
	@Before
	public void before() {
	}

	@Test
	public void testOrderSearch() {
		SearchStrategy strategy = new SearchStrategy(new OrderSearch());
		executeSearch(strategy);
	}

	@Test
	public void testBinarySearch() {
		SearchStrategy strategy = new SearchStrategy(new BinarySearch());
		executeSearch(strategy);
	}

	/**
	 * 注入 BinarySearch，执行对三个样本的排序测试
	 */
	private void executeSearch(SearchStrategy strategy) {
		int target01 = strategy.find(origin01, origin01[expected01]);
		Assert.assertEquals(expected01, target01);

		int target02 = strategy.find(origin02, origin02[expected02]);
		Assert.assertEquals(expected02, target02);

		int target03 = strategy.find(origin03, origin03[expected03]);
		Assert.assertEquals(expected03, target03);
	}

}
