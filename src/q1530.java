import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class q1530 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {

    }

//    1st Approach(Brute Force):

//public static int ans;
//    public static HashSet<temp.TreeNode> done;
//
//    public static int countPairs(temp.TreeNode root, int distance) {
//        ans = 0;
//        HashSet<temp.TreeNode> leafNodes = new HashSet<>();
//        HashMap<temp.TreeNode, temp.TreeNode> map = new HashMap<>();
//        done = new HashSet<>();
//
//        Queue<temp.TreeNode> q = new LinkedList<>();
//        q.add(root);
//        map.put(root,null);
//
//        while (!q.isEmpty()){
//            temp.TreeNode par = q.poll();
//            if(par.left != null){
//                q.add(par.left);
//                map.put(par.left,par);
//            }
//
//            if(par.right != null){
//                q.add(par.right);
//                map.put(par.right,par);
//            }
//        }
//
//        fn(root,leafNodes);
//
//        for(temp.TreeNode leaf : leafNodes){
//            dfs(leaf,new temp.TreeNode(-1),distance,0,map,leafNodes);
//            done.add(leaf);
//        }
//        return ans;
//    }
//
//    static void fn(temp.TreeNode root, HashSet<temp.TreeNode> set){
//        if(root.left == null && root.right == null){
//            set.add(root);
//        }
//
//        if(root.left != null) fn(root.left,set);
//        if(root.right != null) fn(root.right,set);
//    }
//
//    static void dfs(temp.TreeNode root, temp.TreeNode prev, int dist, int curr, HashMap<temp.TreeNode, temp.TreeNode> map, HashSet<temp.TreeNode> set){
//        if(dist < curr) return;
//
//        if(set.contains(root) && curr != 0 && dist >= curr && !done.contains(root)){
//            ans++;
//        }
//
//        if(map.containsKey(root) && map.get(root) != null && map.get(root) != prev){
//            dfs(map.get(root),root,dist,curr+1,map,set);
//        }
//
//        if(root.left != null && root.left != prev){
//            dfs(root.left,root,dist,curr+1,map,set);
//        }
//
//        if(root.right != null && root.right != prev){
//            dfs(root.right,root,dist,curr+1,map,set);
//        }
//
//
//    }
//

    //    2nd Approach (Optimized soln):
    int res;

    public int countPairs(TreeNode root, int distance) {
        res = 0;
        dfs(root, distance);
        return res;
    }

    public int[] dfs(TreeNode root, int dist) {
        if (root == null) {
            return new int[dist + 1];
        }

        if (root.left == null && root.right == null) {
            int[] temp = new int[dist + 1];
            temp[1] = 1;
            return temp;
        }

        int[] left = dfs(root.left, dist);
        int[] right = dfs(root.right, dist);

        for (int i = 1; i <= dist; i++) {
            for (int j = 0; j <= (dist - i); j++) {
                if ((i + j) <= dist) {
                    res += left[i] * right[j];
                } else {
                    break;
                }
            }
        }

        int[] parent = new int[dist + 1];

        for (int i = 1; i <= dist; i++) {
            parent[i] = left[i - 1] + right[i - 1];
        }

        return parent;
    }

}