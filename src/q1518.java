public class q1518 {
    public static void main(String[] args) {
        System.out.println(numWaterBottles(15,4));
    }

    public static int numWaterBottles(int numBottles, int numExchange) {
        int ans = 0;
        int empty = 0;
        while(numBottles + empty >= numExchange){
            ans += numBottles;
            empty += numBottles;
            numBottles = empty / numExchange;
            empty = empty % numExchange;
        }

        return ans + numBottles;
    }
}