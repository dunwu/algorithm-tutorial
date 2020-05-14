package io.github.dunwu.leetcode.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-05-13
 */
public class ListAlgorithmTest {

    @Test
    @DisplayName("234. 回文链表")
    public void isPalindromeTest() {
        ListAlgorithm.ListNode head = ListAlgorithm.buildList(1, 2, 2, 1);
        Assertions.assertTrue(ListAlgorithm.isPalindrome(head));

        head = ListAlgorithm.buildList(1, 2);
        Assertions.assertFalse(ListAlgorithm.isPalindrome(head));
    }

    @Test
    @DisplayName("141. 环形链表")
    public void hasCycleTest() {
        ListAlgorithm.ListNode head = ListAlgorithm.buildList(3, 2, 0, -4);
        Assertions.assertFalse(ListAlgorithm.hasCycle(head));

        head = ListAlgorithm.buildCycleList(1, new int[] { 3, 2, 0, -4 });
        Assertions.assertTrue(ListAlgorithm.hasCycle(head));

        head = ListAlgorithm.buildCycleList(0, new int[] { 1, 2 });
        Assertions.assertTrue(ListAlgorithm.hasCycle(head));
    }

    @Test
    @DisplayName("21. 合并两个有序链表")
    public void mergeTwoListsTest() {
        ListAlgorithm.ListNode head1 = ListAlgorithm.buildList(1, 2, 4);
        ListAlgorithm.ListNode head2 = ListAlgorithm.buildList(1, 3, 4);
        ListAlgorithm.ListNode result = ListAlgorithm.mergeTwoLists(head1, head2);
        List<Integer> list = ListAlgorithm.toList(result);
        System.out.println(list);
        Assertions.assertArrayEquals(new Integer[] { 1, 1, 2, 3, 4, 4 }, list.toArray(new Integer[0]));
    }

    @Test
    @DisplayName("23. 合并K个排序链表<")
    public void mergeKListsTest() {
        ListAlgorithm.ListNode head1 = ListAlgorithm.buildList(1, 4, 5);
        ListAlgorithm.ListNode head2 = ListAlgorithm.buildList(1, 3, 4);
        ListAlgorithm.ListNode head3 = ListAlgorithm.buildList(2, 6);
        ListAlgorithm.ListNode[] array = new ListAlgorithm.ListNode[] { head1, head2, head3 };
        ListAlgorithm.ListNode result = ListAlgorithm.mergeKLists2(array);
        List<Integer> list = ListAlgorithm.toList(result);
        System.out.println(list);
        Assertions.assertArrayEquals(new Integer[] { 1, 1, 2, 3, 4, 4, 5, 6 }, list.toArray(new Integer[0]));
    }

    @Test
    @DisplayName("206. 反转链表")
    public void reverseListTest() {
        ListAlgorithm.ListNode head = ListAlgorithm.buildList(1, 2, 4);
        System.out.println(ListAlgorithm.toList(head));
        ListAlgorithm.ListNode result = ListAlgorithm.reverseList(head);
        List<Integer> list = ListAlgorithm.toList(result);
        System.out.println(list);
        Assertions.assertArrayEquals(new Integer[] { 4, 2, 1 }, list.toArray(new Integer[0]));
    }

    @Test
    @DisplayName("2. 两数相加")
    public void addTwoNumbersTest() {
        ListAlgorithm.ListNode head1 = ListAlgorithm.buildList(2, 4, 3);
        ListAlgorithm.ListNode head2 = ListAlgorithm.buildList(5, 6, 4);
        ListAlgorithm.ListNode result = ListAlgorithm.addTwoNumbers(head1, head2);
        ListAlgorithm.toList(head1);
        ListAlgorithm.toList(head2);
        List<Integer> list = ListAlgorithm.toList(result);
        System.out.println(list);
        Assertions.assertArrayEquals(new Integer[] { 7, 0, 8 }, list.toArray());

        head1 = new ListAlgorithm.ListNode(1);
        head2 = ListAlgorithm.buildList(9, 9);
        result = ListAlgorithm.addTwoNumbers(head1, head2);
        ListAlgorithm.toList(head1);
        ListAlgorithm.toList(head2);
        list = ListAlgorithm.toList(result);
        System.out.println(list);
        Assertions.assertArrayEquals(new Integer[] { 0, 0, 1 }, list.toArray());
    }

    @Test
    @DisplayName("148. 排序链表")
    public void sortListTest() {
        ListAlgorithm.ListNode head = ListAlgorithm.buildList(4, 2, 1, 3);
        System.out.println(ListAlgorithm.toList(head));
        ListAlgorithm.ListNode result = ListAlgorithm.sortList(head);
        List<Integer> list = ListAlgorithm.toList(result);
        System.out.println(list);
        Assertions.assertArrayEquals(new Integer[] { 1, 2, 3, 4 }, list.toArray(new Integer[0]));

        head = ListAlgorithm.buildList(-1, 5, 3, 4, 0);
        System.out.println(ListAlgorithm.toList(head));
        result = ListAlgorithm.sortList(head);
        list = ListAlgorithm.toList(result);
        System.out.println(list);
        Assertions.assertArrayEquals(new Integer[] { -1, 0, 3, 4, 5 }, list.toArray(new Integer[0]));
    }

