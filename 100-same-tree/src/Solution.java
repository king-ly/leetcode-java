import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        List<Integer> pList = new ArrayList<>();
        List<Integer> qList = new ArrayList<>();
        preOrder(p, pList);
        preOrder(q, qList);
        return Arrays.equals(pList.toArray(), qList.toArray());
    }


    private void preOrder(TreeNode node, List<Integer> ret) {
        if (node == null) {
            ret.add(-1);
            return;
        }
        ret.add(node.val);
        preOrder(node.left, ret);
        preOrder(node.right, ret);
    }

    private TreeNode add(TreeNode node, int e) {
        if (node == null) {
            return new TreeNode(e);
        }
        if (e < node.val) {
            node.left = add(node.left, e);
        } else {
            node.right = add(node.right, e);
        }
        return node;
    }

    public static void main(String[] args) {
        TreeNode treeNode = null;
        Solution s = new Solution();
        treeNode = s.add(treeNode, 4);
        treeNode = s.add(treeNode, 2);
        treeNode = s.add(treeNode, 1);
        treeNode = s.add(treeNode, 5);
        treeNode = s.add(treeNode, 6);
        List<Integer> pList = new ArrayList<>();
        s.preOrder(treeNode, pList);
        System.out.println(Arrays.toString(pList.toArray()));
    }
}
