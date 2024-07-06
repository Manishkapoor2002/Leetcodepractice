package Contests.Biweekly.BW134;
import java.util.Arrays;

public class q2 {
    public static void main(String[] args) {

    }
    public static long maximumPoints(int[] enemyEnergies, int currentEnergy) {
        if (currentEnergy == 0)
            return 0;

        Arrays.sort(enemyEnergies);
        int i = 0, j = enemyEnergies.length - 1;
        long ans = 0;
        while (i <= j) {
            if (currentEnergy >= enemyEnergies[i]) {
                ans += currentEnergy / enemyEnergies[i];
                currentEnergy = currentEnergy % enemyEnergies[i];
            } else {
                currentEnergy += enemyEnergies[j];
                j--;
            }
        }

        return ans;
    }
}