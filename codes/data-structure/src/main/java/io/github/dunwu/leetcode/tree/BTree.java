package io.github.dunwu.leetcode.tree;

import java.util.*;

/**
 * 二叉树
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-01-28
 */
public class BTree<T extends Comparable<T>> {

    /**
     * 二叉树根节点
     */
    private TreeNode<T> root;

    public BTree() {
        this.root = null;
    }

    public BTree(TreeNode<T> root) {
        this.root = root;
    }

    public static <T extends Comparable<T>> BTree<T> buildTree(T... array) {
        BTree<T> tree = new BTree<>();
        List<TreeNode<T>> list = new ArrayList<>();

        for (T value : array) {
            // 创建结点，每一个结点的左结点和右结点为null
            TreeNode<T> node;
            if (value == null) {
                node = null;
            } else {
                node = new TreeNode<>(value, null, null);
            }
            // list中存着每一个结点
            list.add(node);
        }

        // 构建二叉树
        if (list.size() > 0) {
            // i表示的是根节点的索引，从0开始
            for (int i = 0; i < array.length / 2 - 1; i++) {
                if (list.get(2 * i + 1) != null) {
                    // 左结点
                    list.get(i).left = list.get(2 * i + 1);
                }
                if (list.get(2 * i + 2) != null) {
                    // 右结点
                    list.get(i).right = list.get(2 * i + 2);
                }
            }
            // 判断最后一个根结点：因为最后一个根结点可能没有右结点，所以单独拿出来处理
            int lastIndex = array.length / 2 - 1;
            // 左结点
            list.get(lastIndex).left = list.get(lastIndex * 2 + 1);
            // 右结点，如果数组的长度为奇数才有右结点
            if (array.length % 2 == 1) {
                list.get(lastIndex).right = list.get(lastIndex * 2 + 2);
            }

            tree.root = list.get(0);
        } else {
            tree.root = null;
        }
        return tree;
    }

    /**
     * 判断两颗二叉树是否完全一致
     * <p>
     * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
     *
     * @param tree1 {@link BTree}
     * @param tree2 {@link BTree}
     * @param <T>   元素类型
     * @return true / false
     */
    public static <T extends Comparable<T>> boolean isEquals(final BTree<T> tree1, final BTree<T> tree2) {
        return isEquals(tree1.root, tree2.root);
    }

    /**
     * 判断两颗二叉树是否完全一致
     *
     * @param root1 二叉树根节点，类型：{@link BTree#root}
     * @param root2 二叉树根节点，类型：{@link BTree#root}
     * @param <T>   元素类型
     * @return true / false
     * @see <a href="https://leetcode-cn.com/problems/same-tree/">相同的树</a>
     */
    private static <T extends Comparable<T>> boolean isEquals(TreeNode<T> root1, TreeNode<T> root2) {
        if (root1 == null && root2 == null) {
            return true;
        }

        if (root1 == null || root2 == null) {
            return false;
        }

        if (!root1.value.equals(root2.value)) {
            return false;
        }

        return isEquals(root1.left, root2.left) && isEquals(root1.right, root2.right);
    }

    /**
     * 判断两颗二叉树的叶子节点是否相似
     *
     * @param tree1 {@link BTree}
     * @param tree2 {@link BTree}
     * @return true / false
     * @see <a href="https://leetcode-cn.com/problems/leaf-similar-trees/">叶子相似的树</a>
     */
    public static <T extends Comparable<T>> boolean isLeafSimilar(final BTree<T> tree1, final BTree<T> tree2) {
        List<T> leafs1 = new LinkedList<>();
        List<T> leafs2 = new LinkedList<>();
        getLeafNodes(tree1, leafs1);
        getLeafNodes(tree2, leafs2);
        return Arrays.equals(leafs1.toArray(), leafs2.toArray());
    }

    /**
     * 获取叶子节点
     *
     * @param tree  {@link BTree}
     * @param leafs [出参]叶子节点列表{@link List}
     * @param <T>   元素类型
     */
    public static <T extends Comparable<T>> void getLeafNodes(BTree<T> tree, List<T> leafs) {
        getLeafNodes(tree.root, leafs);
    }

    /**
     * 获取叶子节点
     *
     * @param root  {@link TreeNode}
     * @param leafs [出参]叶子节点列表{@link List}
     * @param <T>   元素类型
     */
    private static <T extends Comparable<T>> void getLeafNodes(TreeNode<T> root, List<T> leafs) {
        if (root == null) { return; }

        if (root.left == null && root.right == null) { leafs.add(root.value); }
        getLeafNodes(root.left, leafs);
        getLeafNodes(root.right, leafs);
    }

    /**
     * 返回二叉树的最大深度
     *
     * @return 二叉树的最大深度
     */
    public int maxDepth() {
        return maxDepth(this.root);
    }

    /**
     * 采用递归方法获取二叉树的最大深度
     *
     * @param root 二叉树根节点，类型：{@link BTree#root}
     * @return 二叉树的最大深度
     * @see <a href="https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/">二叉树的最大深度</a>
     */
    private int maxDepth(TreeNode<T> root) {
        if (root == null) return 0;

        int left = maxDepth(root.left);

        int right = maxDepth(root.right);

        return Math.max(left, right) + 1;
    }

    /**
     * 返回二叉树的最小深度
     *
     * @return 二叉树的最小深度
     */
    public int minDepth() {
        return minDepth(this.root);
    }

    /**
     * 采用递归方法获取二叉树的最小深度
     *
     * @param root 二叉树根节点，类型：{@link BTree#root}
     * @return 二叉树的最小深度
     * @see <a href="https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/">二叉树的最小深度</a>
     */
    private int minDepth(TreeNode<T> root) {
        if (root == null) { return 0; }

        int left = minDepth(root.left);

        int right = minDepth(root.right);

        if (left == 0 || right == 0) {
            return left + right + 1;
        }

        return Math.min(left, right) + 1;
    }

    // ------------------------------------------------------------- 遍历元素

    /**
     * 将二叉树按层次遍历顺序转换为列表，即广度优先搜索（BFS）
     *
     * @return {@link List<List<T>>}
     * @see <a href="https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/">二叉树的层次遍历 II</a>
     */
    public List<List<T>> levelOrderLists() {
        List<List<T>> lists = new ArrayList<>();
        if (root == null) { return lists; }
        Queue<TreeNode<T>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<T> temp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode<T> node = queue.poll();
                temp.add(node.value);
                if (node.left != null) { queue.offer(node.left); }
                if (node.right != null) { queue.offer(node.right); }
            }
            lists.add(temp);
        }
        return lists;
    }

    public List<T> levelOrderList() {
        List<T> list = new ArrayList<>();
        if (root == null) { return list; }
        Queue<TreeNode<T>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode<T> node = queue.poll();
                list.add(node.value);
                if (node.left != null) { queue.offer(node.left); }
                if (node.right != null) { queue.offer(node.right); }
            }
        }
        return list;
    }

    static class TreeNode<T extends Comparable<T>> {

        T value;

        TreeNode<T> left;

        TreeNode<T> right;

        public TreeNode(T value, TreeNode<T> left, TreeNode<T> right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

    }

}
