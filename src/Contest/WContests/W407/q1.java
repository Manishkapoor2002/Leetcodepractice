package Contest.WContests.W407;

public class q1 {
    public static void main(String[] args) {

        System.out.println(minChanges(13,4));
    }

    public static int minChanges(int n, int k) {
    int ans = 0;

    for(int i = 0;i<31;i++){
        if((n %2 ) == (k %2)){
            n = n >> 1;
            k = k >> 1;
            continue;
        }else if((k%2) == 0 && (n%2) == 1 ) {
            ans++;
        } else return -1;
        n = n >> 1;
        k = k >> 1;
    }

    return ans;
    }


}