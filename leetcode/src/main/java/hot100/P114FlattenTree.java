package hot100;

import tree.TreeNode;

public class P114FlattenTree {
    public static void flattenTree(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode left = root.left;
        TreeNode right = root.right;
        if (left == null && right == null) {
            return;
        }
        root.left = null;
        root.right = left;
        TreeNode tail = root.right;
        if (left != null) {
            tail = doFlatten(left, tail);
        }
        if (right != null) {
            doFlatten(right, tail);
        }
    }

    private static TreeNode doFlatten(TreeNode root, TreeNode newRoot) {
        if (root == null) {
            return newRoot;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        newRoot.left = null;

        if (left == null && right == null) {
            newRoot.right = root;
            return newRoot.right;
        }

        newRoot.right = root;
        TreeNode tail = newRoot.right;
        if (left != null) {
            tail = doFlatten(left, tail);
        }
        if (right != null) {
            tail = doFlatten(right, tail);
        }
        return tail;
    }
}
