public class q1605 {
    public static void main(String[] args) {

    }
    public static int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int n = rowSum.length;
        int m = colSum.length;
        int[][] ans = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (rowSum[i] == 0) {
                    break;
                } else {
                    int min = Math.min(rowSum[i], colSum[j]);
                    ans[i][j] = min;
                    rowSum[i] -= min;
                    colSum[j] -= min;
                }
            }
        }

        return ans;

    }
}