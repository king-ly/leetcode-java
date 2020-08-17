public class Solution {
    public void reorderList(ListNode head) {
        ListNode reHead = null;
        ListNode curNode = head;
        int size = 0;
        while (curNode != null) {
            ListNode node = new ListNode(curNode.val);
            node.next = reHead;
            reHead = node;
            curNode = curNode.next;
            size++;
        }
        curNode = head.next;
        for (int i = 0; i < (size + 1) / 2; i++) {
            curNode.val = reHead.val;
            curNode = curNode.next.next;
            reHead = reHead.next;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        ListNode head = ListNodeUtils.addReverseNodes(nums);
        System.out.println(ListNodeUtils.printListNode(head));
        new Solution().reorderList(head);
        System.out.println(ListNodeUtils.printListNode(head));
    }
}
