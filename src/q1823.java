import java.util.*;

public class q1823 {
    public static void main(String[] args) {

        System.out.println(findTheWinner(5,2));

    }
    public static int findTheWinner(int n, int k) {
//        Approach 1:
//        Queue<Integer> q = new LinkedList<>();
//        for(int i = 1;i<=n;i++ ) q.add(i);
//
//
//        while(q.size() != 1){
//            int i = 1;
//            while(i < k){
//                i++;
//                int temp = q.poll();
//                q.add(temp);
//            }
//
//            q.poll();
//        }
//
//        return q.peek();



//        Approach 2:
//        ArrayList<Integer> list = new ArrayList<>();
//        for(int i = 1;i<=n;i++) list.add(i);
//        int i = 0;
//        while(n != 1){
//            int rm = (i + k-1)%list.size();
//            i = rm;
//            n--;
//            list.remove(rm);
//        }
//
//        return list.get(0);

//        Approach 3:
//        Deque<Integer> dq = new LinkedList<>();
//        for(int i = 1;i<=n;i++) dq.add(i);
//
//        while (dq.size() != 1){
//            int i = 1;
//            while (i<k){
//                int temp = dq.pollFirst();
//                dq.addLast(temp);
//                i++;
//            }
//            dq.pollFirst();
//        }
//
//        return dq.peekFirst();
//        Approach 4:
//        return helpfn(n,k)+1;

        //Approach 5:
        int ans = 0;
        for(int i = 1;i<=n;i++){
            ans = (ans + k) % i;
        }
        return ans + 1;
    }

//    static int helpfn(int n,int k){
//        if(n == 1) return 0;
//        int ans = helpfn(n-1,k);
//        return (ans+k)%n;
//    }
}