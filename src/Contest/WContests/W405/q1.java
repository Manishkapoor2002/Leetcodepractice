package Contest.WContests.W405;

public class q1 {
    public static void main(String[] args) {
        System.out.println(getEncryptedString("dart",3));

    }

    public static String getEncryptedString(String s, int k) {
        StringBuilder ans = new StringBuilder();

        for(int i = 0;i<s.length();i++){
          int j = (i +k)%s.length();
          ans.append(s.charAt(j));
        }
        return ans.toString();
    }
}