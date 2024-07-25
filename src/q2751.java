import java.util.*;

public class q2751 {
    public static void main(String[] args) {

        int[] pos = {5,4,3,2,1};
        int[] he = {2,17,9,15,10};
        System.out.println(survivedRobotsHealths(pos, he, "RRRRL"));

    }

    public static List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {


        ArrayList<Pair> list = new ArrayList<>();
        for (int i = 0; i < positions.length; i++) {
            list.add(new Pair(positions[i], healths[i], directions.charAt(i)));
        }

        list.sort((a, b) -> a.post - b.post);

        Stack<Pair> s = new Stack<>();
        s.add(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            if (s.isEmpty()) s.add(list.get(i));
            else {
                if (list.get(i).dir == 'L') {
                    int cval = list.get(i).health;
                    boolean currLive = true;

                    while (!s.isEmpty() && s.peek().dir == 'R') {
                       int sval = s.peek().health;

                        if (cval > sval) {
                            s.pop();
                            cval--;
                        } else if (cval < sval) {
                            Pair temp = s.pop();
                            currLive = false;
                            s.add(new Pair(temp.post, temp.health - 1, temp.dir));
                            break;
                        } else {
                            s.pop();
                            currLive = false;
                            break;
                        }
                    }

                    if (currLive && (s.isEmpty() || s.peek().dir == 'L')) {
                        s.add(new Pair(list.get(i).post, cval, list.get(i).dir));
                    }
                } else {
                    s.add(list.get(i));
                }
            }

        }
        List<Integer> ans = new ArrayList<>();
        HashMap<Integer,Integer> temMap = new HashMap<>();
        for (Pair p : s) {
//            ans.add(p.health);
            temMap.put(p.post,p.health);
        }

        for (int key : positions){
            if (temMap.containsKey(key)){
                ans.add(temMap.get(key));
            }
        }

        return ans;


    }

    private static class Pair {
        int post;
        int health;
        char dir;

        Pair(int post, int hlth, char dir) {
            this.post = post;
            this.health = hlth;
            this.dir = dir;
        }
    }
}