package misc;

import java.util.*;
import java.io.*;

public class Botan {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("misc/botan.dat"));

        int loops = input.nextInt();
        input.nextLine();
        for (int loop = 1; loop <= loops; loop++) {
            int num = input.nextInt();
            if (isBotanPrime(num)){
                System.out.println("Case #" + loop + ": " + "BOTAN-PRIME");
            }
            else{
                System.out.println("Case #" + loop + ": " + "NOT BOTAN-PRIME");

            }
        }
    }

    public static boolean isPrime(int num){
        if (num == 1 || num == 0) return false;
        for (int div = 2; div < Math.sqrt(num); div++){
            if (num % div == 0){
                return false;
            }
        }
        return true;
    }

    public static boolean isBotanPrime(int num){
        String stringNum = "" + num;
        if (stringNum.length() == 1){
            return (isPrime(num));
        }

        for (int i = 0; i < stringNum.length(); i++) {
            for (int j = i + 1; j < stringNum.length() + 1; j++) {
                int currentNum = Integer.parseInt(stringNum.substring(i, j));
                if (!(i == 0 && j == stringNum.length())) {
                    if (!isBotanPrime(currentNum)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
