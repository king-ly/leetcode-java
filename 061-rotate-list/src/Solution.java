public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode curNode = dummyHead;
        while (curNode.next != null) {
            ListNode tmp = curNode.next;
            for (int i = 0; i < k; i++) {
                tmp = tmp.next;
            }
            if (tmp == null) {
                ListNode node = curNode.next;
                dummyHead.next = node;
                curNode.next = null;
                //将dummyhead与head拼接
                while (node.next != null) {
                    node = node.next;
                }
                node.next = head;
                break;
            } else {
                curNode = curNode.next;
            }
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int k = 2;
        ListNode head = ListNodeUtils.addReverseNodes(nums);
        System.out.println(ListNodeUtils.printListNode(head));
        head = new Solution().rotateRight(head, k);
        System.out.println(ListNodeUtils.printListNode(head));
    }
}
