public class ReverseLinkedLists {
    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);

        ListNode result = solve(l1);
        while(result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }

    public static ListNode solve(ListNode list){
        ListNode curr = list;
        ListNode prev = null;
        ListNode next = null;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
