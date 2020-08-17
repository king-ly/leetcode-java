public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }

    public static void main(String[] args) {
        Integer[] nums = {6, 2, 8, 0, 4, 7, 9, null, null, 3, 5};
        Integer[] nums2 = {2};
        Integer[] nums3 = {4};
        TreeNode root = TreeNodeUtils.arrayToNode(nums, 0);
        TreeNode p = TreeNodeUtils.arrayToNode(nums2, 0);
        TreeNode q = TreeNodeUtils.arrayToNode(nums3, 0);
        root = new Solution().lowestCommonAncestor(root, p, q);
        System.out.println(root.val);
    }
}
