import java.util.*;

public class q2096 {
    public static void main(String[] args) {

    }

    HashMap<TreeNode, TreeNode> parentMap;
    StringBuilder res;
    StringBuilder ans;

    //    public String getDirections(TreeNode root, int startValue, int destValue) {
//        parentMap = new HashMap<>();
//        res = new StringBuilder();
//        ans = new StringBuilder();
//
//        Queue<TreeNode> q = new LinkedList<>();
//        q.add(root);
//        TreeNode start = new TreeNode(-1);
//        TreeNode end = new TreeNode(-1);
//
//        while(!q.isEmpty()){
//            int size = q.size();
//
//            for(int i = 0;i<size;i++){
//                TreeNode temp = q.poll();
//                if(temp.val == startValue) start = temp;
//                if(temp.val == destValue) end = temp;
//
//                if(temp.left != null){
//                    q.add(temp.left);
//                    parentMap.put(temp.left,temp);
//                }
//                if(temp.right != null){
//                    q.add(temp.right);
//                    parentMap.put(temp.right,temp);
//                }
//            }
//
//        }
//
//        fn(start,"-1",end);
//        return ans.toString();
//    }
//
//    public void fn(TreeNode start,String dir,TreeNode end){
//        if(start == end){
//            if(ans.length() == 0 || ans.length() < res.length()){
//                ans.delete(0,ans.length());
//                ans.append(new StringBuilder(res));
//            }
//            return;
//        }
//
//        // Up:
//        if(parentMap.containsKey(start)){
//            res.append("U");
//            fn(parentMap.get(start),"U",end);
//            res.deleteCharAt(res.length()-1);
//        }
//
//
//        // left:
//
//        if(dir != "U" && start.left != null){
//            res.append("L");
//            fn(start.left,"L",end);
//            res.deleteCharAt(res.length()-1);
//
//        }
//
//        // right:
//
//        if(dir != "U" && start.right != null){
//            res.append("R");
//            fn(start.right,"R",end);
//            res.deleteCharAt(res.length()-1);
//        }
//
//        // return ";
//    }
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        HashSet<Integer> set = new HashSet<>();
        for (int el : to_delete) set.add(el);
        List<TreeNode> ans = new ArrayList<>();
        if (!set.contains(root.val)) ans.add(root);
        fn(root, ans, set);
        return ans;
    }

    static void fn(TreeNode root, List<TreeNode> ans, HashSet<Integer> set) {
        if (root == null) {
            return;
        }

        if (set.contains(root.val)) {
            TreeNode tempLeft = root.left;
            TreeNode tempRight = root.right;
            root = null;
            if (tempLeft != null && set.contains(tempLeft.val)) ans.add(tempLeft);
            if (tempRight != null && set.contains(tempRight.val)) ans.add(tempRight);
        }

        if (root.left != null) fn(root.left, ans, set);

        if (root.right != null) fn(root.right, ans, set);
    }

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


}