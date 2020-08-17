public class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode lNode = new ListNode();
        ListNode rNode = new ListNode();
        ListNode curL = lNode;
        ListNode curR = rNode;
        int index = 1;
        while (head != null) {
            if (index % 2 == 1) {
                //等于奇数
                curL.next = new ListNode(head.val);
                curL = curL.next;
            } else {
                curR.next = new ListNode(head.val);
                curR = curR.next;
            }
            head = head.next;
            index++;
        }
        curL.next = rNode.next;
        return lNode.next;
    }

    public ListNode oddEvenList2(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode root = new ListNode();
        ListNode newNode = root;
        ListNode cur = head;
        while (cur != null) {
            newNode.next = new ListNode(cur.val);
            newNode = newNode.next;
            if (cur.next == null || cur.next.next == null) {
                break;
            }
            cur = cur.next.next;
        }
        head = head.next;
        while (head != null) {
            newNode.next = new ListNode(head.val);
            newNode = newNode.next;
            if (head.next == null || head.next.next == null) {
                break;
            }
            head = head.next.next;
        }
        return root.next;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 3, 5, 6, 4, 7};
        ListNode root = ListNodeUtils.addReverseNodes(nums);
        System.out.println(ListNodeUtils.printListNode(root));
        root = new Solution().oddEvenList2(root);
        System.out.println(ListNodeUtils.printListNode(root));
    }
}
