package misc;

import java.util.Scanner;

public class Josefa {
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        for (int run = 0; run < n; run++){
            int num = input.nextInt();
            String bin = Integer.toBinaryString(num);
            if (bin.length() > 8){ //negative
                System.out.println(num + " = " + "1" + bin.substring(bin.length() - 7, bin.length()));
            }
            else{
                int rep = 8 - bin.length();
                String mid = "";
                for (int i = 0; i < rep; i++){
                    mid += "0";
                }
                String ans = mid + bin;
                System.out.println(num + " = " + ans);
            }
        }
    }
}