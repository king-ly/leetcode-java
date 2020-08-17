public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        //必须是叶子节点
        if (root.val == sum && root.left == null & root.right == null) {
            return true;
        }
        boolean left = hasPathSum(root.left, sum - root.val);
        if (left == true) {
            return true;
        }
        boolean right = hasPathSum(root.right, sum - root.val);
        if (right == true) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Integer[] nums = {5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1};
        int sum = 23;
        TreeNode root = TreeNodeUtils.arrayToNode(nums, 0);
        System.out.println(new Solution().hasPathSum(root, sum));
    }
}
