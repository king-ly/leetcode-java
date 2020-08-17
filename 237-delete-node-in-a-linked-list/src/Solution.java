public class Solution {
    //将下一节点的val赋值给当前节点
    //将下一节点删除就可以了
    public void deleteNode(ListNode node) {
        if (node == null) {
            return;
        }
        if (node.next == null) {
            node = null;
            return;
        }
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
