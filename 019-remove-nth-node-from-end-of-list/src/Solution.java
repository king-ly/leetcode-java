public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode cur = dummyHead;
        while (cur.next != null) {
            ListNode tmpNode = cur.next;
            for (int i = 0; i < n; i++) {
                tmpNode = tmpNode.next;
            }
            if (tmpNode == null) {
                cur.next = cur.next.next;
                break;
            } else {
                cur = cur.next;
            }
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int n = 2;
        ListNode head = ListNodeUtils.addReverseNodes(nums);
        head = new Solution().removeNthFromEnd(head, n);
        System.out.println(ListNodeUtils.printListNode(head));
    }
}

