package io.github.dunwu.algorithm.linkedlist;

import org.junit.jupiter.api.Assertions;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-06-09
 */
public class 二进制链表转整数 {

    public static void main(String[] args) {
        ListNode head = ListNode.buildList(1, 0, 1);
        System.out.println(ListNode.toList(head));
        int result = getDecimalValue(head);
        Assertions.assertEquals(5, result);

        head = new ListNode(0);
        System.out.println(ListNode.toList(head));
        result = getDecimalValue(head);
        Assertions.assertEquals(0, result);

        head = new ListNode(1);
        System.out.println(ListNode.toList(head));
        result = getDecimalValue(head);
        Assertions.assertEquals(1, result);

        head = ListNode.buildList(1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0);
        System.out.println(ListNode.toList(head));
        result = getDecimalValue(head);
        Assertions.assertEquals(18880, result);
    }

    /**
     * <code>二进制链表转整数</code> 算法实现
     * <p>
     * 给你一个单链表的引用结点 head。链表中每个结点的值不是 0 就是 1。已知此链表是一个整数数字的二进制表示形式。
     * <p>
     * 请你返回该链表所表示数字的 十进制值 。
     * <p>
     * 示例 1：
     * <pre>
     * 输入：head = [1,0,1]
     * 输出：5
     * 解释：二进制数 (101) 转化为十进制数 (5)
     * </pre>
     * <p>
     * 示例 2：
     * <pre>
     * 输入：head = [0]
     * 输出：0
     * </pre>
     * <p>
     * 示例 3：
     * <pre>
     * 输入：head = [1]
     * 输出：1
     * </pre>
     * <p>
     * 示例 4：
     * <pre>
     * 输入：head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
     * 输出：18880
     * </pre>
     * <p>
     * 示例 5：
     * <pre>
     * 输入：head = [0,0]
     * 输出：0
     * </pre>
     * <p>
     * 提示：
     * <pre>
     * 链表不为空。
     * 链表的结点总数不超过 30。
     * 每个结点的值不是 0 就是 1。
     * </pre>
     *
     * @see <a href="https://leetcode-cn.com/problems/convert-binary-number-in-a-linked-list-to-integer">二进制链表转整数</a>
     */
    public static int getDecimalValue(ListNode head) {
        int sum = 0;
        while (head != null) {
            sum = sum * 2 + head.val;
            head = head.next;
        }
        return sum;
    }

}
