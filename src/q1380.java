import java.util.*;
public class q1380 {
    public static void main(String[] args) {

    }

    public List<Integer> luckyNumbers (int[][] nums) {
        int n = nums.length;
        int m = nums[0].length;
        int[] colMax = new int[m];

        for(int i = 0;i<m;i++){
            int max = -1;
            for(int j = 0;j<n;j++){
                max = Math.max(nums[j][i],max);
            }
            colMax[i] = max;
        }
        List<Integer> ans = new ArrayList<>();
        for(int i = 0;i<n;i++){
            int min = fn(nums[i]);
            for(int j = 0;j<m;j++){
                if(min == nums[i][j] && colMax[j] == nums[i][j]) ans.add(nums[i][j]);
            }
        }
        return ans;

    }

    static int fn(int[] nums){
        int min = Integer.MAX_VALUE;
        for(int el : nums) min = Math.min(el,min);
        return min;
    }
}