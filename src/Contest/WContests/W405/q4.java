
//TLE 😔😔😔😔😔😔😔😔😔
package Contest.WContests.W405;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class q4 {
    public static void main(String[] args) {
        System.out.println(minimumCost("abcdef",new String[]{"abdef","abc","d","def","ef"},new int[]{100, 1, 1, 10, 5}));

    }
    public static int minimumCost(String target, String[] words, int[] costs) {
        HashSet<String> set = new HashSet<>(Arrays.asList(words));
        HashMap<String,Integer> map = new HashMap<>();
        for (int i = 0;i<costs.length;i++){
            if(!map.containsKey(words[i])){
                map.put(words[i],costs[i]);
            }else {
                int min = Math.min(map.get(words[i]),costs[i]);
                map.put(words[i],min);
            }
        }
        int n = target.length();
        int[]dp = new int[n+1];
        for(int i = n-1;i>=0;i--){
            StringBuilder temp = new StringBuilder();
            int min = Integer.MAX_VALUE;
            for (int j = i;j<target.length();j++){
                temp.append(target.charAt(j));
                if(set.contains(temp.toString())){
                    int cost = map.get(temp.toString()) + dp[j+1];
                    if(cost>=0) min = Math.min(min,cost);
                }
            }

         dp[i] =  min;
        }


        int ans =  dp[0];
        if(ans == Integer.MAX_VALUE) return -1;
        else return ans;
    }
//    static int fn(int i,String target,HashSet<String> set,int[] dp,HashMap<String,Integer> map){
//        if (i == target.length()) return 0;
//
//        if(dp[i] != -1) return dp[i];
//        StringBuilder temp = new StringBuilder();
//        int min = Integer.MAX_VALUE;
//        for (int j = i;j<target.length();j++){
//            temp.append(target.charAt(j));
//            if(set.contains(temp.toString())){
//                int cost = map.get(temp.toString()) + fn(j+1,target,set,dp,map);
//                if(cost>=0) min = Math.min(min,cost);
//            }
//        }
//
//        return dp[i] =  min;
//    }
}