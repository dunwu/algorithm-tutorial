package io.github.dunwu.algorithm.tree.btree;

import io.github.dunwu.algorithm.tree.TreeNode;
import io.github.dunwu.algorithm.tree.TreeUtils;

import java.util.Stack;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-06-18
 */
public class 从先序遍历还原二叉树 {

    public static void main(String[] args) {
        TreeNode result = recoverFromPreorder("1-2--3--4-5--6--7");
        System.out.println(TreeUtils.toBfsList(result));
    }

    public static TreeNode recoverFromPreorder(String S) {
        if (S == null || S.length() == 0) return null;

        Stack<TreeNode> stack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            int level = 0;

            // 获取节点深度
            if (S.charAt(i) == '-') {
                while (i < S.length() && S.charAt(i) == '-') {
                    level++;
                    i++;
                }
            }

            // 获取节点值
            int data = 0;
            if (S.charAt(i) != '-') {
                while (i < S.length() && S.charAt(i) != '-') {
                    data = data * 10 + (S.charAt(i) - '0');
                    i++;
                }
                i--;
            }

            // 打印必然成对出现的 节点深度 和 节点值
            System.out.printf("level = %d, num = %d\n", level, data);

            // 构建新节点
            TreeNode node = new TreeNode(data);

            // 栈为空，push 栈顶节点
            if (stack.isEmpty()) {
                stack.push(node);
                continue;
            }

            // 如果栈的 size > 当前节点的 level，即 栈顶节点的 level >= 当前节点的level
            // 则说明栈顶不是父亲，栈顶遇到的已经是别人的儿子
            // 说明栈顶的儿子已经找齐了，即自己的子树已经构建完了，该出栈了（子调用有了结果）
            while (stack.size() > level) {
                stack.pop();
            }

            TreeNode parent = stack.peek();
            if (parent.left == null) {
                parent.left = node;
            } else {
                parent.right = node;
            }
            stack.push(node);
        }
        while (stack.size() > 1) {
            stack.pop();
        }
        return stack.pop();
    }

}