    @Test
    @DisplayName("83. 删除排序链表中的重复元素")
    public void deleteDuplicatesTest() {
        ListAlgorithm.ListNode head = ListAlgorithm.buildList(1, 1, 2);

        System.out.println(ListAlgorithm.toList(head));
        ListAlgorithm.ListNode result = ListAlgorithm.deleteDuplicates(head);
        List<Integer> list = ListAlgorithm.toList(result);
        System.out.println(list);
        Assertions.assertArrayEquals(new Integer[] { 1, 2 }, list.toArray(new Integer[0]));
    }

    @Test
    @DisplayName("203. 移除链表元素")
    public void removeElementsTest() {
        ListAlgorithm.ListNode head = ListAlgorithm.buildList(1, 2);
        System.out.println(ListAlgorithm.toList(head));
        ListAlgorithm.ListNode result = ListAlgorithm.removeElementByValue(head, 1);
        List<Integer> list = ListAlgorithm.toList(result);
        System.out.println(list);
        Assertions.assertArrayEquals(new Integer[] { 2 }, list.toArray(new Integer[0]));

        head = new ListAlgorithm.ListNode(1);
        System.out.println(ListAlgorithm.toList(head));
        result = ListAlgorithm.removeElementByValue(head, 1);
        list = ListAlgorithm.toList(result);
        System.out.println(list);
        Assertions.assertArrayEquals(new Integer[] {}, list.toArray(new Integer[0]));

        head = ListAlgorithm.buildList(1, 1);
        System.out.println(ListAlgorithm.toList(head));
        result = ListAlgorithm.removeElementByValue(head, 1);
        list = ListAlgorithm.toList(result);
        System.out.println(list);
        Assertions.assertArrayEquals(new Integer[] {}, list.toArray(new Integer[0]));
    }

    @Test
    @DisplayName("876. 链表的中间结点")
    public void middleNodeTest() {
        ListAlgorithm.ListNode head = ListAlgorithm.buildList(1, 2, 3, 4, 5, 6);
        System.out.println(ListAlgorithm.toList(head));
        ListAlgorithm.ListNode result = ListAlgorithm.middleNode(head);
        List<Integer> list = ListAlgorithm.toList(result);
        System.out.println(list);
        Assertions.assertArrayEquals(new Integer[] { 4, 5, 6 }, list.toArray(new Integer[0]));

        head = ListAlgorithm.buildList(1, 2, 3, 4, 5);

        System.out.println(ListAlgorithm.toList(head));
        result = ListAlgorithm.middleNode(head);
        list = ListAlgorithm.toList(result);
        System.out.println(list);
        Assertions.assertArrayEquals(new Integer[] { 3, 4, 5 }, list.toArray(new Integer[0]));
    }

    @Test
    @DisplayName("1290. 二进制链表转整数")
    public void getDecimalValueTest() {
        ListAlgorithm.ListNode head = ListAlgorithm.buildList(1, 0, 1);
        System.out.println(ListAlgorithm.toList(head));
        int result = ListAlgorithm.getDecimalValue(head);
        Assertions.assertEquals(5, result);

        head = new ListAlgorithm.ListNode(0);
        System.out.println(ListAlgorithm.toList(head));
        result = ListAlgorithm.getDecimalValue(head);
        Assertions.assertEquals(0, result);

        head = new ListAlgorithm.ListNode(1);
        System.out.println(ListAlgorithm.toList(head));
        result = ListAlgorithm.getDecimalValue(head);
        Assertions.assertEquals(1, result);

        head = ListAlgorithm.buildList(1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0);
        System.out.println(ListAlgorithm.toList(head));
        result = ListAlgorithm.getDecimalValue(head);
        Assertions.assertEquals(18880, result);
    }

    @Test
    @DisplayName("面试题 02.01. 移除重复节点")
    public void removeDuplicateNodesTest() {
        ListAlgorithm.ListNode head = ListAlgorithm.buildList(1, 2, 3, 3, 2, 1);
        ListAlgorithm.ListNode listNode = ListAlgorithm.removeDuplicateNodes(head);
        List<Integer> result = ListAlgorithm.getValues(listNode);
        System.out.println(result);
        Assertions.assertArrayEquals(new Integer[] { 1, 2, 3 }, result.toArray());
    }

    @Test
    @DisplayName("面试题 02.02. 返回倒数第 k 个节点")
    public void kthToLastTest() {
        ListAlgorithm.ListNode head = ListAlgorithm.buildList(1, 2, 3, 4, 5);
        int val = ListAlgorithm.kthToLast(head, 2);
        Assertions.assertEquals(4, val);
    }

    @Test
    @DisplayName("面试题 02.03. 删除中间节点")
    public void deleteNodeTest() {
        ListAlgorithm.ListNode head = ListAlgorithm.buildList(4, 5, 1, 9);
        ListAlgorithm.deleteNode(head);
        List<Integer> result = ListAlgorithm.getValues(head);
        System.out.println(result);
        Assertions.assertArrayEquals(new Integer[] { 4, 1, 9 }, result.toArray());
    }

}
