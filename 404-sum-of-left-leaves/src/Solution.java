public class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        return sumOfLeftLeaves(root, false);
    }

    private int sumOfLeftLeaves(TreeNode root, boolean flag) {
        if (root == null) {
            return 0;
        }
        if (flag && root.left == null && root.right == null) {
            return root.val;
        }
        int leftSum = sumOfLeftLeaves(root.left, true);
        int rightSum = sumOfLeftLeaves(root.right, false);

        return leftSum + rightSum;
    }

    public static void main(String[] args) {
        Integer[] nums = {3, 9, 20, null, null, 15, 7};
        TreeNode root = TreeNodeUtils.arrayToNode(nums, 0);
        System.out.println(new Solution().sumOfLeftLeaves(root));
    }
}
