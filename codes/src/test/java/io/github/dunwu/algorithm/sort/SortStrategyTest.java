package io.github.dunwu.algorithm.sort;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import io.github.dunwu.algorithm.sort.strategy.BubbleSort;
import io.github.dunwu.algorithm.sort.strategy.BubbleSort2;
import io.github.dunwu.algorithm.sort.strategy.HeapSort;
import io.github.dunwu.algorithm.sort.strategy.InsertSort;
import io.github.dunwu.algorithm.sort.strategy.MergeSort;
import io.github.dunwu.algorithm.sort.strategy.QuickSort;
import io.github.dunwu.algorithm.sort.strategy.RadixSort;
import io.github.dunwu.algorithm.sort.strategy.SelectionSort;
import io.github.dunwu.algorithm.sort.strategy.ShellSort;

/**
 * @author Zhang Peng
 */
public class SortStrategyTest {
    private static int[] origin01;
    private static int[] target01;
    private static int[] expected01;

    private static int[] origin02;
    private static int[] target02;
    private static int[] expected02;

    @BeforeClass
    public static void beforeClass() {
        origin01 = ArrayUtil.randomArray(0, 100, 100);
        expected01 = Arrays.copyOf(origin01, origin01.length);
        Arrays.sort(expected01);

        origin02 = ArrayUtil.randomArray(0, 100, 17);
        expected02 = Arrays.copyOf(origin02, origin02.length);
        Arrays.sort(expected02);
    }

    @Before
    public void before() {
        target01 = Arrays.copyOf(origin01, origin01.length);
        target02 = Arrays.copyOf(origin02, origin02.length);
    }

    @Test
    public void testBubbleSort() {
        SortStrategy strategy = new SortStrategy(new BubbleSort());
        strategy.sort(target01);
        Assert.assertArrayEquals(expected01, target01);
        strategy.sort(target02);
        Assert.assertArrayEquals(expected02, target02);
    }

    @Test
    public void testBubbleSort2() {
        SortStrategy strategy = new SortStrategy(new BubbleSort2());
        strategy.sort(target01);
        Assert.assertArrayEquals(expected01, target01);
        strategy.sort(target02);
        Assert.assertArrayEquals(expected02, target02);
    }

    @Test
    public void testQuickSort() {
        SortStrategy strategy = new SortStrategy(new QuickSort());
        strategy.sort(target01);
        Assert.assertArrayEquals(expected01, target01);
        strategy.sort(target02);
        Assert.assertArrayEquals(expected02, target02);
    }

    @Test
    public void testInsertSort() {
        SortStrategy strategy = new SortStrategy(new InsertSort());
        strategy.sort(target01);
        Assert.assertArrayEquals(expected01, target01);
        strategy.sort(target02);
        Assert.assertArrayEquals(expected02, target02);
    }

    @Test
    public void testShellSort() {
        SortStrategy strategy = new SortStrategy(new ShellSort());
        strategy.sort(target01);
        Assert.assertArrayEquals(expected01, target01);
        strategy.sort(target02);
        Assert.assertArrayEquals(expected02, target02);
    }

    @Test
    public void testSelectionSort() {
        SortStrategy strategy = new SortStrategy(new SelectionSort());
        strategy.sort(target01);
        Assert.assertArrayEquals(expected01, target01);
        strategy.sort(target02);
        Assert.assertArrayEquals(expected02, target02);
    }

    @Test
    public void testHeapSort() {
        SortStrategy strategy = new SortStrategy(new HeapSort());
        strategy.sort(target01);
        Assert.assertArrayEquals(expected01, target01);
        strategy.sort(target02);
        Assert.assertArrayEquals(expected02, target02);
    }

    @Test
    public void testMergeSort() {
        SortStrategy strategy = new SortStrategy(new MergeSort());
        strategy.sort(target01);
        Assert.assertArrayEquals(expected01, target01);
        strategy.sort(target02);
        Assert.assertArrayEquals(expected02, target02);
    }

    @Test
    public void testRadixSort() {
        SortStrategy strategy = new SortStrategy(new RadixSort());
        strategy.sort(target01);
        Assert.assertArrayEquals(expected01, target01);
        strategy.sort(target02);
        Assert.assertArrayEquals(expected02, target02);
    }
}
