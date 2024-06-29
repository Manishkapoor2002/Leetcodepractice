import java.util.*;
public class q2192 {
    public static void main(String[] args) {

    }

    public static List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> ans = new ArrayList<>();
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ans.add(new ArrayList<>());
            adj.add(new ArrayList<>());
        }

        for (int[] el : edges) {
            adj.get(el[1]).add(el[0]);
        }

        for (int i = 0; i < n; i++) {
            Queue<Integer> q = new LinkedList<>();
            int[] visited = new int[n];
            visited[i] = 1;
            q.add(i);
            while(!q.isEmpty()){
                int val = q.poll();
                for(int it : adj.get(val)){
                    q.add(it);
                    ans.get(i).add(it);
                }
            }
        }


        return ans;
    }
}
