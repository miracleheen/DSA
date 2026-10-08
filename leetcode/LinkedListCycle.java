class LinkedListCycle {
    public boolean hasCycle(ListNode head) { 
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null){ //Алгоритм Флойда
            fast = fast.next.next;
            slow = slow.next;
            
            if(fast == slow) return true;
        }

        return false;
    }
}
