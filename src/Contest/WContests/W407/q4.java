package Contest.WContests.W407;

import java.time.chrono.MinguoDate;

public class q4 {
    public static void main(String[] args) {
        System.out.println(minimumOperations(new int[]{1,3,2},new int[]{2,1,4}));
    }
    public static Long ans;
    public static long minimumOperations(int[] nums, int[] target) {
        ans = 0L;
        int i  = 0,j=0,n=target.length;
        while (i<n){
            boolean incr = false;
            if(nums[i] == target[i]) {
                i++;
                continue;
            }
            if(nums[i]  < target[i]){
                incr = true;
            }
            if(incr){
                while (i < n && nums[i] < target[i]){
                    i++;
                }
            }else {
                while (i < n && nums[i] > target[i]){
                    i++;
                }
            }

            ans += helpfn(nums,target,j,i-1,incr);
            j = i;
        }
        return ans;
    }

    static Long helpfn(int[] nums,int[] tar,int i,int j,boolean isInc){
        if(j-i == 0) return (long) Math.abs(tar[i] - nums[i]);
        long opr = 0;

        while ( i <= j){
            opr = Math.max(opr,Math.abs(tar[i]) - nums[i]);
            i++;
        }

        return opr;
    }


}