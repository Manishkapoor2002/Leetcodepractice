import java.util.*;

public class q2392 {
    public static void main(String[] args) {
        int[][] row = {{1, 2},{2,3},{3,1} ,{2, 3}};
        int[][] col = {{2, 1}};
        int[][] ans = buildMatrix(3, row, col);
        for (int[] el : ans){
            for (int e: el) System.out.print(e +" ");
        }
        System.out.println();
    }

    public static int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        ArrayList<HashSet<Integer>> row = new ArrayList<>();
        ArrayList<HashSet<Integer>> col = new ArrayList<>();
        for (int i = 0; i <= k; i++) {
            row.add(new HashSet<>());
            col.add(new HashSet<>());
        }
        for (int[] el : rowConditions) {
            row.get(el[0]).add(el[1]);
        }
        for (int[] el : colConditions) {
            col.get(el[0]).add(el[1]);
        }

                if (!isCyclic(k+1, row)) return new int[0][0];

                if (!isCyclic(k+1, col)) return new int[0][0];

        HashMap<Integer,Integer> ro = topoSort(k+1,row);
        HashMap<Integer,Integer> co = topoSort(k+1,col);
        int[][] ans = new int[k][k];
        for(int i = 1;i<=k;i++){
            int r = ro.get(i);
            int c = co.get(i);
            ans[r][c] = i;
        }

        return ans;

    }

    private static boolean checkCycle(int node,  ArrayList<HashSet<Integer>> adj, int vis[], int dfsVis[]) {
        vis[node] = 1;
        dfsVis[node] = 1;

        for(Integer neighbor: adj.get(node)) {
            if(vis[neighbor] == 0) {
                if(checkCycle(neighbor, adj, vis, dfsVis) == true) {
                    return true;
                }
            } else if(dfsVis[neighbor] == 1) {
                return true;
            }
        }
        dfsVis[node] = 0;
        return false;
    }

    public static boolean isCyclic(int N, ArrayList<HashSet<Integer>> adj) {
        int vis[] = new int[N];
        int dfsVis[] = new int[N];

        for(int i = 0;i<N;i++) {
            if(vis[i] == 0) {
                if(checkCycle(i, adj, vis, dfsVis) == true) return true;
            }
        }
        return false;
    }

    static void dfs(int node, int[] vis, Stack<Integer> st,
                    ArrayList<HashSet<Integer>> adj) {
        vis[node] = 1;
        for (int it : adj.get(node)) {
            if (vis[it] == 0)
                dfs(it, vis, st, adj);
        }
        st.push(node);
    }


    static HashMap<Integer,Integer> topoSort(int V, ArrayList<HashSet<Integer>> adj) {
        int[] vis = new int[V];
        Stack<Integer> st = new Stack<Integer>();
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                dfs(i, vis, st, adj);
            }
        }

        HashMap<Integer,Integer> map = new HashMap<>();
        int i = 0;
        while (!st.isEmpty()) {
            map.put(i,st.pop());
            i++;
        }

        return map;
    }
}
