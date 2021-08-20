class MyLinkedList {

    public class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val) {this.val = val;}
        ListNode(int val, ListNode next){this.val = val; this.next=next;}
    }

    ListNode head;
    ListNode tail;
    int size;
    /** Initialize your data structure here. */
    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        int i = 0;
        ListNode ptr = head;
        while(i++ < index && ptr != null) {
            System.out.println(ptr.val);
            ptr = ptr.next;
            if(ptr == null) return -1;
        }
        return ptr.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {

        if(head == null){
            head = new ListNode(val, null);
            tail = head;
        }
        else{
            head = new ListNode(val, head);
        }
        size++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if(tail == null) { addAtHead(val);}
        else{tail.next = new ListNode(val, null); tail = tail.next;}
        size++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index > size || index < 0) return;
        if(index == 0) addAtHead(val);
        else if (index == size) addAtTail(val);
        else{
            ListNode ptr = head;
            for(int i = 0; i < index - 1; i++) ptr = ptr.next;
            ListNode addNode = new ListNode(val, ptr.next);
            ptr.next = addNode;
            size++;
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index > size - 1 || index < 0) return;
        if(index == 0 && size == 1) head = tail = null;
        else if(index == 0) head = head.next;
        else { ListNode ptr = head;
            for(int i = 0; i < index - 1; i++) {ptr = ptr.next; }
            ptr.next = ptr.next.next;
            if(size == index + 1) tail = ptr;
        }
        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
