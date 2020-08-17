public class ListNodeUtils {
    //添加node节点,在头部 5->4->3->2->1->NULL
    // 添加个6  变成  6->5->4->3->2->1->NULL
    public static ListNode addNode(ListNode root, int val) {
        ListNode node = new ListNode(val);
        node.next = root;
        root = node;
        return root;
    }


    // //nums = {1,2,3,4,5}  变成 5->4->3->2->1->NULL
    public static ListNode addNodes(int[] nums) {
        ListNode root = null;
        for (int i = 0; i < nums.length; i++) {
            ListNode node = new ListNode(nums[i]);
            node.next = root;
            root = node;
        }
        return root;
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
        int[] nums = {1, 2, 3, 4, 5};
        ListNode root = ListNodeUtils.addNodes(nums);
        System.out.println(ListNodeUtils.printListNode(root));
    }
}
