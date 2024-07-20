package Contest.BWContests.BW135;

import java.util.HashMap;
import java.util.HashSet;

public class q2 {
    public static void main(String[] args) {


    }

    public int minimumLength(String s) {
        int  n = s.length();
        if(n < 3) return n;

        HashSet<Integer> delIdx = new HashSet<>();
        int[] left = new int[26];
        int[] right = new int[26];
        for (int i = n-1;i>=0;i--){
            right[s.charAt(i) - 'a']++;
        }

        for(int i = 0;i<n;i++){
            int curr = s.charAt(i) - 'a';
            right[curr]--;

            if(left[curr] != 0 && right[curr] != 0){
                left[curr]--;
                right[curr]--;
            }

            left[curr]++;

        }
        int ans = 0;
        for (int el : left) ans += el;

        return ans;

    }

}