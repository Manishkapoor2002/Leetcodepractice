package Contest.WContests.W405;

import java.util.ArrayList;
import java.util.List;

public class q2 {
    public static void main(String[] args) {

    }

    static List<String> ans = new ArrayList<>();

    public static List<String> validStrings(int n) {

        fn(0,n,"");
        return ans;
    }
    static void fn(int i,int n,String temp){
        if(i == n){
            ans.add(temp);
            return;
        }

        fn(i+1,n,temp + "1");

        if(temp.isEmpty() || temp.charAt(temp.length()-1) != '0'){
            fn(i+1,n,temp + '0');
        }

    }

}