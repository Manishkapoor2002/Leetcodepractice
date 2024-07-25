package Contest.BWContests.BW135;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class q3 {


    public static void main(String[] args) {
        System.out.println(minChanges(new int[]{0,11,8,9,9,4,10,8,5,7,0,2,11,12,6,5},12));
    }

    public static int minChanges(int[] nums, int k) {
        int ans = Integer.MAX_VALUE,n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
       for (int i = 0;i<n/2;i++){
           int diff = Math.abs(nums[i] - nums[n-i-1]);

       }


       while (!pq.isEmpty()){
           Pair curr = pq.poll();

            int diff = curr.val;
            boolean flag = false;
            int change = 0;

            for (int  j = 0;j<n/2;j++){
                int d = Math.abs(nums[j] - nums[n-j-1]);
                if (d != diff){
                    int v1 = nums[j];
                    int v2 = nums[n-j-1];
                    if((diff +  v1) <= k || ((v1 - diff) >=0 && v1 - diff <= k) ){
                        change++;
                    }else if((diff + v2 <= k) || ((v2 - diff >=0 )&& (v2 - diff <= k))){
                        change++;
                    }else if(diff <=k ){
                        change +=2;
                    }else{
                        flag = true;
                        break;
                    }
                }
            }

            if (!flag) {
                ans = Math.min(ans,change);
            }
       }
        return ans;

    }
}
