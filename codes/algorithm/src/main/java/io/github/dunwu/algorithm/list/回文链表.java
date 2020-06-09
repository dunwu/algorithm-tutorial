package io.github.dunwu.algorithm.list;

import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-06-09
 */
public class 回文链表 {

    public static void main(String[] args) {
        ListNode head = ListUtil.buildList(1, 2, 2, 1);
        Assertions.assertTrue(isPalindrome(head));

        head = ListUtil.buildList(1, 2);
        Assertions.assertFalse(isPalindrome(head));
    }

    /**
     * <code>234. 回文链表</code> 算法实现
     * <p>
     * 判断当前单链表是否有环
     *
     * @see <a href="https://leetcode-cn.com/problems/palindrome-linked-list/">234. 回文链表</a>
     * @see <a href="https://leetcode-cn.com/problems/palindrome-linked-list-lcci/submissions/">面试题 02.06. 回文链表</a>
     */
    public static boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            list.add(node.val);
            node = node.next;
        }

        int i = 0, j = list.size() - 1;
        while (i <= j) {
            if (!list.get(i).equals(list.get(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

}
