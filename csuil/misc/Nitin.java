package misc;

import java.util.*;
import java.io.*;

public class Nitin {
    public static void main(String [] args) throws FileNotFoundException{
        Scanner input = new Scanner(new File("nintin.dat"));

        int p = input.nextInt();

        Queue<String> dogs = new LinkedList<>();
        Queue<String> cats = new LinkedList<>();
        for (int pet = 0; pet < p; pet++){
            String name = input.next();
            String species = input.next();

            if (species.equals("D")){
                dogs.add(name);
            }
            else{
                cats.add(name);
            }
        }

        int a = input.nextInt();
        for (int person = 0; person < a; person++){
            String name = input.next();
            String species = input.next();

            if (species.equals("D")){
                if (!dogs.isEmpty()){
                    System.out.println(name + " DOG " + dogs.poll());
                }
                else{
                    System.out.println(name + " WAIT LIST DOG");
                }
            }
            else{
                if (!cats.isEmpty()) {
                    System.out.println(name + " CAT " + cats.poll());
                } else {
                    System.out.println(name + " WAIT LIST CAT");
                }
            }
        }
    }
}
