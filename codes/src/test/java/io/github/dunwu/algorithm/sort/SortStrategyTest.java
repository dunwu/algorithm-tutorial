package io.github.dunwu.algorithm.sort;

import io.github.dunwu.algorithm.sort.strategy.BubbleSort;
import io.github.dunwu.algorithm.sort.strategy.BubbleSort2;
import io.github.dunwu.algorithm.sort.strategy.HeapSort;
import io.github.dunwu.algorithm.sort.strategy.InsertSort;
import io.github.dunwu.algorithm.sort.strategy.MergeSort;
import io.github.dunwu.algorithm.sort.strategy.QuickSort;
import io.github.dunwu.algorithm.sort.strategy.RadixSort;
import io.github.dunwu.algorithm.sort.strategy.SelectionSort;
import io.github.dunwu.algorithm.sort.strategy.ShellSort;
import io.github.dunwu.algorithm.util.ArrayUtil;
import java.util.Arrays;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 * 排序算法单元测试
 * 如果需要打印每趟排序的结果，可以修改 logback.xml 中
 * <logger name="io.github.dunwu" level="INFO" additivity="false"> 的 level 级别，改为 DEBUG，
 * 日志就会打印 debug 信息。
 *
 * @author Zhang Peng
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SortStrategyTest {

    /**
     * 随机样本一
     */
    private static int[] origin01;
    private static int[] target01;
    private static int[] expected01;

    /**
     * 随机样本二
     */
    private static int[] origin02;
    private static int[] target02;
    private static int[] expected02;

    /**
     * 随机样本三
     */
    private static int[] origin03;
    private static int[] target03;
    private static int[] expected03;

    /**
     * 生成随机数组样本，并调用 JDK api 生成期望的有序数组
     */
    @BeforeClass
    public static void beforeClass() {
        // 在 [0, 100] 间生成长度为 10 的存在重复的随机数组
        origin01 = ArrayUtil.randomRepeatArray(0, 10, 9);
        expected01 = Arrays.copyOf(origin01, origin01.length);
        Arrays.sort(expected01);

        // 在 [0, 100] 间生成长度为 17 的不重复的随机数组
        origin02 = ArrayUtil.randomNoRepeatArray(0, 100, 17);
        expected02 = Arrays.copyOf(origin02, origin02.length);
        Arrays.sort(expected02);

        // 在 [0, 100] 间生成长度为 100 的不重复的随机数组
        origin03 = ArrayUtil.randomNoRepeatArray(0, 100, 100);
        expected03 = Arrays.copyOf(origin03, origin03.length);
        Arrays.sort(expected03);
    }

    /**
     * 每次执行 @Test 前都使用生成的随机样本初始化实际用于排序的数组
     */
    @Before
    public void before() {
        target01 = Arrays.copyOf(origin01, origin01.length);
        target02 = Arrays.copyOf(origin02, origin02.length);
        target03 = Arrays.copyOf(origin03, origin03.length);
    }

    @Test
    public void testBubbleSort() {
        SortStrategy strategy = new SortStrategy(new BubbleSort());
        executeSort(strategy);
    }

    @Test
    public void testBubbleSort2() {
        SortStrategy strategy = new SortStrategy(new BubbleSort2());
        executeSort(strategy);
    }

    @Test
    public void testQuickSort() {
        SortStrategy strategy = new SortStrategy(new QuickSort());
        executeSort(strategy);
    }

    @Test
    public void testInsertSort() {
        SortStrategy strategy = new SortStrategy(new InsertSort());
        executeSort(strategy);
    }

    @Test
    public void testShellSort() {
        SortStrategy strategy = new SortStrategy(new ShellSort());
        executeSort(strategy);
    }

    @Test
    public void testSelectionSort() {
        SortStrategy strategy = new SortStrategy(new SelectionSort());
        executeSort(strategy);
    }

    @Test
    public void testHeapSort() {
        SortStrategy strategy = new SortStrategy(new HeapSort());
        executeSort(strategy);
    }

    @Test
    public void testMergeSort() {
        SortStrategy strategy = new SortStrategy(new MergeSort());
        executeSort(strategy);
    }

    @Test
    public void testRadixSort() {
        SortStrategy strategy = new SortStrategy(new RadixSort());
        executeSort(strategy);
    }

    /**
     * 注入 SortStrategy，执行对三个样本的排序测试
     */
    private void executeSort(SortStrategy strategy) {
        strategy.sort(target01);
        Assert.assertArrayEquals(expected01, target01);
        strategy.sort(target02);
        Assert.assertArrayEquals(expected02, target02);
        strategy.sort(target03);
        Assert.assertArrayEquals(expected03, target03);
    }
}
