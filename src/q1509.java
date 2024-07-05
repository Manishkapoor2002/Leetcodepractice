import java.util.Arrays;

public class q1509 {
    public static void main(String[] args) {
        int[] arr = {6,6,0,1,1,4,6};
        System.out.println(minDifference(arr));
    }

    public static int minDifference(int[] nums) {
        int n = nums.length;
        if(n<=4) return 0;
        Arrays.sort(nums);
        int len = n - 3;
        int min = Integer.MAX_VALUE;
        for(int i =0;i<=3;i++){
            int diff = nums[len+i-1] - nums[i];
            min = Math.min(diff,min);
        }
        return min;
    }
}