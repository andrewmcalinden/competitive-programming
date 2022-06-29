import java.util.*;
import java.io.*;

class Runner {
    static List<Integer> nums = Arrays.asList(1,2,3);

    public static void main(String[] args) throws FileNotFoundException {
        permutations(new ArrayList<>());
    }

    static void permutations(List<Integer> cur){
        if (cur.size() == nums.size()){
            System.out.println(cur);
            return;
        }
        for (int i = 0; i < nums.size(); i++){
            if (nums.get(i) != -1){
                int add = nums.get(i);
                cur.add(add);
                nums.set(i, -1);
                permutations(cur);
                cur.remove(cur.size() - 1);
                nums.set(i, add);
            }
        }
    }
}
