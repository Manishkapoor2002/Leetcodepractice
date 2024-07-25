import java.util.*;
public class q1636 {

    private static class Pair{
        int val;
        int freq;

        Pair(int val,int freq){
            this.val = val;
            this.freq = freq;
        }
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(frequencySort(new int[]{-1, 1, -6, 4, 5, -6, 1, 4, 1})));
    }



    public static int[] frequencySort(int[] nums) {

//-100 to 100: 200
        int[] freq = new int[201];
        for(int el : nums){
            int idx  = el + 100;
            freq[idx]++;
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{
            if(a.freq == b.freq){
                return -Integer.compare(a.val,b.val);
            }
            return Integer.compare(a.freq,b.freq);
        });

        for (int i = 0;i<=200;i++){
            if(freq[i] > 0){
                int fr = freq[i];
                int val = i - 100;
                pq.add(new Pair(val,fr));
            }
        }

        int i =0;

        while (i < nums.length){
            Pair temp = pq.poll();
            int val = temp.val;
            int fr = temp.freq;
            while ( fr > 0){
                nums[i++] = val;
                fr--;
            }
        }

        return nums;

    }
}