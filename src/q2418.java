import java.util.*;
public class q2418 {

    private static class Pair{
        String name;
        int height;
        Pair(String name,int height){
            this.name = name;
            this.height = height;
        }
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortPeople(new String[]{"Mary", "John", "Emma"}, new int[]{180, 165, 170})));

    }
    public static String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        String[] result = new String[n];
        List<Pair> list = new ArrayList<>();
        for(int i = 0;i<n;i++){
            list.add(new Pair(names[i],heights[i]));
        }
        list.sort((a, b) -> b.height - a.height);

        for(int i = 0;i<n;i++) result[i] = list.get(i).name;

        return result;

    }
}