package io.github.dunwu.ds.list;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-01-18
 */
public class LeetcodeListDemoTests {

    @Test
    public void mergeTwoListsTest() {
        LeetcodeListDemo.ListNode l1 = new LeetcodeListDemo.ListNode(1);
        l1.next = new LeetcodeListDemo.ListNode(2);
        l1.next.next = new LeetcodeListDemo.ListNode(4);

        LeetcodeListDemo.ListNode l2 = new LeetcodeListDemo.ListNode(1);
        l2.next = new LeetcodeListDemo.ListNode(3);
        l2.next.next = new LeetcodeListDemo.ListNode(4);

        LeetcodeListDemo.ListNode result = LeetcodeListDemo.mergeTwoLists(l1, l2);

        // print
        LeetcodeListDemo.printList(result);
    }

    @Test
    public void mergeKListsTest() {
        LeetcodeListDemo.ListNode l1 = new LeetcodeListDemo.ListNode(1);
        l1.next = new LeetcodeListDemo.ListNode(4);
        l1.next.next = new LeetcodeListDemo.ListNode(5);

        LeetcodeListDemo.ListNode l2 = new LeetcodeListDemo.ListNode(1);
        l2.next = new LeetcodeListDemo.ListNode(3);
        l2.next.next = new LeetcodeListDemo.ListNode(4);

        LeetcodeListDemo.ListNode l3 = new LeetcodeListDemo.ListNode(2);
        l3.next = new LeetcodeListDemo.ListNode(6);

        LeetcodeListDemo.ListNode[] array = new LeetcodeListDemo.ListNode[] { l1, l2, l3 };
        LeetcodeListDemo.ListNode result = LeetcodeListDemo.mergeKLists2(array);

        List<Integer> list = LeetcodeListDemo.getValues(result);
        Assert.assertEquals("[1, 1, 2, 3, 4, 4, 5, 6]", list.toString());
        System.out.println("result: " + list);
    }

    @Test
    public void reverseListTest() {
        LeetcodeListDemo.ListNode list = new LeetcodeListDemo.ListNode(1);
        list.next = new LeetcodeListDemo.ListNode(2);
        list.next.next = new LeetcodeListDemo.ListNode(4);

        // print
        LeetcodeListDemo.printList(list);

        LeetcodeListDemo.ListNode result = LeetcodeListDemo.reverseList(list);

        // print
        LeetcodeListDemo.printList(result);
    }

    @Test
    public void addTwoNumbersTest() {
        LeetcodeListDemo.ListNode l1 = new LeetcodeListDemo.ListNode(2);
        l1.next = new LeetcodeListDemo.ListNode(4);
        l1.next.next = new LeetcodeListDemo.ListNode(3);
        LeetcodeListDemo.printList(l1);

        LeetcodeListDemo.ListNode l2 = new LeetcodeListDemo.ListNode(5);
        l2.next = new LeetcodeListDemo.ListNode(6);
        l2.next.next = new LeetcodeListDemo.ListNode(4);
        LeetcodeListDemo.printList(l2);

        LeetcodeListDemo.ListNode result = LeetcodeListDemo.addTwoNumbers(l1, l2);
        List<Integer> list = LeetcodeListDemo.getValues(result);
        Assert.assertEquals("[7, 0, 8]", list.toString());
        System.out.println("result: " + list);
    }

    @Test
    public void addTwoNumbersTest2() {
        LeetcodeListDemo.ListNode l1 = new LeetcodeListDemo.ListNode(1);
        LeetcodeListDemo.printList(l1);

        LeetcodeListDemo.ListNode l2 = new LeetcodeListDemo.ListNode(9);
        l2.next = new LeetcodeListDemo.ListNode(9);
        LeetcodeListDemo.printList(l2);

        LeetcodeListDemo.ListNode result = LeetcodeListDemo.addTwoNumbers(l1, l2);
        List<Integer> list = LeetcodeListDemo.getValues(result);
        Assert.assertEquals("[0, 0, 1]", list.toString());
        System.out.println("result: " + list);
    }

}
