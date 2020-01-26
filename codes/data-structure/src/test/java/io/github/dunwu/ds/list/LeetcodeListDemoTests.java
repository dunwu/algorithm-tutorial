package io.github.dunwu.ds.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

@DisplayName("Leetcode 单链表测试例")
public class LeetcodeListDemoTests {

    @Test
    @DisplayName("141. 环形链表")
    public void hasCycleTest() {
        LeetcodeListDemo.ListNode head = LeetcodeListDemo.buildList(3, 2, 0, -4);
        Assertions.assertFalse(LeetcodeListDemo.hasCycle(head));

        head = LeetcodeListDemo.buildCycleList(1, new int[] { 3, 2, 0, -4 });
        Assertions.assertTrue(LeetcodeListDemo.hasCycle(head));

        head = LeetcodeListDemo.buildCycleList(0, new int[] { 1, 2 });
        Assertions.assertTrue(LeetcodeListDemo.hasCycle(head));
    }

    @Test
    @DisplayName("21. 合并两个有序链表")
    public void mergeTwoListsTest() {
        LeetcodeListDemo.ListNode head1 = LeetcodeListDemo.buildList(1, 2, 4);
        LeetcodeListDemo.ListNode head2 = LeetcodeListDemo.buildList(1, 3, 4);
        LeetcodeListDemo.ListNode result = LeetcodeListDemo.mergeTwoLists(head1, head2);
        List<Integer> list = LeetcodeListDemo.toList(result);
        System.out.println(list);
        Assertions.assertArrayEquals(new Integer[] { 1, 1, 2, 3, 4, 4 }, list.toArray(new Integer[0]));
    }

    @Test
    @DisplayName("23. 合并K个排序链表<")
    public void mergeKListsTest() {
        LeetcodeListDemo.ListNode head1 = LeetcodeListDemo.buildList(1, 4, 5);
        LeetcodeListDemo.ListNode head2 = LeetcodeListDemo.buildList(1, 3, 4);
        LeetcodeListDemo.ListNode head3 = LeetcodeListDemo.buildList(2, 6);
        LeetcodeListDemo.ListNode[] array = new LeetcodeListDemo.ListNode[] { head1, head2, head3 };
        LeetcodeListDemo.ListNode result = LeetcodeListDemo.mergeKLists2(array);
        List<Integer> list = LeetcodeListDemo.toList(result);
        System.out.println(list);
        Assertions.assertArrayEquals(new Integer[] { 1, 1, 2, 3, 4, 4, 5, 6 }, list.toArray(new Integer[0]));
    }

    @Test
    @DisplayName("206. 反转链表")
    public void reverseListTest() {
        LeetcodeListDemo.ListNode head = LeetcodeListDemo.buildList(1, 2, 4);
        System.out.println(LeetcodeListDemo.toList(head));
        LeetcodeListDemo.ListNode result = LeetcodeListDemo.reverseList(head);
        List<Integer> list = LeetcodeListDemo.toList(result);
        System.out.println(list);
        Assertions.assertArrayEquals(new Integer[] { 4, 2, 1 }, list.toArray(new Integer[0]));
    }

    @Test
    @DisplayName("2. 两数相加")
    public void addTwoNumbersTest() {
        LeetcodeListDemo.ListNode head1 = LeetcodeListDemo.buildList(2, 4, 3);
        LeetcodeListDemo.ListNode head2 = LeetcodeListDemo.buildList(5, 6, 4);
        LeetcodeListDemo.ListNode result = LeetcodeListDemo.addTwoNumbers(head1, head2);
        LeetcodeListDemo.toList(head1);
        LeetcodeListDemo.toList(head2);
        List<Integer> list = LeetcodeListDemo.toList(result);
        System.out.println(list);
        Assertions.assertArrayEquals(new Integer[] { 7, 0, 8 }, list.toArray());

        head1 = new LeetcodeListDemo.ListNode(1);
        head2 = LeetcodeListDemo.buildList(9, 9);
        result = LeetcodeListDemo.addTwoNumbers(head1, head2);
        LeetcodeListDemo.toList(head1);
        LeetcodeListDemo.toList(head2);
        list = LeetcodeListDemo.toList(result);
        System.out.println(list);
        Assertions.assertArrayEquals(new Integer[] { 0, 0, 1 }, list.toArray());
    }

