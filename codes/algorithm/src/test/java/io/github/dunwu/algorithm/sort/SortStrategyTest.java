package io.github.dunwu.algorithm.sort;

import io.github.dunwu.algorithm.sort.strategy.BubbleSort;
import io.github.dunwu.algorithm.sort.strategy.BubbleSort2;
import io.github.dunwu.algorithm.sort.strategy.HeapSort;
import io.github.dunwu.algorithm.sort.strategy.InsertSort;
import io.github.dunwu.algorithm.sort.strategy.MergeSort;
import io.github.dunwu.algorithm.sort.strategy.QuickSort;
import io.github.dunwu.algorithm.sort.strategy.SelectionSort;
import io.github.dunwu.algorithm.sort.strategy.ShellSort;
import io.github.dunwu.algorithm.util.ArrayUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 排序算法单元测试 如果需要打印每趟排序的结果，可以修改 logback.xml 中
 * <logger name="io.github.dunwu" level="INFO" additivity="false"> 的 level 级别，改为 DEBUG，
 * 日志就会打印 debug 信息。
 *
 * @author Zhang Peng
 */
public class SortStrategyTest {

    /**
     * 随机样本一
     */
    private static Integer[] s1;
    private static Integer[] t1;
    private static Integer[] e1;

    /**
     * 随机样本二
     */
    private static Integer[] s2;
    private static Integer[] t2;
    private static Integer[] e2;

    /**
     * 随机样本三
     */
    private static Integer[] s3;
    private static Integer[] t3;
    private static Integer[] e3;

    /**
     * 生成随机数组样本，并调用 JDK api 生成期望的有序数组
     */
    @BeforeAll
    public static void beforeClass() {
        // 在 [0, 100] 间生成长度为 10 的存在重复的随机数组
        s1 = ArrayUtil.randomRepeatIntegerArray(0, 10, 5);
        e1 = Arrays.copyOf(s1, s1.length);
        Arrays.sort(e1);

        // 在 [0, 100] 间生成长度为 17 的不重复的随机数组
        s2 = ArrayUtil.randomNoRepeatIntegerArray(0, 100, 10);
        e2 = Arrays.copyOf(s2, s2.length);
        Arrays.sort(e2);

        // 在 [0, 100] 间生成长度为 100 的不重复的随机数组
        s3 = ArrayUtil.randomNoRepeatIntegerArray(0, 100, 30);
        e3 = Arrays.copyOf(s3, s3.length);
        Arrays.sort(e3);
    }

    /**
     * 注入 SortStrategy，执行对三个样本的排序测试
     */
    private void executeSort(SortStrategy strategy) {
        strategy.sort(t1);
        Assertions.assertArrayEquals(e1, t1);
        strategy.sort(t2);
        Assertions.assertArrayEquals(e2, t2);
        strategy.sort(t3);
        Assertions.assertArrayEquals(e3, t3);
    }

    /**
     * 每次执行 @Test 前都使用生成的随机样本初始化实际用于排序的数组
     */
    @BeforeEach
    public void before() {
        t1 = Arrays.copyOf(s1, s1.length);
        t2 = Arrays.copyOf(s2, s2.length);
        t3 = Arrays.copyOf(s3, s3.length);
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

}
