import java.util.*;

public class q2196 {
    public static void main(String[] args) {

    }

    public TreeNode createBinaryTree(int[][] descriptions) {
        // HashMap<Integer, TreeNode> map = new HashMap<>();
        // HashMap<Integer, Integer> inOrder = new HashMap<>();

        // for (int[] el : descriptions) {
        //     if (!map.containsKey(el[0])) {
        //         TreeNode temp = new TreeNode(el[0]);
        //         map.put(el[0], temp);
        //         inOrder.put(el[0], 0);
        //     }
        //     if (!map.containsKey(el[1])) {
        //         TreeNode temp = new TreeNode(el[1]);
        //         map.put(el[1], temp);
        //         inOrder.put(el[1], 0);
        //     }

        //     if (el[2] == 0) {
        //         map.get(el[0]).right = map.get(el[1]);
        //     } else {
        //         map.get(el[0]).left = map.get(el[1]);
        //     }

        //     inOrder.put(el[1], inOrder.get(el[1]) + 1);

        // }
        // TreeNode root = new TreeNode(-1);
        // for (int key : map.keySet()) {
        //     if (inOrder.get(key) == 0) {
        //         root = map.get(key);
        //         break;
        //     }
        // }

        // return root;

        HashMap<Integer, int[]> map = new HashMap<>();
        HashMap<Integer, Integer> inOrder = new HashMap<>();

        for (int[] el : descriptions) {
            if (!map.containsKey(el[0])) {
                map.put(el[0], new int[] { -1, -1 });
            }

            map.get(el[0])[el[2]] = el[1];
            if (!inOrder.containsKey(el[0]))
                inOrder.put(el[0], 0);

            inOrder.put(el[1], inOrder.getOrDefault(el[1], 0) + 1);
        }

        TreeNode root = new TreeNode(-1);

        for (int key : inOrder.keySet()) {
            if (inOrder.get(key) == 0) {
                System.out.println(key);
                root.val = key;
            }
        }

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while (!q.isEmpty()) {
            TreeNode temp = q.poll();
            int val = temp.val;

            if (map.containsKey(val)) {
                int[] arr = map.get(val);
                if (arr[0] != -1) {
                    TreeNode r = new TreeNode(arr[0]);
                    temp.right = r;
                    q.add(r);
                }

                if (arr[1] != -1) {
                    TreeNode l = new TreeNode(arr[1]);
                    temp.left = l;
                    q.add(l);
                }
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