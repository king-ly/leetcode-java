public class Solution2 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode newNode = new ListNode(head.val);
        ListNode curNode = newNode;
        head = head.next;
        while (head != null) {
            if (head.val != curNode.val) {
                curNode.next = new ListNode(head.val);
                curNode = curNode.next;
            }
            head = head.next;
        }
        return newNode;
    }


    //nums = {1,2,3,4,5}  变成 1->2->3->4->5->NULL
    public static ListNode addReverseNodes(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        ListNode head = new ListNode(nums[0]);
        //current是head的一个替身，当前位置。这样current.next的所有值，都会挂到head下面。很神奇
        ListNode current = head;
        for (int i = 1; i < nums.length; i++) {
            current.next = new ListNode(nums[i]);
            current = current.next;
        }
        return head;
    }

    public static String printListNode(ListNode root) {
        StringBuilder res = new StringBuilder();
        while (root != null) {
            res.append(root.val + "->");
            root = root.next;
        }
        res.append("NULL");
        return res.toString();
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3, 3};
        ListNode head = Solution2.addReverseNodes(nums);
        head = new Solution2().deleteDuplicates(head);
        System.out.println(Solution2.printListNode(head));
    }
}
