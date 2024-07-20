package Contest.BWContests.BW135;

public class q1 {
    public static void main(String[] args) {

    }
    public String losingPlayer(int x, int y) {
        int i = 0;

        while(true){
            if(x < 1 || y < 4){
                if((i %2) == 0){
                    return "Bob";
                }else{
                    return "Alice";
                }
            }
            i++;
            x -= 1;
            y-=4;
        }

    }
}