package misc;
import java.util.*;
import java.io.*;

public class Carla {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(new File("carla.dat"));
        while (s.hasNextLine()) {
            String ans = "";
            String code = s.nextLine();
            // System.out.println(code);
            String type = "" + code.charAt(0);
            switch (type) {
            case "F":
                ans += "-";
                break;
            case "D":
                ans += "d";
                break;
            case "L":
                ans += "l";
                break;
            }

            for (int i = 1; i <= 3; i++) {
                int num = Integer.parseInt("" + code.charAt(i));
                String binary = Integer.toBinaryString(num);
                int len = binary.length();
                if (len < 3) {
                    for (int j = 0; j < 3 - len; j++) {
                        binary = "0" + binary;
                    }
                }
                char first = binary.charAt(0);
                if (first == '1') {
                    ans += "r";
                } else {
                    ans += "-";
                }
                char second = binary.charAt(1);
                if (second == '1') {
                    ans += "w";
                } else {
                    ans += "-";
                }
                char third = binary.charAt(2);
                if (third == '1') {
                    ans += "x";
                } else {
                    ans += "-";
                }

            }
            System.out.println(ans);

        }
    }
}
