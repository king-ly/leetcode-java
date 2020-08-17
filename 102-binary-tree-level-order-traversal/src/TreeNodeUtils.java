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

}