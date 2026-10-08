class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode current = dummy;

        ListNode p1 = list1;
        ListNode p2 = list2;
        
        while(p1 != null && p2 != null){
            if(p1.val > p2.val){
                current.next = p2;
                p2 = p2.next;
            }else{
                current.next = p1;
                p1 = p1.next;
            }

            current = current.next; //сдвигаем
        }

        if(p1 != null){
            current.next = p1;
        }

        if(p2 != null){
            current.next = p2;
        }

        return dummy.next;
    }
}
