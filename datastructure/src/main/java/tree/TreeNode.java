package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

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

        for (int i = 0; i * 2 + 2 < nums.length; i++) {
            TreeNode n = nodes.get(i);
            if (n != null) {
                n.left = nodes.get(2 * i + 1);
                n.right = nodes.get(2 * i + 2);
            }
        }

        return nodes.get(0);
    }

    public static Integer[] toArray(TreeNode root) {
        return toArrayList(root).toArray(new Integer[0]);
    }

    public static List<Integer> toArrayList(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        result.add(root.val);
        if (root.left == null && root.right == null) {
            return result;
        }
        if (root.left != null) {
            result.addAll(toArrayList(root.left));
        } else {
            result.add(null);
        }
        if (root.right != null) {
            result.addAll(toArrayList(root.right));
        }

        return result;
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

    private static void visualize(Integer[] trees) {
        System.out.println("Binary Tree: " + Arrays.toString(trees));
        TreeNode root = fromArray(trees);
        doVisualize(root);
    }

    private static void doVisualize(TreeNode root) {
        if (root == null) {
            System.out.println("Empty tree");
            return;
        }
        int height = height(root);
        int stride = (int) (Math.pow(2, height) - 1);
        String[][] matrix = new String[height][stride];

        LinkedList<TreeNode> parents = new LinkedList<>();
        parents.add(root);
        LinkedList<TreeNode> children = new LinkedList<>();
        int maxWidth = 0;
        int h = 0;
        while (h < height) {
            int c = 0;
            for (TreeNode node : parents) {
                matrix[h][c] = node == null ? "" : String.valueOf(node.val);
                maxWidth = Math.max(maxWidth, matrix[h][c].length());
                if (node != null) {
                    children.add(node.left);
                    children.add(node.right);
                }
                c++;
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
        visualize(new Integer[] {1, 2, 3});
        visualize(new Integer[] {3,9,20,null,null,15,7});
        visualize(new Integer[] {4,1,6,0,2,5,7,null,null,null,3,null,null,null,8});
    }
}
