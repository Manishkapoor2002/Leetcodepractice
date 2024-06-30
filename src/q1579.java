import java.util.Arrays;
import java.util.PriorityQueue;

public class q1579 {
    public static void main(String[] args) {
        System.out.print(maxNumEdgesToRemove(4,new int[][]{{3,1,2},{3,2,3},{1,1,3},{1,2,4},{1,1,2},{2,3,4}}));

    }
    public static int maxNumEdgesToRemove(int n, int[][] edges) {
        PriorityQueue<Pair> both = new PriorityQueue<>((a,b)->a.n1 - b.n1);
        for (int[] el : edges){
            int type = el[0];
            int n1 = el[1];
            int n2 = el[2];

            if(type == 3){
                both.add(new Pair(type,n1,n2));
            }
        }

        Arrays.sort(edges,(a,b)->a[1]-b[1]);

        DSU a = new DSU(n);
        DSU b = new DSU(n);
        int ans = 0;

        while (!both.isEmpty()){
            Pair temp = both.poll();
            int n1 = temp.n1;
            int n2 = temp.n2;
            if (a.findParent(n1) != a.findParent(n2)){
                a.unionBySize(n1,n2);
                b.unionBySize(n1,n2);
            }else {
                ans++;
            }
        }

        for (int[] edge : edges) {

            int type = edge[0];
            int n1 = edge[1];
            int n2 = edge[2];

            if (type == 1) {
                if (a.findParent(n1) == a.findParent(n2)) {
                    ans++;
                } else {
                    a.unionBySize(n1, n2);
                }
            } else if (type == 2) {
                if (b.findParent(n1) == b.findParent(n2)) {
                    ans++;
                } else {
                    b.unionBySize(n1, n2);
                }
            }
        }

        int[] p = new int[2];
        for (int i = 1;i<=n;i++) {
            int n1 = a.findParent(i);
            int n2 = b.findParent(i);
            if (i == n1) p[0]++;

            if (i == n2) p[1]++;

            if(p[0] > 1 || p[1] > 1) return -1;
        }
        return ans;
    }

}
class Pair{
    int type;
    int n1;
    int n2;

    Pair(int type,int n1,int n2){
        this.type = type;
        this.n1 = n1;
        this.n2 = n2;
    }
}
class DSU{
    public int[] size;
    public int[] parent;

    DSU(int n){
        size = new int[n+1];
        parent = new int[n+1];


        for(int i = 1;i<=n;i++){
            parent[i] = i;
            size[i] = 1;
        }
    }


    public int findParent(int node){
        if(node == parent[node]) return node;
        return parent[node] = findParent(parent[node]);
    }


    public void unionBySize(int n1,int n2){
        int parentN1 = findParent(n1);
        int parentN2 = findParent(n2);

        if (parentN1 == parentN2) return;
        else if(size[parentN1] < size[parentN2]){
                parent[parentN1] = parentN2;
                size[parentN2] += size[parentN1];
        }else {
            parent[parentN2] = parentN1;
            size[parentN1] += size[parentN2];
        }
    }
}