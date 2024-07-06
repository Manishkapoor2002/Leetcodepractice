public class q2582 {
    public static void main(String[] args) {
        System.out.println(passThePillow(5,4));

    }

    public static int passThePillow(int n, int time) {
        if(time < n) return time+1;

        int dir = time / (n-1);
        int moreSteps = time % (n-1);

//  if the direction is from  left to right:
        if(dir % 2 == 0){
            return moreSteps + 1;
        }else{
//  if the direction is from right to left:
            return n - moreSteps;
        }
    }
}