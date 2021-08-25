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

    public ListNode sortList(ListNode head) {

        // solution 1: convert to Arrays/Lists and sort
        // O(nlgn Time and O(n) space for recursive call stack

        // solution 2: mergesort top down approach
        // O(nlgn) time and O(lgn) space
        // split by half using 2 pointers
        // get 2 sort lists
        // merge

        // first find the mid node to split
        // terminate condition: reach the end of listnode
//         if(head == null || head.next == null) return head;

//         ListNode slow = head;
//         ListNode fast = head.next;

//         while(fast != null && fast.next != null){

//             fast = fast.next.next;
//             slow = slow.next;
//         }

//         ListNode mid = slow.next;

//         slow.next = null;

//         return mergeSort(sortList(head), sortList(mid));

        // method 3: merge sort bottom up approach
        // O(nlgn) time and O(1) space?
        int size = getCount(head);

        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        ListNode start = head;
        ListNode l = null, 4 = null;

        for(int n = 1; n < size; n *= 2){
            tail = dummy;
            start = dummy.next;
            while(start != null){
                l = start;
                r = split(l, n);
                start = split(r, n);

                merge(l, r);
                start = nextList;
            }
            start = dummy.next;
        }


        return dummy.next;
    }
    // bottom up
    // find linkedlist size
    private ListNode getCount(ListNode head){
        int cnt = 0;
        ListNode ptr = head;
        while (ptr != null) {
            ptr = ptr.next;
            cnt++;
        }
        return cnt;
    }

    // split into 2 parts
    private ListNode split(ListNode l1, int n){
        ListNode ptr = l1;
        while(--n > 0 && ptr != null){
            ptr = ptr.next;
        }
        ListNode rest = (ptr != null) : ptr.next: null;
        if(ptr != null) ptr.next = null;
        return rest;
    }

    private void merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode();
        ListNode tail = dummy;

        // normal merge as before
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                tail.next = l1;
                l1 = l1.next;
            }
            else{
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        if(l1 != null) tail.next = l1;
    }

    //top down
    private ListNode mergeSort(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        // normal merge as before
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                tail.next = l1;
                l1 = l1.next;
            }
            else{
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        if(l1 != null) tail.next = l1;
        else tail.next = l2;

        return dummy.next;
    }

    //sample solution reference:
    ListNode tail = new ListNode();
    ListNode nextSubList = new ListNode();

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        int n = getCount(head);
        ListNode start = head;
        ListNode dummyHead = new ListNode();
        for (int size = 1; size < n; size = size * 2) {
            tail = dummyHead;
            while (start != null) {
                if (start.next == null) {
                    tail.next = start;
                    break;
                }
                ListNode mid = split(start, size);
                merge(start, mid);
                start = nextSubList;
            }
            start = dummyHead.next;
        }
        return dummyHead.next;
    }

    ListNode split(ListNode start, int size) {
        ListNode midPrev = start;
        ListNode end = start.next;
        //use fast and slow approach to find middle and end of second linked list
        for (int index = 1; index < size && (midPrev.next != null || end.next != null); index++) {
            if (end.next != null) {
                end = (end.next.next != null) ? end.next.next : end.next;
            }
            if (midPrev.next != null) {
                midPrev = midPrev.next;
            }
        }
        ListNode mid = midPrev.next;
        midPrev.next = null;
        nextSubList = end.next;
        end.next = null;
        // return the start of second linked list
        return mid;
    }

    void merge(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode();
        ListNode newTail = dummyHead;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                newTail.next = list1;
                list1 = list1.next;
                newTail = newTail.next;
            } else {
                newTail.next = list2;
                list2 = list2.next;
                newTail = newTail.next;
            }
        }
        newTail.next = (list1 != null) ? list1 : list2;
        // traverse till the end of merged list to get the newTail
        while (newTail.next != null) {
            newTail = newTail.next;
        }
        // link the old tail with the head of merged list
        tail.next = dummyHead.next;
        // update the old tail to the new tail of merged list
        tail = newTail;
    }

    int getCount(ListNode head) {
        int cnt = 0;
        ListNode ptr = head;
        while (ptr != null) {
            ptr = ptr.next;
            cnt++;
        }
        return cnt;
    }
}
