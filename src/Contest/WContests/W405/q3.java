package Contest.WContests.W405;

import java.util.*;

public class q3 {

    private static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {

        System.out.println(numberOfSubmatrices(new char[][]{
                {'.', '.', '.'},
                {'.', 'X', 'X'},
                {'Y', '.', '.'},
                {'X', '.', '.'}
        }));


    }

    public static int numberOfSubmatrices(char[][] grid) {
        int n = grid.length, m = grid[0].length;
        Pair[] arr = new Pair[m];

        if (grid[0][0] == 'X') {
            arr[0] = new Pair(1, 0);
        } else if (grid[0][0] == 'Y') {
            arr[0] = new Pair(0, 1);
        } else {
            arr[0] = new Pair(0, 0);
        }

        int ans = 0;

        for (int i = 1; i < m; i++) {
            int x = arr[i - 1].x;
            int y = arr[i - 1].y;

            if (grid[0][i] == 'X') {
                x = x + 1;
            } else if (grid[0][i] == 'Y') {
                y = y + 1;
            }
            arr[i] = new Pair(x, y);
            if (x >= 1 && x == y) ans++;
        }


        for (int i = 1; i < n; i++) {
            Pair[] temp = new Pair[m];
            Pair[] dp = new Pair[m];
            for (int j = 0; j < m; j++) {
                if (j == 0) {
                    if (grid[i][j] == 'X') {
                        temp[j] = new Pair(1, 0);
                    } else if (grid[i][j] == 'Y') {
                        temp[j] = new Pair(0, 1);
                    } else {
                        temp[j] = new Pair(0, 0);
                    }
                } else {
                    int x = temp[j - 1].x;
                    int y = temp[j - 1].y;

                    if (grid[i][j] == 'X') {
                        x++;
                    } else if (grid[i][j] == 'Y') {
                        y++;
                    }
                    temp[j] = new Pair(x, y);
                }

                int x = arr[j].x + temp[j].x;
                int y = arr[j].y + temp[j].y;
                dp[j] = new Pair(x,y);
                if(x>=1 && x == y) ans++;
            }
            arr = dp;
        }

        return ans;

    }


}