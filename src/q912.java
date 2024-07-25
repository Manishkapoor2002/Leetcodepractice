import java.util.*;
public class q912 {
    public static void main(String[] args) {

    }
    public int[] sortArray(int[] nums) {
        int i = 0;
        int j = nums.length-1;

        merge(i,j,nums);
        return nums;
    }

    static void merge(int i,int j,int[] nums){
        if(i >= j){
            return;
        }

        int mid = (i+j)/2;

        merge(i,mid,nums);
        merge(mid+1,j,nums);

        sort(i,mid,j,nums);
    }

    static void sort(int i,int mid,int j,int[] nums){
        ArrayList<Integer> list = new ArrayList<>();

        int s = i;
        int m = mid+1;
        int e = j;

        while(s<=mid && m <= e){
            if(nums[s] < nums[m]){
                list.add(nums[s]);
                s++;
            }else{
                list.add(nums[m]);
                m++;
            }
        }
        while(s<=mid){
            list.add(nums[s]);
            s++;
        }
        while(m<=e){
            list.add(nums[m]);
            m++;
        }

        for(int el : list){
            nums[i++] = el;
        }

    }
}