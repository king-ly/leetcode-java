import java.util.Stack;

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            int val = head.val;
            if (!stack.contains(val)) {
                stack.add(val);
            }
            head = head.next;
        }
        ListNode dump = null;
        while (!stack.isEmpty()) {
            ListNode tmp = new ListNode(stack.pop());
            tmp.next = dump;
            dump = tmp;
        }
        return dump;
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
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(2);
        l1.next = l2;
        l2.next = l3;

        ListNode newNode = new Solution().deleteDuplicates(l1);
        new Solution().printNode(newNode);
    }
}
