public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        invertTree(root.left);
        invertTree(root.right);
        return swap(root);
    }

    private TreeNode swap(TreeNode root) {
        TreeNode node = root.left;
        root.left = root.right;
        root.right = node;
        return root;
    }

    public static void main(String[] args) {
        Integer[] nums = {4, 2, 7, 1, 3, 6, 9};
        TreeNode root = TreeNodeUtils.arrayToNode(nums, 0);
        root = new Solution().invertTree(root);
        TreeNodeUtils.printLevelOrder(root);
    }
}
