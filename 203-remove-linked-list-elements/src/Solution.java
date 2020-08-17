public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode root = new ListNode(0);
        ListNode curNode = root;
        while (head != null) {
            if (head.val != val) {
                curNode.next = new ListNode(head.val);
                curNode = curNode.next;
            }
            head = head.next;
        }
        return root.next;
    }

    public ListNode removeElements2(ListNode head, int val) {
        ListNode dummyNode = new ListNode(-val);
        dummyNode.next = head;
        ListNode curNode = dummyNode;
        while (curNode.next != null) {
            if (curNode.next.val == val) {
                ListNode deleNode = curNode.next;
                curNode.next = deleNode.next;
            } else {
                curNode = curNode.next;
            }
        }
        return dummyNode.next;
    }

    public static void main(String[] args) {
        int[] nums = {6, 1, 2, 6, 3, 4, 5, 6};
        int val = 6;
        ListNode root = ListNodeUtils.addReverseNodes(nums);
        System.out.println(ListNodeUtils.printListNode(root));
        root = new Solution().removeElements2(root, val);
        System.out.println(ListNodeUtils.printListNode(root));
    }
}
