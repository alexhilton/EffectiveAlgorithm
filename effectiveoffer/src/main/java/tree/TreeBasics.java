package tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class TreeBasics {
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> nodes = new LinkedList<>();
        inorderDfs(root, nodes);
        return nodes;
    }

    private static void inorderDfs(TreeNode root, List<Integer> nodes) {
        if (root == null) {
            return;
        }
        inorderDfs(root.left, nodes);
        nodes.add(root.val);
        inorderDfs(root.right, nodes);
    }

    public static List<Integer> inorderIterate(TreeNode root) {
        List<Integer> nodes = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            // root in, left in
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            // left out, root out
            curr = stack.pop();
            nodes.add(curr.val);
            curr = curr.right;
        }

        return nodes;
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> nodes = new LinkedList<>();
        preorderDfs(root, nodes);
        return nodes;
    }

    private static void preorderDfs(TreeNode root, List<Integer> nodes) {
        if (root == null) {
            return;
        }
        nodes.add(root.val);
        preorderDfs(root.left, nodes);
        preorderDfs(root.right, nodes);
    }

    public static List<Integer> preorderIterate(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                result.add(curr.val);
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            curr = curr.right;
        }
        return result;
    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> nodes = new LinkedList<>();
        postorderDfs(root, nodes);
        return nodes;
    }

    private static void postorderDfs(TreeNode root, List<Integer> nodes) {
        if (root == null) {
            return;
        }

        postorderDfs(root.left, nodes);
        postorderDfs(root.right, nodes);
        nodes.add(root.val);
    }

    public static List<Integer> postorderIterate(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        TreeNode prev = null;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.peek();
            if (curr.right != null && curr.right != prev) {
                curr = curr.right;
            } else {
                stack.pop();
                result.add(curr.val);
                prev = curr;
                curr = null;
            }
        }

        return result;
    }
}
