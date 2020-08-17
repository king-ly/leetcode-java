import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode root = null;
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>((a, b) -> b.val - a.val);
        for (int i = 0; i < lists.length; i++) {
            ListNode node = lists[i];
            while (node != null) {
                pq.add(node);
                node = node.next;
            }
        }
        while (!pq.isEmpty()) {
            ListNode node = new ListNode(pq.poll().val);
            node.next = root;
            root = node;
        }
        return root;
    }

    public static void main(String[] args) {
        ListNode l1 = ListNodeUtils.addReverseNodes(new int[]{1, 4, 5});
        ListNode l2 = ListNodeUtils.addReverseNodes(new int[]{1, 3, 4});
        ListNode l3 = ListNodeUtils.addReverseNodes(new int[]{2, 6});
        ListNode[] lists = {l1, l2, l3};
        ListNode root = new Solution().mergeKLists(lists);
        System.out.println(ListNodeUtils.printListNode(root));
        StringBuffer res = new StringBuffer();
    }
}
