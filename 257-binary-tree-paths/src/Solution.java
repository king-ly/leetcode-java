import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        if (root.left == null && root.right == null) {
            res.add(String.valueOf(root.val));
            return res;
        }
        List<String> leftList = binaryTreePaths(root.left);
        for (String s : leftList) {
            StringBuffer sb = new StringBuffer(String.valueOf(root.val));
            sb.append("->");
            sb.append(s);
            res.add(sb.toString());
        }
        List<String> rightList = binaryTreePaths(root.right);
        for (String s : rightList) {
            StringBuffer sb = new StringBuffer(String.valueOf(root.val));
            sb.append("->");
            sb.append(s);
            res.add(sb.toString());
        }
        return res;
    }

    public static void main(String[] args) {
        Integer[] nums = {1, 2, 3, null, 5};
        TreeNode root = TreeNodeUtils.arrayToNode(nums, 0);
        List<String> list = new Solution().binaryTreePaths(root);
        System.out.println(Arrays.toString(list.toArray()));
    }

}
