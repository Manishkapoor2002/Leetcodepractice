import java.util.ArrayList;

public class q350 {
    public static void main(String[] args) {
        int[] a = {4,9,5};
        int[] b = {9,4,9,8,4};
       int[] ab = intersect(a,b);
       for (int e : ab) System.out.print(e);
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        int[] freq1 = new int[1001];
        int[] freq2 = new int[1001];

        for(int e : nums1){
            freq1[e]++;
        }

        for(int e : nums2){
            freq2[e]++;
        }
        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0;i<=1000;i++){
            int times = Math.min(freq1[i],freq2[i]);
            while(times > 0){
                list.add(i);
                times--;
            }
        }

        int[] ans = new int[list.size()];
        int i = 0;
        for(int e : list){
            ans[i++] = e;
        }

        return ans;

    }
}