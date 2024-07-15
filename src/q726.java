import com.sun.source.tree.Tree;

import java.awt.image.ImageProducer;
import java.util.*;
public class q726 {
    public static void main(String[] args) {
        System.out.println(countOfAtoms("K4(ON(SO3)2)2"));
    }
    public static String countOfAtoms(String formula) {
        Stack<HashMap<String, Integer>> s = new Stack<>();

        s.add(new HashMap<>());
        int i = 0;


        while(i < formula.length()) {

            if (formula.charAt(i) == '(') {
                s.add(new HashMap<>());
                i++;
            } else if (formula.charAt(i) == ')') {
                HashMap<String,Integer> temp = s.pop();
                i++;
                StringBuilder num = new StringBuilder();
                while (i<formula.length() && Character.isDigit(formula.charAt(i))){
                    num.append(formula.charAt(i));
                    i++;
                }
                if (num.length() > 0) {
                    int n = Integer.parseInt(num.toString());
                    temp.replaceAll((k, v) -> v * n);
                }
                for (String key : temp.keySet()){
                    s.peek().put(key,s.peek().getOrDefault(key,0) + temp.get(key));
                }
            } else {
                StringBuilder str = new StringBuilder();
                str.append(formula.charAt(i));
                i++;
                while (i<formula.length() && Character.isLowerCase(formula.charAt(i))){
                    str.append(formula.charAt(i));
                    i++;
                }

                StringBuilder num = new StringBuilder();
                while (i<formula.length() && Character.isDigit(formula.charAt(i))){
                    num.append(formula.charAt(i));
                    i++;
                }

                int cnt = num.length() > 0? Integer.parseInt(num.toString()):1;
                s.peek().put(str.toString(),s.peek().getOrDefault(str.toString(),0)+cnt);

            }
        }

        TreeMap<String ,Integer> resMap = new TreeMap<>(s.peek());
        StringBuilder res = new StringBuilder();
        for (String word : resMap.keySet()){
            res.append(word);
            int cnt = resMap.get(word);
            if(cnt > 0) res.append(cnt);
        }

        return res.toString();
    }


}