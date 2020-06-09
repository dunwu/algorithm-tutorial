package io.github.dunwu.algorithm.list;

import org.junit.jupiter.api.Assertions;

import java.util.List;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-06-09
 */
public class 两数相加 {

    public static void main(String[] args) {
        ListNode head1 = ListUtil.buildList(2, 4, 3);
        ListNode head2 = ListUtil.buildList(5, 6, 4);
        ListNode result = addTwoNumbers(head1, head2);
        ListUtil.toList(head1);
        ListUtil.toList(head2);
        List<Integer> list = ListUtil.toList(result);
        System.out.println(list);
        Assertions.assertArrayEquals(new Integer[] { 7, 0, 8 }, list.toArray());

        head1 = new ListNode(1);
        head2 = ListUtil.buildList(9, 9);
        result = addTwoNumbers(head1, head2);
        ListUtil.toList(head1);
        ListUtil.toList(head2);
        list = ListUtil.toList(result);
        System.out.println(list);
        Assertions.assertArrayEquals(new Integer[] { 0, 0, 1 }, list.toArray());
    }

    /**
     * <code>两数相加</code> 算法实现
     * <p>
     * 给出两个 非空 的链表用来表示两个非负的整数。
     * <p>
     * 其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     * <p>
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     * <p>
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     * <p>
     * 示例：
     * <pre>
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     * </pre>
     *
     * @see <a href="https://leetcode-cn.com/problems/add-two-numbers/">两数相加</a>
     * @see <a href="https://leetcode-cn.com/problems/sum-lists-lcci/">面试题 02.05. 链表求和</a>
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // 如果任意一个表示数的链表为空，直接返回另一个链表
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        // 初始化
        int carry = 0;
        ListNode x = l1;
        ListNode y = l2;
        ListNode resultHead = new ListNode(-1);
        ListNode currNode = resultHead;

        // 同时遍历两个操作数链表，任意操作数链表的当前位数所对应元素不为 null 则累加
        while (x != null || y != null) {
            int value = carry;

            if (x != null) {
                value += x.val;
                x = x.next;
            }

            if (y != null) {
                value += y.val;
                y = y.next;
            }

            carry = value / 10;
            currNode.next = new ListNode(value % 10);
            currNode = currNode.next;
        }

        if (carry != 0) {
            currNode.next = new ListNode(carry);
        }
        return resultHead.next;
    }

}
