public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode dumpHead = null;
        while (head != null) {
            ListNode node = new ListNode(head.val);
            node.next = dumpHead;
            dumpHead = node;
            head = head.next;
        }
        return dumpHead;
    }

    public static ListNode add(ListNode root, int val) {
        ListNode node = new ListNode(val);
        node.next = root;
        root = node;
        return root;
    }

    public static void main(String[] args) {
        ListNode root = null;
        root = Solution.add(root, 5);
        root = Solution.add(root, 4);
        root = Solution.add(root, 3);
        root = Solution.add(root, 2);
        root = Solution.add(root, 1);

        root = new Solution().reverseList(root);
        while (root != null) {
            System.out.println(root.val);
            root = root.next;
        }
    }
}
