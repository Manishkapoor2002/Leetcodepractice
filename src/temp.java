import java.io.BufferedReader;
import java.util.*;
import java.util.stream.*;

public class temp{
    public static void main(String[] args){
        System.out.println(minWindow("ADOBECODEBANC","ABC"));

    }
    public static String minWindow(String s, String t) {

        if(t.length() > s.length()) return "";


        String[] res = new String[1];
        int resLen = Integer.MAX_VALUE;

        HashMap<Character,Integer> map = new HashMap<>();
        HashMap<Character,Integer> clone = new HashMap<>();


        for(int i = 0;i<t.length();i++){
            char ch = t.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        int j =0;
        for(int i =0;i<s.length();i++){
            char curr = s.charAt(i);
            if(map.containsKey(curr)) clone.put(curr,clone.getOrDefault(curr,0)+1);
            if(map.containsKey(curr)){
                while(clone.get(curr) > map.get(curr)){
                    if(map.containsKey(s.charAt(j))){
                        clone.put(s.charAt(j),clone.get(s.charAt(j))-1);
                        if(clone.get(s.charAt(j)) == 0) clone.remove(s.charAt(j));
                    }
                    j++;
                }
            }
            while(map.equals(clone)){
                if(resLen > (i-j+1)){
                    resLen = i-j+1;
                    res[0] = s.substring(j,i+1);
                }
                if(map.containsKey(s.charAt(j))){
                    clone.put(s.charAt(j),clone.get(s.charAt(j))-1);
                    if(clone.get(s.charAt(j)) == 0) clone.remove(s.charAt(j));
                }
                j++;
            }
        }


        return res[0];

    }

}