/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode l1 = headA;
        ListNode l2 = headB;

        if(headA == null || headB == null) return null;
        if(headA == headB) return headA;

        // easy approach calculate the size, start the ptr
        int lengthA = 0, lengthB = 0;
        while(l1 !=null) {
            l1 = l1.next;
            lengthA++;
        }

        while(l2 != null) {
            l2 = l2.next;
            lengthB++;
        }

        l1 = headA;
        l2 = headB;

        int startIndex = (lengthA >= lengthB) ? lengthA - lengthB : lengthB - lengthA;
        boolean tryA = (lengthA >= lengthB) ? true : false;

        if(tryA) while(startIndex-- > 0) l1 = l1.next;
        else while(startIndex-- > 0) l2 = l2.next;

        while(l1 != null) {
            if(l1 == l2) return l1;

            l1 = l1.next;
            l2 = l2.next;
        }

        return null;

    }
}
