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
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode ptr = null;
        ListNode cur = head;
        ListNode temp;

        while(cur != null){
            temp = cur.next;
            cur.next = ptr;

            ptr = cur;
            cur = temp;
        }

        return ptr;
    }
}
