import java.util.*;
public class q1110 {
    public static void main(String[] args) {

    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        HashSet<Integer> set = new HashSet<>();
        for (int el : to_delete)
            set.add(el);
        List<TreeNode> ans = new ArrayList<>();
        fn(root, ans, set);
        if (!set.contains(root.val))
            ans.add(root);
        return ans;
    }

    static TreeNode fn(TreeNode root, List<TreeNode> ans, HashSet<Integer> set) {
        if (root == null) {
            return null;
        }

        root.left =  fn(root.left, ans, set);

        root.right = fn(root.right, ans, set);

        if (set.contains(root.val)) {
            TreeNode tempLeft = root.left;
            TreeNode tempRight = root.right;
            root = null;
            if (tempLeft != null)
                ans.add(tempLeft);

            if (tempRight != null)
                ans.add(tempRight);

            return null;
        }

        return root;

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