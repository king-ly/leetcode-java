public class Solution {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        res += findPath(root, sum);
        res += pathSum(root.left, sum);
        res += pathSum(root.right, sum);
        return res;
    }

    private int findPath(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        if (root.val == sum) {
            res = res + 1;
        }
        res = res + findPath(root.left, sum - root.val);
        res = res + findPath(root.right, sum - root.val);
        return res;
    }

    public static void main(String[] args) {
        Integer[] nums = {10, 5, -3, 3, 2, null, 11, 3, -2, null, 1};
        int sum = 8;
        TreeNode root = TreeNodeUtils.arrayToNode(nums, 0);
        System.out.println(new Solution().pathSum(root, sum));
    }
}
