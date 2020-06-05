package io.github.dunwu.algorithm;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-05-13
 */
public class Test2 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode result = add(l1, l2);
        ListNode temp = result;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }

        System.out.println("result = " + listNodeToNum(result));
    }

    public static ListNode add(ListNode l1, ListNode l2) {
        ListNode n1 = l1;
        ListNode n2 = l2;
        ListNode resultNode = new ListNode(-1);
        ListNode temp = resultNode;
        boolean flag = false;
        while (n1 != null && n2 != null) {
            int value = n1.val + n2.val;
            if (flag) {
                value++;
            }
            int num = 0;
            if (value >= 10) {
                num = value % 10;
                flag = true;
            } else {
                num = value;
                flag = false;
            }

            n1 = n1.next;
            n2 = n2.next;
            temp.next = new ListNode(num);
            temp = temp.next;
        }

        if (n1 != null) {
            while (n1 != null) {
                int num = 0;
                if (flag) {
                    num = 1 + n1.val;
                } else {
                    num = n1.val;
                }
                n1 = n1.next;
                temp = new ListNode(num);
                temp = temp.next;
            }
        }

        if (n2 != null) {
            while (n2 != null) {
                int num = 0;
                if (flag) {
                    num = 1 + n2.val;
                } else {
                    num = n2.val;
                }
                n2 = n2.next;
                temp = new ListNode(num);
                temp = temp.next;
            }
        }

        return resultNode.next;
    }

    public static int listNodeToNum(ListNode head) {
        if (head == null) {
            return 0;
        }

        int result = 0;
        int pos = 0;
        ListNode node = head;
        while (node != null) {
            result +=  getBase(pos) * node.val;
            node = node.next;
            pos++;
        }

        return result;
    }

    public static int getBase(int pos) {
        if (pos <= 0) {
            return 1;
        } else {
            pos--;
            return 10 * getBase(pos);
        }
    }

    public static class ListNode {

        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }

    }

}
