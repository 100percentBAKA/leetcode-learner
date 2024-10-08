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
    public ListNode oddEvenList(ListNode head) {
        if(head==null|| head.next==null) return head;
        ListNode p=head;
        ListNode temp=p.next;
        ListNode head2=p.next;
        ListNode c=head;
        int count=1;
        while(c.next!=null){
            count++;
            c=c.next;
        }
        ListNode prev=null;
        while(p.next!=null){
            p.next=temp.next;
            prev=p;
            p=temp;
            temp=temp.next;
        }
        if(count%2==0) prev.next=head2;
        else p.next=head2;
        return head;
    }
}