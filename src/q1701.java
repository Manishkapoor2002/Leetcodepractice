public class q1701 {
    public static void main(String[] args) {

    }

    public double averageWaitingTime(int[][] arr) {
        int n = arr.length;
        double ans = 0;
        long waitTime = 0;
        int time = arr[0][0];

        for (int[] el : arr) {
            if (time < el[0]) {
                time = el[0];
            }
            time += el[1];
            waitTime += time - el[0];
        }
        ans = (double) waitTime/n;
        return ans;

    }
}