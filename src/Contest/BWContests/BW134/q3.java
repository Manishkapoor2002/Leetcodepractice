package Contest.BWContests.BW134;
import java.util.*;

public class q3 {
    public static void main(String[] args) {

    }
    public static int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        if (n < k) return 0;
        int[] arr = new int[n + k - 1];
        int i = 0;
        for (int el : colors) {
            arr[i++] = el;
        }
        int j = 0;
        while (i < arr.length) {
            arr[i++] = colors[j++];
        }
        Queue<Integer> q = new LinkedList<>();
        int ans = 0;

        for (i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) q.add(i);
        }

        for (int l = 0; l < n; l++) {
            int end = l + k - 1;

            while (!q.isEmpty() && q.peek() < l){
                q.poll();
            }

            if(q.isEmpty()) ans++;
            else if(q.peek() < end){
                l = q.poll();
            }else {
                ans++;
            }
        }

        return ans;
    }
}