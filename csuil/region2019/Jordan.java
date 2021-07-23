package region2019;

import java.io.*;
import java.util.*;

public class Jordan {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("jordan.dat"));
        int runs = input.nextInt();
        input.nextLine();
        for (int run = 1; run <= runs; run++) {
            Scanner line = new Scanner(input.nextLine());
            long num1 = Long.parseLong(line.next(), 17);
            long num2 = Long.parseLong(line.next(), 17);
            long check = Long.parseLong(line.next(), 17);

            ArrayList<Long> seq = new ArrayList<>();
            seq.add(num1);
            seq.add(num2);

            boolean print = false;
            while (seq.get(seq.size() - 1) < check){
                seq.add(seq.get(seq.size() - 2) + seq.get(seq.size() - 1));
                if (seq.get(seq.size() - 1) == check){
                    System.out.println(seq.size());
                    print = true;
                    break;
                }
            }

            if (!print){
                long last2 = seq.get(seq.size() - 2);
                long last1 = seq.get(seq.size() - 1);

                String b171 = Long.toString(last2, 17);
                String b172 = Long.toString(last1, 17);

                System.out.println(b171.toUpperCase() + " " + b172.toUpperCase());
            }
        }
    }
}
