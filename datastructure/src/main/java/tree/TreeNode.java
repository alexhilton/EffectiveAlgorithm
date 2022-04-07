package tree;


import java.util.ArrayList;
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
        TreeNode root = new TreeNode(nums[0]);
        TreeNode currRoot = root;
        for (int i = 1; i < nums.length; i += 2) {
            TreeNode left = nums[i] == null ? null : new TreeNode(nums[i]);
            currRoot.left = left;
            TreeNode right = null;
            if (i + 1 < nums.length) {
                right = nums[i + 1] == null ? null : new TreeNode(nums[i + 1]);
            }
            if (left != null) {
                currRoot = currRoot.left;
            }
            if (right != null) {
                currRoot.right = right;
                currRoot = currRoot.right;
            }
        }

        return root;
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

    private static void preOrderPrint(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);

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

        System.out.println(root.val);

    }

    private static void inOrderPrint(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            preOrderPrint(root.left);
        }

        System.out.println(root.val);

        if (root.right != null) {
            preOrderPrint(root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root = fromArray(new Integer[] {1, 2, 3});
        System.out.println("Pre order: ");
        preOrderPrint(root);
        System.out.println("Post order: ");
        postOrderPrint(root);
        System.out.println("Middle order: ");
        inOrderPrint(root);
    }
}