    @Test
    @DisplayName("148. 排序链表")
    public void sortListTest() {
        LeetcodeListDemo.ListNode head = LeetcodeListDemo.buildList(4, 2, 1, 3);
        System.out.println(LeetcodeListDemo.toList(head));
        LeetcodeListDemo.ListNode result = LeetcodeListDemo.sortList(head);
        List<Integer> list = LeetcodeListDemo.toList(result);
        System.out.println(list);
        Assertions.assertArrayEquals(new Integer[] { 1, 2, 3, 4 }, list.toArray(new Integer[0]));

        head = LeetcodeListDemo.buildList(-1, 5, 3, 4, 0);
        System.out.println(LeetcodeListDemo.toList(head));
        result = LeetcodeListDemo.sortList(head);
        list = LeetcodeListDemo.toList(result);
        System.out.println(list);
        Assertions.assertArrayEquals(new Integer[] { -1, 0, 3, 4, 5 }, list.toArray(new Integer[0]));
    }

    @Test
    @DisplayName("83. 删除排序链表中的重复元素")
    public void deleteDuplicatesTest() {
        LeetcodeListDemo.ListNode head = LeetcodeListDemo.buildList(1, 1, 2);

        System.out.println(LeetcodeListDemo.toList(head));
        LeetcodeListDemo.ListNode result = LeetcodeListDemo.deleteDuplicates(head);
        List<Integer> list = LeetcodeListDemo.toList(result);
        System.out.println(list);
        Assertions.assertArrayEquals(new Integer[] { 1, 2 }, list.toArray(new Integer[0]));
    }

    @Test
    @DisplayName("203. 移除链表元素")
    public void removeElementsTest() {
        LeetcodeListDemo.ListNode head = LeetcodeListDemo.buildList(1, 2);
        System.out.println(LeetcodeListDemo.toList(head));
        LeetcodeListDemo.ListNode result = LeetcodeListDemo.removeElements(head, 1);
        List<Integer> list = LeetcodeListDemo.toList(result);
        System.out.println(list);
        Assertions.assertArrayEquals(new Integer[] { 2 }, list.toArray(new Integer[0]));

        head = new LeetcodeListDemo.ListNode(1);
        System.out.println(LeetcodeListDemo.toList(head));
        result = LeetcodeListDemo.removeElements(head, 1);
        list = LeetcodeListDemo.toList(result);
        System.out.println(list);
        Assertions.assertArrayEquals(new Integer[] {}, list.toArray(new Integer[0]));

        head = LeetcodeListDemo.buildList(1, 1);
        System.out.println(LeetcodeListDemo.toList(head));
        result = LeetcodeListDemo.removeElements(head, 1);
        list = LeetcodeListDemo.toList(result);
        System.out.println(list);
        Assertions.assertArrayEquals(new Integer[] {}, list.toArray(new Integer[0]));
    }

    @Test
    @DisplayName("876. 链表的中间结点")
    public void middleNodeTest() {
        LeetcodeListDemo.ListNode head = LeetcodeListDemo.buildList(1, 2, 3, 4, 5, 6);
        System.out.println(LeetcodeListDemo.toList(head));
        LeetcodeListDemo.ListNode result = LeetcodeListDemo.middleNode(head);
        List<Integer> list = LeetcodeListDemo.toList(result);
        System.out.println(list);
        Assertions.assertArrayEquals(new Integer[] { 4, 5, 6 }, list.toArray(new Integer[0]));

        head = LeetcodeListDemo.buildList(1, 2, 3, 4, 5);

        System.out.println(LeetcodeListDemo.toList(head));
        result = LeetcodeListDemo.middleNode(head);
        list = LeetcodeListDemo.toList(result);
        System.out.println(list);
        Assertions.assertArrayEquals(new Integer[] { 3, 4, 5 }, list.toArray(new Integer[0]));
    }

    @Test
    @DisplayName("1290. 二进制链表转整数")
    public void getDecimalValueTest() {
        LeetcodeListDemo.ListNode head = LeetcodeListDemo.buildList(1, 0, 1);
        System.out.println(LeetcodeListDemo.toList(head));
        int result = LeetcodeListDemo.getDecimalValue(head);
        Assertions.assertEquals(5, result);

        head = new LeetcodeListDemo.ListNode(0);
        System.out.println(LeetcodeListDemo.toList(head));
        result = LeetcodeListDemo.getDecimalValue(head);
        Assertions.assertEquals(0, result);

        head = new LeetcodeListDemo.ListNode(1);
        System.out.println(LeetcodeListDemo.toList(head));
        result = LeetcodeListDemo.getDecimalValue(head);
        Assertions.assertEquals(1, result);

        head = LeetcodeListDemo.buildList(1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0);
        System.out.println(LeetcodeListDemo.toList(head));
        result = LeetcodeListDemo.getDecimalValue(head);
        Assertions.assertEquals(18880, result);
    }

}
