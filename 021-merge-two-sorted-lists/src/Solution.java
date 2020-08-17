public class Solution {
    //需要反转
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode();
        while (l1 != null || l2 != null) {
            if (l1 != null && (l2 == null || l1.val <= l2.val)) {
                dummyHead.next = new ListNode(l1.val, dummyHead.next);
                l1 = l1.next;
            } else {
                dummyHead.next = new ListNode(l2.val, dummyHead.next);
                l2 = l2.next;
            }
        }
        return reverseNode(dummyHead.next);
    }
    //不用反转
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode();
        ListNode curr = dummyHead;
        while (l1 != null || l2 != null) {
            if (l1 != null && (l2 == null || l1.val <= l2.val)) {
                curr.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                curr.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            curr = curr.next;
        }
        return dummyHead.next;
    }

    private ListNode reverseNode(ListNode node) {
        ListNode newNode = new ListNode();
        while (node != null) {
            newNode.next = new ListNode(node.val, newNode.next);
            node = node.next;
        }
        return newNode.next;
    }

    private void printNode(ListNode node) {
        StringBuilder res = new StringBuilder();
        while (node != null) {
            res.append(node.val + "->");
            node = node.next;
        }
        res.append("NULL");
        System.out.println(res);
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode();
        l1.next = new ListNode(4, l1.next);
        l1.next = new ListNode(2, l1.next);
        l1.next = new ListNode(1, l1.next);

        ListNode l2 = new ListNode();
        l2.next = new ListNode(4, l2.next);
        l2.next = new ListNode(3, l2.next);
        l2.next = new ListNode(1, l2.next);

        ListNode newNode = new Solution().mergeTwoLists1(l1.next, l2.next);
        new Solution().printNode(newNode);
    }
}
