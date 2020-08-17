public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode lNode = new ListNode(0);       //第一个节点是空节点
        ListNode rNode = new ListNode(0);
        ListNode curL = lNode;
        ListNode curR = rNode;
        while (head != null) {
            if (head.val < x) {
                curL.next = new ListNode(head.val);
                curL = curL.next;
            } else {
                curR.next = new ListNode(head.val);
                curR = curR.next;
            }
            head = head.next;
        }
        curL.next = rNode.next;         //第一个节点是空节点，所以rNode.next才是真实的
        return lNode.next;              //lNode.next才是有效节点
    }

    public static void main(String[] args) {
        int[] nums = {1,4,3,2,5,2};
        int x = 3;
        ListNode root = ListNodeUtils.addReverseNodes(nums);
        System.out.println(ListNodeUtils.printListNode(root));
        root = new Solution().partition(root,x);
        System.out.println(ListNodeUtils.printListNode(root));
    }
}
