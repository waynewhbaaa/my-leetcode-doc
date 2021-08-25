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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode ptr = dummy;

        while(l1 != null && l2 != null){

            if(l1.val < l2.val){
                ptr.next = l1;
                l1 = l1.next;
            }
            else{
                ptr.next = l2;
                l2 = l2.next;
            }
            ptr = ptr.next;
        }

        ptr.next = (l1 != null) ? l1 : l2;

        return dummy.next;
    }
}
