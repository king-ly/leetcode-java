import java.util.*;

public class TreeNodeUtils {

    public static TreeNode arrayToNode(Integer[] arr, int index) {
        TreeNode treeNode = null;
        if (index <= arr.length - 1) {
            if (arr[index] != null) {
                treeNode = new TreeNode(arr[index]);
                treeNode.left = arrayToNode(arr, index * 2 + 1);
                treeNode.right = arrayToNode(arr, index * 2 + 2);
            }
        }
        return treeNode;
    }

    public static class Pair {
        TreeNode treeNode;
        int level;

        Pair(TreeNode treeNode, int level) {
            this.treeNode = treeNode;
            this.level = level;
        }
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                list.add(node.val);
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            result.add(list);
        }

        return result;
    }

    //层序遍历
    public static List<List<Integer>> levelOrder2(TreeNode root) {
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
        List<List<Integer>> lists = TreeNodeUtils.levelOrder(root);
        System.out.println(Arrays.toString(lists.toArray()));
    }
}