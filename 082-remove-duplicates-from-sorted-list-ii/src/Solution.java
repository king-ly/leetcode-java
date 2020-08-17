public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode root = new ListNode(0);
        root.next = head;
        ListNode curNode = root;
        ListNode delNode = null;
        while (curNode.next != null) {
            if (curNode.next.next != null && curNode.next.val == curNode.next.next.val) {
                delNode = curNode.next.next;
                curNode.next = delNode.next;
            } else if (delNode != null && curNode.next.val == delNode.val) {
                delNode = curNode.next;
                curNode.next = delNode.next;
            } else {
                delNode = null;
                curNode = curNode.next;
            }

        }
        return root.next;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,3,4,4,5};
        ListNode root = ListNodeUtils.addReverseNodes(nums);
        System.out.println(ListNodeUtils.printListNode(root));
        root = new Solution().deleteDuplicates(root);
        System.out.println(ListNodeUtils.printListNode(root));
    }
}
