public class Solution {
    public int rob(TreeNode root) {
        return Math.max(tryRob(root, true), tryRob(root, false));
    }

    private int tryRob(TreeNode root, boolean flag) {
        if (root == null) {
            return 0;
        }
        if (flag) {
            //当前节点能用。也就是说可以用，也可以不用
            int useSum = root.val + tryRob(root.left, false) + tryRob(root.right, false);
            int unUsedSum = tryRob(root.left, true) + tryRob(root.right, true);
            return Math.max(useSum, unUsedSum);
        } else {
            return tryRob(root.left, true) + tryRob(root.right, true);
        }
    }

    public static void main(String[] args) {
        Integer[] nums = {3,4,5,1,3,null,1};
        TreeNode root = TreeNodeUtils.arrayToNode(nums, 0);
        System.out.println(new Solution().rob(root));
    }
}
