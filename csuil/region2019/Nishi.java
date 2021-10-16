package region2019;

import java.io.*;
import java.util.*;

public class Nishi {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("nishi.dat"));
        int runs = input.nextInt();
        input.nextLine();
        for (int run = 1; run <= runs; run++) {
            String snum1 = input.next();
            String operation = input.next();
            String snum2 = input.next();

            double num1 = Double.parseDouble(snum1);
            double num2 = Double.parseDouble(snum2);

            double fullDecimal = 0;
            if (operation.equals("X")){
                fullDecimal = num1 * num2;
            }
            else{
                fullDecimal = num1 / num2;
            }

            int numSigFigs = Math.min(getSigFigs(snum1), getSigFigs(snum2));
            //System.out.println(numSigFigs);
            String s = String.format("%." + (numSigFigs - 1) + "E", fullDecimal);
            String ans = "";
            int index = 0;
            for (int i = 0; i < s.length(); i++){
                if (s.charAt(i) == '+') {
                    index = i;
                    break;
                }
                ans += s.charAt(i);
            }

            for (int i = index + 2; i < s.length(); i++){
                ans += s.charAt(i);
            }

            //System.out.printf("%." + (numSigFigs - 1) + "E", fullDecimal);
            System.out.println(ans);
        }
    }

    public static int getSigFigs(String num){
        if (num.charAt(0) == '-'){
            num = num.substring(1);
        }
        String sNum = "" + num;
        //no decimal point
        if ((sNum).matches("\\d+")){
            int numZero = 0;
            int ans = 0;
            for (char c : sNum.toCharArray()){
                if (c == '0'){
                    numZero++;
                }
                else{
                    ans++;
                    ans += numZero;
                    numZero = 0;
                }
            }
            return ans;
        }
        else{
            int i = 0;
            while (true){
                if (sNum.charAt(i) == '0'){
                    //dp 
                }
                else if (sNum.charAt(i) == '.'){
                    //decimal = true;
                }
                else{
                    break;
                }
                i++;
            }
            String better = sNum.substring(i);
            if (better.contains(".")){
                return better.length() - 1;
            }
            return better.length(); //-1 for decimal point
        }
    }
}
