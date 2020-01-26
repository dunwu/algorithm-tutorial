package io.github.dunwu.ds.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-01-18
 */
public class LeetcodeListDemo {

    /**
     * <code>合并两个有序链表</code> 算法实现
     *
     * @see <a href="https://leetcode-cn.com/explore/featured/card/bytedance/244/linked-list-and-tree/1048/">合并两个有序链表</a>
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(-1);

        ListNode node = root;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                node.next = l1;
                l1 = l1.next;
            } else {
                node.next = l2;
                l2 = l2.next;
            }
            node = node.next;
        }

        if (l1 == null) {
            node.next = l2;
        } else {
            node.next = l1;
        }

        return root.next;
    }

    /**
     * <code>合并K个排序链表</code> 算法实现
     * <p>
     * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
     * <p>
     * 示例:
     * <p>
     * 输入:
     *
     * <pre>
     * [
     *   1->4->5,
     *   1->3->4,
     *   2->6
     * ]
     * </pre>
     * <p>
     * 输出: 1->1->2->3->4->4->5->6
     *
     * @see <a href="https://leetcode-cn.com/explore/featured/card/bytedance/244/linked-list-and-tree/1025/">合并K个排序链表</a>
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        ListNode root = new ListNode(-1);
        ListNode resultHead = root;
        while (true) {
            Integer minIndex = null;
            Integer minVal = null;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] == null) {
                    continue;
                }

                if (minVal == null || lists[i].val < minVal) {
                    minIndex = i;
                    minVal = lists[i].val;
                }
            }

            if (minIndex != null) {
                resultHead.next = new ListNode(lists[minIndex].val);
                resultHead = resultHead.next;
                lists[minIndex] = lists[minIndex].next;
            } else {
                break;
            }
        }

        return root.next;
    }

    public static ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length == 1) {
            return lists[0];
        }

        ListNode result = lists[0];
        for (int i = 1; i < lists.length; i++) {
            result = mergeTwoLists(result, lists[i]);
        }
        return result;
    }

    /**
     * <code>反转链表</code> 算法实现
     *
     * @see <a href="https://leetcode-cn.com/explore/featured/card/bytedance/244/linked-list-and-tree/1038/">反转链表</a>
     */
    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    /**
     * 给出两个 非空 的链表用来表示两个非负的整数。
     * <p>
     * 其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     * <p>
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     * <p>
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     * <p>
     * 示例：
     * <p>
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * <p>
     * 输出：7 -> 0 -> 8
     * <p>
     * 原因：342 + 465 = 807
     *
     * <code>两数相加</code> 算法实现
     *
     * @see <a href="https://leetcode-cn.com/explore/featured/card/bytedance/244/linked-list-and-tree/1022/">两数相加</a>
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

    /**
     * <code>排序链表</code> 算法实现
     * <p>
     * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
     * <p>
     * 示例 1:
     *
     * <pre>
     * 输入: 4->2->1->3
     * 输出: 1->2->3->4
     * </pre>
     * <p>
     * 示例 2:
     *
     * <pre>
     * 输入: -1->5->3->4->0
     * 输出: -1->0->3->4->5
     * </pre>
     *
     * @see <a href="https://leetcode-cn.com/explore/featured/card/bytedance/244/linked-list-and-tree/1040/">排序链表</a>
     */
    public static ListNode sortList(ListNode head) {
        if (head == null) {return head;}
        return mergeSort(head);
    }

    public static ListNode mergeSort(ListNode head) {
        //回归条件
        if (head.next == null) {
            return head;
        }
        //快指针,考虑到链表为2时的情况，fast比slow早一格
        ListNode fast = head.next;
        //慢指针
        ListNode slow = head;
        //快慢指针开跑
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //找到右子链表头元素，复用fast引用
        fast = slow.next;
        //将中点后续置空，切割为两个子链表
        slow.next = null;
        //递归分解左子链表,得到新链表起点
        head = mergeSort(head);
        //递归分解右子链表,得到新链表起点
        fast = mergeSort(fast);
        //并归两个子链表
        ListNode newHead = merge(head, fast);
        return newHead;
    }

    public static ListNode merge(ListNode left, ListNode right) {
        //维护临时序列的头元素
        ListNode head;
        if (left.val <= right.val) {
            head = left;
            left = left.next;
        } else {
            head = right;
            right = right.next;
        }
        //两个子链表均存在剩余元素
        ListNode temp = head;
        while (left != null && right != null) {
            //将较小的元素加入临时序列
            if (left.val <= right.val) {
                temp.next = left;
                left = left.next;
                temp = temp.next;
            } else {
                temp.next = right;
                right = right.next;
                temp = temp.next;
            }
        }
        //左子序列用完将右子序列余下元素加入临时序列
        if (left == null) {
            temp.next = right;
        }
        //右子序列用完将左子序列余下元素加入临时序列
        if (right == null) {
            temp.next = left;
        }
        return head;
    }

    public static List<Integer> getValues(ListNode listNode) {
        List<Integer> list = new ArrayList<>();
        ListNode item = listNode;
        while (item != null) {
            list.add(item.val);
            item = item.next;
        }
        return list;
    }

    public static void printList(ListNode result) {
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
        System.out.println();
    }

    public static class ListNode {

        int val;

        ListNode next;

        ListNode(int val) { this.val = val; }

    }

}
