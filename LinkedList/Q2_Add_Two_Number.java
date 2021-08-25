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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {


        ListNode left = l1;
        ListNode right = l2;

        int carry = 0;
        ListNode head = new ListNode(-1);
        ListNode pre = head;

//         while(left != null && right != null) {
//             int sum = (left.val + right.val + carry) % 10;
//             ListNode node = new ListNode(sum);
//             carry = (left.val + right.val + carry) / 10;

//             pre.next = node;
//             pre = pre.next;

//             left = left.next;
//             right = right.next;
//         }

//         ListNode cur = null;
//         if(left != null) cur = left;
//         else if(right != null) cur = right;

//         while(cur != null){
//             int sum = cur.val + carry;
//             int s = sum % 10;
//             ListNode node = new ListNode(s);
//             carry =  sum / 10;
//             pre.next = node;
//             pre = pre.next;

//             cur = cur.next;
//         }

//         // check the last carry for 1;
//         if(carry != 0){
//             ListNode node = new ListNode(carry);
//             pre.next = node;
//         }

        int sum = 0;
        while(left != null || right != null || sum > 0){
            sum += (left == null ? 0 : left.val) + (right == null ? 0 : right.val);
            pre.next = new ListNode(sum % 10);
            pre = pre.next;
            if(left != null) left = left.next;
            if(right != null) right = right.next;

            //find carry bit;
            sum /= 10;
        }
        return head.next;
    }
}
