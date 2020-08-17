import java.util.*;

public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 1; i <= size; i++) {
                TreeNode node = q.poll();
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
                if (i == size) {
                    list.add(node.val);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Integer[] nums = {1, 2};
        TreeNode root = TreeNodeUtils.arrayToNode(nums, 0);
        List<Integer> list = new Solution().rightSideView(root);
        System.out.println(Arrays.toString(list.toArray()));
    }
}
