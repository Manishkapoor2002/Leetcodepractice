public class q2058 {
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

    public static int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] ans = new int[2];
        ans[0] = ans[1] = -1;
        if (head == null || head.next == null)
            return ans;

        int first = -1, last = -1;

        ListNode prev = head, curr = head.next, next = curr.next;
        int i = 2;
        while (next != null) {

            if ((prev.val > curr.val && next.val > curr.val) || (prev.val < curr.val && next.val < curr.val)) {
                if (first != -1) {
                    if (ans[0] == -1) ans[0] = i - last;
                    else ans[0] = Math.min(ans[0], i - last);
                    ans[1] = i - first;
                } else {
                    first = i;
                }

                last = i;
            }

            i++;
            prev = curr;
            curr = next;
            next = next.next;
        }

        return ans;

    }
}