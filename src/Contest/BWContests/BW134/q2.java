package Contest.BWContests.BW134;
import java.util.Arrays;

public class q2 {
    public static void main(String[] args) {
        System.out.println(maximumPoints(new int[]{3,2,2},2));

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
                if (ans >= 1) {
                    currentEnergy += enemyEnergies[j];
                    j--;
                } else {
                    return 0;
                }

            }
        }

        return ans;
    }
}