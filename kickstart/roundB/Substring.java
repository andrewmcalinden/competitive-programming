import java.util.*;
import java.io.*;

public class Substring {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        for (int run = 1; run <= t; run++) {
            int n = input.nextInt();
            String s = input.next();
            int [] ans = new int[n];
            for (int i = 0; i < n; i++){
                int length = 1;
                char last = s.charAt(i);
                for (int j = i - 1; j >= 0; j--){
                    char current = s.charAt(j);
                    if (current >= last){
                        break;
                    }
                    length++;
                    last = current;
                }
                ans[i] = length;
            }
            System.out.print("Case #" + run + ": ");
            for (int i = 0; i < n; i++){
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }
}
