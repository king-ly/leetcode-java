public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return dfs(root.left, root.right);
    }

    private boolean dfs(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return dfs(root1.left, root2.right) && dfs(root1.right, root2.left);
    }

    public static void main(String[] args) {
        Integer[] nums = {1, 2, 2, 3, 4, 4, 3};
        TreeNode root = TreeNodeUtils.arrayToNode(nums, 0);
        System.out.println(new Solution().isSymmetric(root));
    }
}
