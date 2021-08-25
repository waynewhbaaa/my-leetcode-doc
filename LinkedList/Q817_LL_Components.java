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
    public int numComponents(ListNode head, int[] nums) {
        // method 1: graph = hashset;
        // method 2: check in list

        int count = 0;
        HashSet<Integer> set =  new HashSet<>();
        for(int num : nums) {
            set.add(num);
        }

        ListNode ptr = head;
        while(ptr!= null){

            if(set.contains(ptr.val) && (ptr.next == null || !set.contains(ptr.next.val))) count++;
            ptr = ptr.next;
        }
        return count;
    }

}
