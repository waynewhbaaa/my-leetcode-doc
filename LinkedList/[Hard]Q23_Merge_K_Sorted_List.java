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
    public ListNode mergeKLists(ListNode[] lists) {

//         // Method 1: min_heap O(nklogk)
//         ListNode a = new ListNode(-1);
//         ListNode node = a;

//         // use priority queue;
//         Queue <ListNode> queue = new PriorityQueue<>(10, new Comparator<ListNode>(){
//             public int compare(ListNode a, ListNode b){
//                 return a.val - b.val;
//             }
//         });
//         for(int i = 0; i < lists.length; i++){
//             // ListNode ptr = lists[i];
//             // while(ptr != null){
//             //     queue.add(ptr);
//             //     ptr = ptr.next;
//             // }
//             if(lists[i] != null) queue.add(lists[i]);
//         }


//         while(!queue.isEmpty()){
//             node.next = queue.remove();
//             node = node.next;
//             // this can save space from O(nk) to O(n+k)
//             if(node.next != null) queue.add(node.next);
//         }
//         return a.next;

        // Method 2: merge sort (Same time but use less space)
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int l, int r){
        if(l > r) return null;
        if(l == r) return lists[l];
        if(l + 1 == r) return mergeTwoLists(lists[l], lists[l+1]);
        int m = l + (r - l) / 2;
        ListNode l1 = merge(lists, l, m);
        ListNode l2 = merge(lists, m+1, r);
        return mergeTwoLists(l1, l2);
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode ptr = dummy;
        while(l1 != null && l2!= null){
            // System.out.println(l1.val + " and " + l2.val);
            if(l1.val < l2.val) { ptr.next = l1; l1 = l1.next;}
            else { ptr.next = l2; l2 = l2.next;}
            ptr = ptr.next;
        }

        ptr.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }
}
