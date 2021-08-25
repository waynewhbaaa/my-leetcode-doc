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
    public ListNode rotateRight(ListNode head, int k) {
        // first count the size of the linked list

        ListNode ptr = head;
        ListNode pre = ptr;
        int size = 0;
        while(ptr != null) {
            pre = ptr;
            ptr = ptr.next;
            size++;
        }

        if(k == 0 || size == 0) return head;

        // pre is the end listnode
        int rotate = k % size;
        // no need to rotate
        if(rotate == 0) return head;

        int count = size - rotate - 1;

        ptr = head;
        // find the new head node
        while(count-- > 0){
            ptr = ptr.next;
        }

        pre.next = head;
        head = ptr.next;
        ptr.next = null;

        return head;
    }
}
