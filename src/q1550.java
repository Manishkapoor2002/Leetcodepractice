public class q1550 {
    public static void main(String[] args) {

        System.out.print(threeConsecutiveOdds(new int[]{1,2,34,3,4,5,7,23,12}));

    }
    public static boolean threeConsecutiveOdds(int[] arr) {
        int n = arr.length;
        if(n < 3) return false;

        for(int i = 0;i<n-2;i++){
            if(arr[i] % 2 != 0 && arr[i+1] % 2 != 0 && arr[i+2] % 2 != 0) return true;
        }

        return false;

    }
}
