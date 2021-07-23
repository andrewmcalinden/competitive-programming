package invA2020;

import java.util.*;
import java.io.*;

public class Lukas {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("lukas.dat"));

        Scanner line = new Scanner(input.nextLine());
        line.useDelimiter(",");
        HashSet<String> banned = new HashSet<>();
        while(line.hasNext()){
            banned.add(line.next());
        }
        banned.add("true");
        banned.add("false");
        banned.add("null");

        int runs = input.nextInt();
        //System.out.println(runs);
        input.nextLine();

        for (int run = 1; run <= runs; run++) {

            String name = input.next();
            //System.out.println(name);
            String startS = "" + name.charAt(0);
            char start = name.charAt(0);
            if (!(startS.equals("_") || startS.equals("$") || ('A' <= start) && (start <= 'Z') || ('a' <= start) && (start <= 'z'))){
                System.out.println("Invalid");
                continue;
            }

            boolean stop = false;
            inner:
            for (int i = 0; i < name.length(); i++){
                String current = "" + name.charAt(i);
                if (!(current.matches("[\\w]") || current.equals("$"))){
                    System.out.println("Invalid");
                    stop = true;
                    break inner;
                }
            }

            if (stop) continue;

            if (banned.contains(name)){
                System.out.println("Invalid");
                continue;
            }

            System.out.println("Valid");
        }
    }
}
