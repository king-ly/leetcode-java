public class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode revHead = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode node = new ListNode(cur.val);
            node.next = revHead;
            revHead = node;
            cur = cur.next;
        }
        while (revHead != null || head != null) {
            if (revHead.val != head.val) {
                return false;
            } else if (revHead == null || head == null) {
                return false;
            }
            revHead = revHead.next;
            head = head.next;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {1,2};
        ListNode head = ListNodeUtils.addReverseNodes(nums);
        System.out.println(ListNodeUtils.printListNode(head));
        boolean flag = new Solution().isPalindrome(head);
        System.out.println(flag);
    }
}
