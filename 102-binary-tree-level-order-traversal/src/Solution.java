import java.util.*;

public class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            List<TreeNode> popNodeList = new ArrayList<>();
            while (!q.isEmpty()) {
                popNodeList.add(q.remove());
            }
            List<Integer> resultVal = new ArrayList<>();
            while (!popNodeList.isEmpty()) {
                TreeNode node = popNodeList.remove(0);
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
                resultVal.add(node.val);
            }
            if (resultVal.size() > 0) {
                result.add(resultVal);
            }
        }
        return result;
    }

    public class Pair {
        TreeNode treeNode;
        int level;

        Pair(TreeNode treeNode, int level) {
            this.treeNode = treeNode;
            this.level = level;
        }
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        while (!q.isEmpty()) {
            Pair p = q.poll();
            TreeNode popTreeNode = p.treeNode;
            int popLevel = p.level;
            if (result.size() <= popLevel) {
                result.add(popLevel, new ArrayList<>());
            }
            //这会原地改变list的值
            result.get(popLevel).add(popTreeNode.val);

            if (popTreeNode.left != null) {
                q.add(new Pair(popTreeNode.left, popLevel + 1));
            }
            if (popTreeNode.right != null) {
                q.add(new Pair(popTreeNode.right, popLevel + 1));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Integer[] nums = {3, 9, 20, null, null, 15, 7};
        TreeNode root = TreeNodeUtils.arrayToNode(nums, 0);
        List<List<Integer>> lists = new Solution().levelOrder2(root);
        System.out.println(Arrays.toString(lists.toArray()));

    }
}
