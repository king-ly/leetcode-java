public class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        while (head != null) {
            ListNode cur = dummyHead;
            //找到合适插入的点
            while (cur.next != null && cur.next.val < head.val) {
                cur = cur.next;
            }
            ListNode newNode = new ListNode(head.val);
            newNode.next = cur.next;
            cur.next = newNode;
            head = head.next;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] nums = {4,2,1,3};
        ListNode root = ListNodeUtils.addReverseNodes(nums);
        System.out.println(ListNodeUtils.printListNode(root));
        root = new Solution().insertionSortList(root);
        System.out.println(ListNodeUtils.printListNode(root));
    }
}
