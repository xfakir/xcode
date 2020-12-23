package divideAndConquer;

import LinkedList.ListNode;

public class MergeKLists {
    public ListNode solution(ListNode[] lists) {
        if (lists.length == 0) return null;
        if (lists.length == 1) return lists[0];

        int length = lists.length;
        int totalRound = getRound(length);
        
        int i = 0;
        int round = 0;
        while (round < totalRound && i < length) {
            if ((int) (i+Math.pow(2,round)) > length-1) {
                round++;
                i = 0;
                continue;
            }
            lists[i] = merge(lists[i],lists[(int) (i+Math.pow(2,round))]);

            if ((int)(i + Math.pow(2,round+1)) >= length-1) {
                round++;
                i = 0;
            } else {
                i = (int) (i + Math.pow(2,round+1));
            }
        }
        return lists[0];
    }


    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode node = new ListNode(-1);
        ListNode p = node;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if (l1 != null) {
            p.next = l1;
        }
        if (l2 != null) {
            p.next = l2;
        }
        return node.next;
    }

    private int getRound(int cap) {
        int n = cap >> 1;
        int length = 0;

        while (n != 0){
            n = n >> 1;
            length ++;
        }
        int temp = 2 << length;
        return (int) (Math.log(temp)/Math.log(2));
    }

    private void print(ListNode node) {
        ListNode p = node;
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
    }

    public static void main(String[] args) {
        ListNode l11 = new ListNode(1);
        ListNode l12 = new ListNode(4);
        ListNode l13 = new ListNode(5);
        l11.next = l12;
        l12.next = l13;


        ListNode l21 = new ListNode(1);
        ListNode l22 = new ListNode(3);
        ListNode l23 = new ListNode(4);
        l21.next = l22;
        l22.next = l23;


        ListNode l31 = new ListNode(2);
        ListNode l32 = new ListNode(6);
        l31.next = l32;

        ListNode l41 = new ListNode(0);
        ListNode l42 = new ListNode(2);
        ListNode l43 = new ListNode(7);
        l41.next = l42;
        l42.next = l43;

        MergeKLists m = new MergeKLists();
        ListNode[] listNodes = {l11,l21,l31,l41};

        //m.solution(listNodes);

        System.out.println(m.getRound(6));
    }
}
