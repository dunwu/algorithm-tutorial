package io.github.dunwu.algorithm.list;

import org.junit.jupiter.api.Assertions;

import java.util.List;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-06-09
 */
public class 链表的中间结点 {

    public static void main(String[] args) {
        ListNode head = ListUtil.buildList(1, 2, 3, 4, 5, 6);
        System.out.println(ListUtil.toList(head));
        ListNode result = middleNode(head);
        List<Integer> list = ListUtil.toList(result);
        System.out.println(list);
        Assertions.assertArrayEquals(new Integer[] { 4, 5, 6 }, list.toArray(new Integer[0]));

        head = ListUtil.buildList(1, 2, 3, 4, 5);

        System.out.println(ListUtil.toList(head));
        result = middleNode(head);
        list = ListUtil.toList(result);
        System.out.println(list);
        Assertions.assertArrayEquals(new Integer[] { 3, 4, 5 }, list.toArray(new Integer[0]));
    }

    /**
     * <code>链表的中间结点</code> 算法实现
     * <p>
     * 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
     * <p>
     * 如果有两个中间结点，则返回第二个中间结点。
     * <p>
     * 示例 1：
     * <pre>
     * 输入：[1,2,3,4,5]
     * 输出：此列表中的结点 3 (序列化形式：[3,4,5])
     * 返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
     * 注意，我们返回了一个 ListNode 类型的对象 ans，这样：
     * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = NULL.
     * </pre>
     * <p>
     * 示例 2：
     * <pre>
     * 输入：[1,2,3,4,5,6]
     * 输出：此列表中的结点 4 (序列化形式：[4,5,6])
     * 由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
     * </pre>
     * <p>
     * 提示：给定链表的结点数介于 1 和 100 之间。
     *
     * @see <a href="https://leetcode-cn.com/problems/middle-of-the-linked-list">链表的中间结点</a>
     */
    public static ListNode middleNode(ListNode head) {
        // 利用快慢指针，慢指针每次偏移一个节点，快指针每次偏移两个节点
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}
