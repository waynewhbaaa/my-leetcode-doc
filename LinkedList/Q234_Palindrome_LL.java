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
    public boolean isPalindrome(ListNode head) {
        // O(n) time and O(1) space: find the middle pointer
        // Double pointer apporach
        ListNode dummy = new ListNode(-1, head);
        ListNode slow = dummy, fast = dummy;

        // find the middle point
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        fast = slow.next;
        slow.next = null;

        ListNode temp = null;
        ListNode reverse = fast;
        ListNode pre = null;
        //reverse the linked list from the 2nd half
        while(reverse != null){
            temp = reverse.next;
            reverse.next = pre;
            pre = reverse;
            reverse = temp;
        }

        // compare the new linked list and find out if the 2 are the same
        slow = head;
        while(pre != null && slow != null){
            if(slow.val != pre.val) return false;
            pre = pre.next;
            slow = slow.next;
        }

        return true;
    }
}
