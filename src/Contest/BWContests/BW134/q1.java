package Contest.BWContests.BW134;

public class q1 {
    public static void main(String[] args) {

    }

    public static int numberOfAlternatingGroups(int[] colors) {
        if(colors.length < 3) return 0;

        int ans = 0;
        for(int i  = 0;i<colors.length;i++){
            int curr = i;
            int next = (i+1)%colors.length;
            int next2 = (i+2)%colors.length;

            if(colors[curr] == colors[next2] && colors[curr] != colors[next]) ans++;
        }

        return ans;
    }

}