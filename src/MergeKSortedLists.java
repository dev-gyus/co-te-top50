import java.util.PriorityQueue;

public class MergeKSortedLists {
    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode[] list = new ListNode[3];
        list[0] = l1;
        list[1] = l2;
        list[2] = l3;

        ListNode result = mergeKLists(list);
        while(result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists){
        //1
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a,b) -> {
            return a.val - b.val;
        });
        ListNode newHead = new ListNode(0);
        ListNode p = newHead;
        for(ListNode node : lists){
            if(node != null){
                queue.offer(node);
            }
        }

        //2
        while(!queue.isEmpty()){
            ListNode node = queue.poll();
            p.next = node;
            p = p.next;
            if(node.next != null){
                queue.offer(node.next);
            }
        }
        return newHead.next;
    }
}
