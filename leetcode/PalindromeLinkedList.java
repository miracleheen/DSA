class PalindromeLinkedList {
    ListNode middle(ListNode head){ //1 2 2 1
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode current = head;
        
        while(current != null) { // 1 2 2 1 
            ListNode temp = current.next; // 2
            current.next = prev; // 1 -> null
            prev = current; // prev = 1;
            current = temp; // current = 2;
        }

        return prev;
    }

    public boolean isPalindrome(ListNode head) {
        ListNode mid = middle(head); // 2 -> 1 
        ListNode second = reverse(mid); // 1 -> 2
        ListNode first = head;

        while(first != null && second != null){
            if(first.val != second.val) return false;
            first = first.next;
            second = second.next;
        }

        return true;
    }
}
