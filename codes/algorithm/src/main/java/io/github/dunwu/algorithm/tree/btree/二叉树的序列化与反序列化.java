package io.github.dunwu.algorithm.tree.btree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-07-06
 */
public class 二叉树的序列化与反序列化 {

    public static void main(String[] args) {
        TreeNode tree = deserialize("[1,2,3,null,null,4,5]");
        System.out.println("args = " + serialize(tree));
    }

    public static String rserialize(TreeNode root, String str) {
        if (root == null) {
            str += "null,";
        } else {
            str += str.valueOf(root.val) + ",";
            str = rserialize(root.left, str);
            str = rserialize(root.right, str);
        }
        return str;
    }

    public static String serialize(TreeNode root) {
        String text = rserialize(root, "");
        while (text.endsWith("null,")) {
            int index = text.lastIndexOf("null,");
            text = text.substring(0, index);
        }
        if (text.endsWith(",")) {
            text = text.substring(0, text.length() - 1);
        }
        return text;
    }

    public static TreeNode rdeserialize(List<String> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        if (list.get(0).equalsIgnoreCase("null")) {
            list.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(list.get(0)));
        list.remove(0);
        root.left = rdeserialize(list);
        root.right = rdeserialize(list);

        return root;
    }

    public static TreeNode deserialize(String data) {
        data = data.substring(1, data.length() - 1);
        String[] nums = data.split(",");
        List<String> list = new LinkedList<String>(Arrays.asList(nums));
        return rdeserialize(list);
    }

}
