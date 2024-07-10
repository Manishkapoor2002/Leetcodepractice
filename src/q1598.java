public class q1598 {
    public static void main(String[] args) {
        String[] arr = {"d1/","d2/","../","d21/","./"};
        System.out.println(minOperations(arr));

    }

    public static int minOperations(String[] logs) {
//approach 1:
        // Stack<String> st = new Stack<>();
        // for (int i = 0; i < logs.length; i++) {
        // String s = logs[i];
        // // x/
        // if (s.charAt(0) == '.' && s.length() == 2) {
        // continue;
        // } else if (s.charAt(0) == '.' && s.length() == 3) {
        // if (!st.isEmpty())
        // st.pop();
        // } else {
        // st.add(s);
        // }
        // }
        // return st.size();

//approach 2:
        int ans = 0;
        for (String s : logs) {
            if (s.charAt(0) == '.' && s.length() == 2) {
                continue;
            } else if (s.charAt(0) == '.' && s.length() == 3) {
                if (ans > 0)
                    ans--;
            } else {
                ans++;
            }
        }

        return ans;

    }
}