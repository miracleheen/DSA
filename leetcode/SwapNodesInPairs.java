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
class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode current = dummy;
        while(current.next != null && current.next.next != null){//curr -> 1 -> 2 -> * 
            ListNode first = current.next; //1
            ListNode second = current.next.next;//2
            first.next = second.next;//1 -> 3
            second.next = first; // 2 -> 1 
            current.next = second;// null -> 2
            current = first; // current = 1
        }
        
        return dummy.next;
    }
}
