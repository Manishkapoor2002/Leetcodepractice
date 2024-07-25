package Contest.WContests.W407;

public class q2 {
    public static void main(String[] args) {
        System.out.println(doesAliceWin("sloalo"));

    }

    public static boolean doesAliceWin(String s) {

        int n = s.length();
        int i = 0;
        int v = 0;
        int turn = 0;
        while (i < n) {
            char ch = s.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')v++;

            if(turn %2 == 0 && v % 2 == 1) {
                turn++;
                v = 0;
            }else if(turn % 2 == 1 && v >=2 && v % 2 == 0) {
                turn++;
                v = 0;
            }
            i++;
        }
        return turn % 2 != 0;
    }
}