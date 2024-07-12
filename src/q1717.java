import java.util.*;

public class q1717 {
    public static void main(String[] args) {
        System.out.println(maximumGain("cdbcbbaaabab", 4, 5));

    }

    public static int maximumGain(String s, int x, int y) {

        int ans = 0;

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (x >= y) {
                if (s.charAt(i) != 'a' && s.charAt(i) != 'b') {
                    ans += helpfn(st, y);
                } else if (!st.isEmpty() && st.peek() == 'a' && s.charAt(i) == 'b') {
                    ans += x;
                    st.pop();
                } else {
                    st.add(s.charAt(i));
                }

            } else {

                if (s.charAt(i) != 'a' && s.charAt(i) != 'b') {
                    ans += helpfn(st, x);
                } else if (!st.isEmpty() && st.peek() == 'b' && s.charAt(i) == 'a') {
                    ans += y;
                    st.pop();
                } else {
                    st.add(s.charAt(i));
                }

            }
        }

        if (x >= y) {
            ans += helpfn(st, y);
        } else {
            ans += helpfn(st, x);
        }
        return ans;
    }

    static int helpfn(Stack<Character> st, int val) {
        int a = 0;
        int b = 0;

        while (!st.isEmpty()) {
            if (st.pop() == 'a')
                a++;
            else
                b++;
        }

        return Math.min(a, b) * val;
    }
}