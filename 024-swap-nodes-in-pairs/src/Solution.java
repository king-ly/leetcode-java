public class Solution {
    //一条跳两个节点，交换1，2节点
    public ListNode swapPairs(ListNode head) {
        ListNode curNode = head;
        while (curNode != null && curNode.next != null) {
            int tmp = curNode.val;
            curNode.val = curNode.next.val;
            curNode.next.val = tmp;
            curNode = curNode.next.next;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        ListNode root = ListNodeUtils.addReverseNodes(nums);
        System.out.println(ListNodeUtils.printListNode(root));
        root = new Solution().swapPairs(root);
        System.out.println(ListNodeUtils.printListNode(root));
    }
}
