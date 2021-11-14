package region;

import java.io.*;
import java.util.*;
import static java.lang.System.*;

public class Mahesh {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("mahesh.dat"));
        int numCases = in.nextInt();
        in.nextLine();

        for (int caseN = 1; caseN <= numCases; caseN++) {
            long num = in.nextLong();
            String bits = Long.toBinaryString(num);
            bits = bits.substring(bits.length() - 11);
            while (bits.length() < 11) {
                bits = "0" + bits;
            }
            // out.println(bits);
            int offend = 0;
            int bit1 = bits.charAt(0) - '0';
            int act1 = bits.charAt(2) - '0' + bits.charAt(4) - '0' + bits.charAt(6) - '0' + bits.charAt(8) - '0'
                    + bits.charAt(10) - '0';
            act1 %= 2;
            if (bit1 != act1) {
                offend += 1;
            }
            int bit2 = bits.charAt(1) - '0';
            int act2 = bits.charAt(2) - '0' + bits.charAt(5) - '0' + bits.charAt(6) - '0' + bits.charAt(9) - '0'
                    + bits.charAt(10) - '0';
            act2 %= 2;
            if (bit2 != act2) {
                offend += 2;
            }
            int bit4 = bits.charAt(3) - '0';
            int act4 = bits.charAt(4) - '0' + bits.charAt(5) - '0' + bits.charAt(6) - '0';
            act4 %= 2;
            if (bit4 != act4) {
                offend += 4;
            }
            int bit8 = bits.charAt(7) - '0';
            int act8 = bits.charAt(8) - '0' + bits.charAt(9) - '0' + bits.charAt(10) - '0';
            act8 %= 2;
            if (bit8 != act8) {
                offend += 8;
            }
            String newStr = "";
            for (int i = 0; i < bits.length(); i++) {
                if (i == 0 || i == 1 || i == 3 || i == 7) {
                    continue;
                }
                if (i + 1 == offend) {
                    int numTemp = bits.charAt(i) - '0';
                    numTemp = 1 - numTemp;
                    newStr += numTemp;
                } else {
                    newStr += bits.charAt(i);
                }
            }
            char c = (char) Integer.parseInt(newStr, 2);
            out.print(c);
        }
        out.println();
    }
}