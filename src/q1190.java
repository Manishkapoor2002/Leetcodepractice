import java.util.*;
public class q1190 {
    public static void main(String[] args) {

        System.out.println(reverseParentheses("(ed(et(oc))el)"));

    }

    public static String reverseParentheses(String s) {
        char[] arr = new char[s.length()];
        Stack<Integer> st = new Stack<>();
        int pt = 0;

        for(int i = 0;i<s.length();i++){
            if(s.charAt(i) == '('){
                st.add(pt);
            }else if(s.charAt(i) == ')'){
                int j = st.pop();
                helpfn(arr,j,pt-1);
            }else{
                arr[pt] = s.charAt(i);
                pt++;
            }
        }


        StringBuilder ans = new StringBuilder();

        for(int i = 0;i<pt;i++) ans.append(arr[i]);

        return ans.toString();

    }

    static void helpfn(char[] arr,int i,int j){
        while(i<j){
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}