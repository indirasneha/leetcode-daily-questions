import java.util.*;

public class Log_2026_02_09 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode balanceBST(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        inorderTraversal(root, inorder);
        return createBalancedBST(inorder, 0, inorder.size() - 1);
    }

    private void inorderTraversal(TreeNode root, List<Integer> inorder) {
        if (root == null) return;
        inorderTraversal(root.left, inorder);
        inorder.add(root.val);
        inorderTraversal(root.right, inorder);
    }

    private TreeNode createBalancedBST(List<Integer> inorder, int start, int end) {
        if (start > end) return null;

        int mid = start + (end - start) / 2;

        TreeNode left = createBalancedBST(inorder, start, mid - 1);
        TreeNode right = createBalancedBST(inorder, mid + 1, end);

        return new TreeNode(inorder.get(mid), left, right);
    }

    // Helper to print inorder (to verify correctness)
    private void printInorder(TreeNode root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }

    public static void main(String[] args) {
        Log_2026_02_09 obj = new Log_2026_02_09();

        // Example 1: Skewed BST
        TreeNode root1 = new TreeNode(
                1,
                null,
                new TreeNode(
                        2,
                        null,
                        new TreeNode(
                                3,
                                null,
                                new TreeNode(4)
                        )
                )
        );

        TreeNode balanced1 = obj.balanceBST(root1);
        obj.printInorder(balanced1); // should print sorted order
        System.out.println();

        // Example 2: Already balanced
        TreeNode root2 = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        TreeNode balanced2 = obj.balanceBST(root2);
        obj.printInorder(balanced2);
        System.out.println();
    }
}
