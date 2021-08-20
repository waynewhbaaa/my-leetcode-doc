/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        double pointer;
        ListNode dummy = new ListNode(0, head);
        ListNode pre = dummy;
        ListNode cur = pre;

        int i = 0;
        while(i++ <= n) cur = cur.next;


        while(cur != null) {
            cur = cur.next;
            pre = pre.next;
        }

        pre.next = pre.next.next;

        return dummy.next;
    }
}
