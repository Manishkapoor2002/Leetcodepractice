package Contest.WContests.W407;

public class q3 {
    public static void main(String[] args) {
        System.out.println(maxOperations("1001101"));
    }
    public static int maxOperations(String s) {
        int cnt = 0;
        int ans = 0;


        int i = 0;
        while (i < s.length()){
            if (s.charAt(i) == '1') {
                cnt++;
                i++;
            }else{
                while (i < s.length() && s.charAt(i) == '0'){
                    i++;
                }
                ans+=cnt;
            }

        }
    return ans;
    }
}