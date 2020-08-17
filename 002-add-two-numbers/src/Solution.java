class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newNode = new ListNode(0);
        ListNode cur = newNode;
        int i = 0;
        while (l1 != null || l2 != null) {
            int l1val = l1 == null ? 0 : l1.val;
            int l2val = l2 == null ? 0 : l2.val;
            int val = (l1val + l2val + i) % 10;
            i = (l1val + l2val + i) / 10;
            cur.next = new ListNode(val);
            cur = cur.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (i > 0) {
            cur.next = new ListNode(1);
        }
        return newNode.next;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 4, 3};
        int[] nums2 = {5, 6, 4};
        ListNode l1 = ListNodeUtils.addReverseNodes(nums1);
        ListNode l2 = ListNodeUtils.addReverseNodes(nums2);
        System.out.println(ListNodeUtils.printListNode(l1));
        System.out.println(ListNodeUtils.printListNode(l2));
        ListNode root = new Solution().addTwoNumbers(l1, l2);
        System.out.println(ListNodeUtils.printListNode(root));
    }
}