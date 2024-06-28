import java.util.Arrays;

public class L2285 {

    public static void main(String[] args) {
//        n = 5, roads = [[0,1],[1,2],[2,3],[0,2],[1,3],[2,4]]
        int[][] arr = {{0,1},{1,2},{2,3},{0,2},{1,3},{2,4}};
        System.out.print(maximumImportance(5,arr));
    }

//    approach 1:

//    static long maximumImportance(int n, int[][] roads) {
//        int[] in = new int[n];
//        for (int[] el : roads) {
//            int i = el[0];
//            int j = el[1];
//            in[i]++;
//            in[j]++;
//        }
//
//        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.cnt - a.cnt);
//        for(int i = 0;i<n;i++){
//            pq.add(new Pair(i,in[i]));
//        }
//
//        int[] values = new int[n];
//        int i = 0;
//        while(!pq.isEmpty()){
//            Pair temp = pq.poll();
//            int val = temp.val;
//            int cnt = temp.cnt;
//            values[val] = n-i;
//            i++;
//        }
//
//        long ans = 0;
//        for(int[] el : roads){
//            int k = el[0];
//            int j = el[1];
//            long temp = values[k] + values[j];
//            ans += temp;
//        }
//
//        return ans;
//    }

//approach 2:
    static long maximumImportance(int n, int[][] roads) {
        long[] in = new long[n];

        for (int[] el : roads) {
            int i = el[0];
            int j = el[1];
            in[i]++;
            in[j]++;
        }

        Arrays.sort(in);
        long ans = 0;
        for(int i = 0;i<in.length;i++){
            ans += (in[i] * (i+1));
        }
        return ans;
    }


}

//class Pair {
//    int val;
//    int cnt;
//
//    Pair(int val, int cnt) {
//        this.val = val;
//        this.cnt = cnt;
//    }
//}