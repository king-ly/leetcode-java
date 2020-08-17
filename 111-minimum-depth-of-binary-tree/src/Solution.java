public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        //核心点在这里，如果left 或 rigth ==0 时。就应该取不等于0 的那一方才对
        return left == 0 || right == 0 ? Math.max(left, right) + 1 : Math.min(left, right) + 1;
    }

    public static void main(String[] args) {
//        Integer[] nums = {1, 2};  应该返回 2
        Integer[] nums = {3, 9, 20, null, null, 15, 7};
        TreeNode root = TreeNodeUtils.arrayToNode(nums, 0);
        System.out.println(new Solution().minDepth(root));
    }
}