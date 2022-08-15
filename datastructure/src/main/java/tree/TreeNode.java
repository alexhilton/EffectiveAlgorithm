package tree;

import java.util.*;
import java.util.stream.Collectors;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {}

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode fromArray(Integer[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        List<TreeNode> nodes = new ArrayList<>(nums.length);
        for (Integer a : nums) {
            TreeNode n = a == null ? null : new TreeNode(a);
            nodes.add(n);
        }
        if (nums.length == 2) {
            nodes.get(0).left = nodes.get(1);
        } else {
            for (int i = 0; i * 2 + 2 < nums.length; i++) {
                TreeNode n = nodes.get(i);
                if (n != null) {
                    n.left = nodes.get(2 * i + 1);
                    n.right = nodes.get(2 * i + 2);
                }
            }
        }

        return nodes.get(0);
    }

    public static Integer[] toArray(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        List<TreeNode> parents = new ArrayList<>();
        List<TreeNode> children = new ArrayList<>();
        parents.add(root);
        while (!parents.isEmpty()) {
            for (TreeNode node : parents) {
                result.add(node == null ? null : node.val);
                if (node != null) {
                    children.add(node.left);
                    children.add(node.right);
                }
            }

            for (int i = children.size() - 1; i >= 0; i--) {
                TreeNode n = children.get(i);
                if (n == null) {
                    children.remove(i);
                } else {
                    break;
                }
            }

            List<TreeNode> tmp = parents;
            parents = children;
            children = tmp;
            children.clear();
        }

        return result.toArray(Integer[]::new);
    }

    public static List<Integer> postOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        if (root.left != null) {
            result.addAll(postOrder(root.left));
        }

        if (root.right != null) {
            result.addAll(postOrder(root.right));
        }

        result.add(root.val);

        return result;
    }

    public static void preOrderPrint(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val + ",");

        if (root.left != null) {
            preOrderPrint(root.left);
        }
        if (root.right != null) {
            preOrderPrint(root.right);
        }
    }

    private static void postOrderPrint(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            preOrderPrint(root.left);
        }

        if (root.right != null) {
            preOrderPrint(root.right);
        }

        System.out.println(root.val + ",");

    }

    private static void inOrderPrint(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            preOrderPrint(root.left);
        }

        System.out.println(root.val + ",");

        if (root.right != null) {
            preOrderPrint(root.right);
        }
    }

    private static List<TreeNode> inorder(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            result.add(cur);
            cur = cur.right;
        }
        System.out.println("inorder [" +
                result.stream().map(v -> String.valueOf(v.val)).collect(Collectors.joining(", ")) +
                "]");
        return result;
    }

    private static void visualize(Integer[] trees) {
        System.out.println("Binary Tree: " + Arrays.toString(trees));
        TreeNode root = fromArray(trees);
        visualizeTree(root);
    }

    private static void visualizeTree(TreeNode root) {
        if (root == null) {
            System.out.println("Empty tree");
            return;
        }
        int height = height(root);
        List<TreeNode> inorderList = inorder(root);
        int stride = inorderList.size();
        String[][] matrix = new String[height][stride];

        LinkedList<TreeNode> parents = new LinkedList<>();
        LinkedList<TreeNode> children = new LinkedList<>();

        parents.add(root);
        int maxWidth = 0;
        int h = 0;
        while (!parents.isEmpty()) {
            for (int i = 0; i < inorderList.size(); i++) {
                TreeNode n = inorderList.get(i);
                if (parents.contains(n)) {
                    matrix[h][i] = String.valueOf(n.val);
                }
            }
            for (TreeNode node : parents) {
                if (node.left != null) {
                    children.add(node.left);
                }
                if (node.right != null) {
                    children.add(node.right);
                }
            }
            h++;
            LinkedList<TreeNode> tmp = parents;
            parents = children;
            children = tmp;
            children.clear();
        }

        for (int i = 0; i < height; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < stride; j++) {
                String payload = matrix[i][j] == null ? "" : matrix[i][j];
                int padding = maxWidth - payload.length();
                int rear = padding - padding / 2;
                for (int k = 0; k < rear; k++) {
                    sb.append(" ");
                }
                sb.append(payload);
                for (int k = 0; k < rear + 1; k++) {
                    sb.append(" ");
                }
            }
            System.out.println(sb);
        }
    }

    private static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    public static void main(String[] args) {
        visualize(null);
        visualize(new Integer[] {null});
        visualize(new Integer[] {1});
        visualize(new Integer[] {1, 2});
        visualize(new Integer[] {1, 2, 3});
        visualize(new Integer[] {3,9,20,null,null,15,7});
        visualize(new Integer[] {4,1,6,0,2,5,7,null,null,null,3,null,null,null,8});
        visualize(new Integer[] {1,2,2,3,4,4,3});
        visualize(new Integer[] {1,2,2,null,3,null,3});
    }
}
