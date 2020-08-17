public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reNode(l1);
        l2 = reNode(l2);
        ListNode curNode = null;
        int i = 0;
        while (l1 != null || l2 != null) {
            int l1val = l1 == null ? 0 : l1.val;
            int l2val = l2 == null ? 0 : l2.val;
            int val = (l1val + l2val + i) % 10;
            i = (l1val + l2val + i) / 10;
            ListNode node = new ListNode(val);
            node.next = curNode;
            curNode = node;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (i > 0) {
            ListNode node = new ListNode(1);
            node.next = curNode;
            curNode = node;
        }
        return curNode;
    }

    private ListNode reNode(ListNode root) {
        ListNode newNode = null;
        while (root != null) {
            ListNode node = new ListNode(root.val);
            node.next = newNode;
            newNode = node;
            root = root.next;
        }
        return newNode;
    }

    public static void main(String[] args) {
        int[] num1 = {7, 2, 4, 3};
        int[] num2 = {5, 6, 4};
        ListNode l1 = ListNodeUtils.addReverseNodes(num1);
        ListNode l2 = ListNodeUtils.addReverseNodes(num2);
        System.out.println(ListNodeUtils.printListNode(l1));
        ListNode newNode = new Solution().addTwoNumbers(l1, l2);
        System.out.println(ListNodeUtils.printListNode(newNode));

    }
}
