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
    public ListNode[] splitListToParts(ListNode head, int k) {
        // simulation
        ListNode[] output = new ListNode[k];

        // find total length
        ListNode ptr = head;
        int total_len = 0;
        while(ptr != null) {
            total_len++;
            ptr = ptr.next;
        }

        int part_len = total_len / k;
        int rest = total_len % k;
        ptr = head;
        ListNode pre = ptr;
        int count = 1, i = 0;
        int part_i_len = (rest > 0) ? part_len + 1 : part_len;
        while(ptr != null){
            if(count == part_i_len){

                output[i++] = pre;
                count = 1;
                pre = ptr;
                ptr = ptr.next;
                pre.next = null;
                pre = ptr;
                if(rest > 0) rest--;
                // System.out.println("rest: " + rest);
                part_i_len = (rest > 0) ? part_len + 1 : part_len;

                continue;
            }
            count++;
            ptr = ptr.next;
        }

        return output;
    }
}
