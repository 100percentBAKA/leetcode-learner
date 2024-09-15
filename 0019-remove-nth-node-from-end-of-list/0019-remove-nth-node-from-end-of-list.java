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
    static ListNode reverse(ListNode head) {
        ListNode current = head;
        ListNode prev = null;
        ListNode nextNode = null;

        while(current != null) {
            nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        return prev;
    }

    static ListNode get(int index, ListNode head) {
        ListNode current = head;
        while(index-- > 0) {
            current = current.next;
        }

        return current;
    }

    static ListNode deleteFront(ListNode head) {
        if(head == null) {
            return null;
        }
        head = head.next;

        return head;
    }

    static ListNode deleteRear(ListNode head) {
        if(head == null) {
            return null;
        }

        if(head.next == null) {
            return deleteFront(head);
        }
        
        ListNode current = head;
        ListNode prev = null;

        while(current.next != null) {
            prev = current;
            current = current.next;
        }

        prev.next = null;

        return head;
    }

    static int calcLen(ListNode head) {
        ListNode current = head;
        int size = 0;

        while(current != null) {
            current = current.next;
            size++;
        }

        return size;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode rev = reverse(head);

        if(n == 1) {
            rev = deleteFront(rev);
            return reverse(rev);
        }

        if(n == calcLen(rev)) {
            rev = deleteRear(rev);
            return reverse(rev);
        }

        ListNode prev = get(n - 2, rev);
        ListNode nextNode = get(n, rev);

        prev.next = nextNode;

        // System.out.println(calcLen(head));
        
        // now rev is our new head
        // head = deleteRear(head);
        return reverse(rev);
    }
}