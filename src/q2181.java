public class q2181 {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    public static void main(String[] args) {


    }

    //    approach 1 (create a new ListNode)
//    public static ListNode mergeNodes(ListNode head) {
//        if (head == null || head.next == null) return null;
//
//        ListNode ans = new ListNode(-1);
//        ListNode pointer = ans;
//
//        while (head != null) {
//            int sum = 0;
//            head = head.next;
//            while (head != null && head.val != 0) {
//                sum += head.val;
//                head = head.next;
//            }
//
//            if (sum != 0) {
//                ListNode temp = new ListNode(sum);
//                pointer.next = temp;
//                pointer = temp;
//            }
//        }
//
//        return ans.next;
//
//    }


    //    approach 2 : (without creating new List)
    public static ListNode mergeNodes(ListNode head) {

        if(head == null || head.next == null) return null;

        ListNode curr = head,prev = head,res = head;

        while(head != null){
            int sum = 0;
            head = head.next;

            while(head != null && head.val != 0){
                sum += head.val;
                head = head.next;
            }

            if(sum != 0){
                curr.val = sum;
                prev = curr;
                curr = curr.next;
            }
        }

        prev.next = null;
        return res;

    }

}



