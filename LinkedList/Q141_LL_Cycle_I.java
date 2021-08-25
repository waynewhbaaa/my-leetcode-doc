/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        // 2 pointer approach
        ListNode fast = head;
        ListNode slow = head;

        // Formula: x --> step for slow pointers before getting loop start
        // y --> steps for both pointers to meet in the loop
        // z --> steps that for fast pointer to run besides y in 1 loop:
        // n --> number of rounds for faster pointer to run
        // (x + y) * 2 = x + y + n * (y+z)
        // x = (n - 1)(y + z) + z
        // so we should find the location where fast and slow pointer meet, and let slow start from head, faster start from meeting point, both move 1 step at a time
        // The point they meet again should be the answer
        while(fast != null && slow != null){
            slow = slow.next;
            if(fast.next != null && fast.next.next != null){
                fast = fast.next.next;
            }
            else{
                break;
            }

            if(fast == slow) return true;
        }

        return false;
    }
}
