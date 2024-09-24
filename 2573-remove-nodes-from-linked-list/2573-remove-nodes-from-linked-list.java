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
    static ListNode reverseLL(ListNode head) {
        ListNode current = head;
        ListNode prev = null;

        while(current != null) {
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        return prev;
    }

    public ListNode removeNodes(ListNode head) {
        head = reverseLL(head);
        ListNode current = head;

        ListNode newHead = new ListNode(-1);
        ListNode newTail = newHead;

        int max = current.val;

        while(current != null) {
            if(current.val >= max) {
                newTail.next = new ListNode(current.val);
                newTail = newTail.next;

                max = current.val;
            }

            current = current.next;
        }
        
        // newHead = newHead.next;
        // current = reverseLL(newHead);

        // while(current != null) {
        //     System.out.println(current.val);
        //     current = current.next;
        // }

        return reverseLL(newHead.next);
    }
}