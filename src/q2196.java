import java.util.*;

public class q2196 {
    public static void main(String[] args) {

    }

    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer, TreeNode> map = new HashMap<>();
        HashMap<Integer, Integer> inOrder = new HashMap<>();

        for (int[] el : descriptions) {
            if (!map.containsKey(el[0])) {
                TreeNode temp = new TreeNode(el[0]);
                map.put(el[0], temp);
                inOrder.put(el[0], 0);
            }
            if (!map.containsKey(el[1])) {
                TreeNode temp = new TreeNode(el[1]);
                map.put(el[1], temp);
                inOrder.put(el[1], 0);
            }

            if (el[2] == 0) {
                map.get(el[0]).right = map.get(el[1]);
            } else {
                map.get(el[0]).left = map.get(el[1]);
            }

            inOrder.put(el[1], inOrder.get(el[1]) + 1);

        }
        TreeNode root = new TreeNode(-1);
        for (int key : map.keySet()) {
            if (inOrder.get(key) == 0) {
                root = map.get(key);
                break;
            }
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