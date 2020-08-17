import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int sumNumbers(TreeNode root) {
        List<String> list = this.sumTreeNodes(root);
        int sum = 0;
        for (String val : list) {
            System.out.println("值:" + val);
            sum = sum + Integer.valueOf(val);
        }
        return sum;
    }

    private List<String> sumTreeNodes(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        if (root.left == null && root.right == null) {
            result.add(String.valueOf(root.val));
            return result;
        }
        List<String> leftList = sumTreeNodes(root.left);
        for (String s : leftList) {
            StringBuffer sb = new StringBuffer(String.valueOf(root.val));
            sb.append(s);
            result.add(sb.toString());
        }
        List<String> rightList = sumTreeNodes(root.right);
        for (String s : rightList) {
            StringBuffer sb = new StringBuffer(String.valueOf(root.val));
            sb.append(s);
            result.add(sb.toString());
        }
        return result;
    }

    public static void main(String[] args) {
        Integer[] nums = {4,9,0,5,1};
        TreeNode root = TreeNodeUtils.arrayToNode(nums, 0);
        System.out.println(new Solution().sumNumbers(root));
    }
}
