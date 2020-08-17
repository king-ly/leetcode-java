import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List list = new LinkedList();
        perOrder(root, list);
        return list;
    }

    private void perOrder(TreeNode root, List list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        perOrder(root.left, list);
        perOrder(root.right, list);
    }

    public static void main(String[] args) {

    }
}
