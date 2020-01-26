package io.github.dunwu.ds.list;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-01-18
 */
public class LeetcodeListDemo {

    /**
     * <code>234. 回文链表</code> 算法实现
     * <p>
     * 判断当前单链表是否有环
     *
     * @see <a href="https://leetcode-cn.com/problems/palindrome-linked-list/">234. 回文链表</a>
     */
    // public static boolean isPalindrome(ListNode head) {
    //
    // }

    /**
     * <code>141. 环形链表</code> 算法实现
     * <p>
     * 判断当前单链表是否有环
     *
     * @see <a href="https://leetcode-cn.com/problems/linked-list-cycle/">141. 环形链表</a>
     */
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }

    /**
     * <code>206. 反转链表</code> 算法实现
     *
     * @see <a href="https://leetcode-cn.com/problems/reverse-linked-list/">206. 反转链表</a>
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
     * <code>148. 排序链表</code> 算法实现
     * <p>
     * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
     * <p>
     * 示例 1:
     * <pre>
     * 输入: 4->2->1->3
     * 输出: 1->2->3->4
     * </pre>
     * <p>
     * 示例 2:
     * <pre>
     * 输入: -1->5->3->4->0
     * 输出: -1->0->3->4->5
     * </pre>
     *
     * @see <a href="https://leetcode-cn.com/problems/sort-list/">148.排序链表</a>
     */
    public static ListNode sortList(ListNode head) {
        if (head == null) {return head;}
        return mergeSort(head);
    }

    /**
     * <code>相交链表</code> 算法实现
     * <p>
     * 编写一个程序，找到两个单链表相交的起始节点。
     * <p>
     * 示例 1：
     * <pre>
     * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
     * 输出：Reference of the node with value = 8
     * 输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
     * </pre>
     * <p>
     * 示例 2：
     * <pre>
     * 输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
     * 输出：Reference of the node with value = 2
     * 输入解释：相交节点的值为 2 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
     * </pre>
     * <p>
     * 示例 3：
     * <pre>
     * 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
     * 输出：null
     * 输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
     * 解释：这两个链表不相交，因此返回 null。
     * </pre>
     * <p>
     * 注意：
     * <pre>
     * 如果两个链表没有交点，返回 null.
     * 在返回结果后，两个链表仍须保持原有的结构。
     * 可假定整个链表结构中没有循环。
     * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
     * </pre>
     *
     * @see <a href="https://leetcode-cn.com/problems/intersection-of-two-linked-lists">相交链表</a>
     */
    public static ListNode getIntersectionNode(final ListNode headA, final ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

    // ----------------------------------------------------------- 删除操作

    /**
     * <code>83. 删除排序链表中的重复元素</code> 算法实现
     * <p>
     * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
     * <p>
     * 示例 1:
     * <pre>
     * 输入: 1->1->2
     * 输出: 1->2
     * </pre>
     * <p>
     * 示例 2:
     * <pre>
     * 输入: 1->1->2->3->3
     * 输出: 1->2->3
     * </pre>
     *
     * @see <a href="https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list">83. 删除排序链表中的重复元素</a>
     */
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode node = head;
        while (node != null && node.next != null) {
            if (node.next.val == node.val) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
        return head;
    }

    /**
     * <code>203. 移除链表元素</code> 算法实现
     * <p>
     * 删除链表中等于给定值 val 的所有节点。
     * <p>
     * 示例:
     * <pre>
     * 输入: 1->2->6->3->4->5->6, val = 6
     * 输出: 1->2->3->4->5
     * </pre>
     *
     * @see <a href="https://leetcode-cn.com/problems/intersection-of-two-linked-lists">203. 移除链表元素</a>
     */
    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        ListNode root = new ListNode(-1);
        root.next = head;
        ListNode prev = root;
        while (prev != null && prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return root.next;
    }

    // ----------------------------------------------------------- 查找操作

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

    // ----------------------------------------------------------- 合并操作

    /**
     * <code>合并两个有序链表</code> 算法实现
     *
     * @see <a href="https://leetcode-cn.com/problems/merge-two-sorted-lists/">合并两个有序链表</a>
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
     * <code>23. 合并K个排序链表</code> 算法实现
     * <p>
     * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
     * <p>
     * 示例:
     * <pre>
     * 输入:
     * [
     *   1->4->5,
     *   1->3->4,
     *   2->6
     * ]
     * 输出: 1->1->2->3->4->4->5->6
     * </pre>
     *
     * @see <a href="https://leetcode-cn.com/problems/merge-k-sorted-lists/">23. 合并K个排序链表</a>
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

    /**
     * <code>23. 合并K个排序链表</code> 算法实现
     * <p>
     * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
     * <p>
     * 示例:
     * <pre>
     * 输入:
     * [
     *   1->4->5,
     *   1->3->4,
     *   2->6
     * ]
     * 输出: 1->1->2->3->4->4->5->6
     * </pre>
     *
     * @see <a href="https://leetcode-cn.com/problems/merge-k-sorted-lists/">23. 合并K个排序链表</a>
     */
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

    static ListNode mergeSort(ListNode head) {
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

    static ListNode merge(ListNode left, ListNode right) {
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

    // ----------------------------------------------------------- 辅助操作

    public static List<Integer> getValues(ListNode listNode) {
        List<Integer> list = new ArrayList<>();
        ListNode item = listNode;
        while (item != null) {
            list.add(item.val);
            item = item.next;
        }
        return list;
    }

    public static ListNode buildList(int... list) {
        ListNode head = new ListNode(-1);
        ListNode node = head;
        for (int val : list) {
            node.next = new ListNode(val);
            node = node.next;
        }
        return head.next;
    }

    public static ListNode buildCycleList(int pos, int[] list) {
        ListNode head = new ListNode(-1);
        ListNode node = head;
        ListNode cycleBeginNode = null;
        for (int val : list) {
            ListNode item = new ListNode(val);
            if (pos == 0) {
                cycleBeginNode = item;
            } else {
                pos--;
            }
            node.next = item;
            node = node.next;
        }
        if (cycleBeginNode != null) {
            node.next = cycleBeginNode;
        }
        return head.next;
    }

    public static List<Integer> toList(ListNode result) {
        List<Integer> list = new ArrayList<>();
        while (result != null) {
            list.add(result.val);
            result = result.next;
        }
        return list;
    }

    public static class ListNode {

        int val;

        ListNode next;

        ListNode(int val) { this.val = val; }

    }

}
