import java.util.*;
import java.io.*;

public class Year{
    static String [] temp = {"Ox", "Tiger", "Rabbit", "Dragon", "Snake", "Horse", "Goat", "Monkey", "Rooster", "Dog", "Pig", "Rat"};
    static List<String> animals = Arrays.asList(temp);
    public static void main(String [] args){
        Scanner s = new Scanner(System.in);
        HashMap<String, String> birthYears = new HashMap<>();
        HashMap<String, Integer> birthDates = new HashMap<>();
        int n = s.nextInt();
        birthYears.put("Bessie", "Ox");
        birthDates.put("Bessie", 0);
        for (int i = 0; i < n; i++){
            String name = s.next();
            s.next();
            s.next();
            String prevNext = s.next();
            String animal = s.next();
            s.next();
            s.next();
            String relative = s.next();
            if (prevNext.equals("previous")){
                int index = animals.indexOf(birthYears.get(relative));
                int count = 0;
                while (!(temp[index].equals(animal))){
                    index--;
                    if (index < 0){
                        index += 12;
                    }
                    count++;
                }
                if (count == 0) count = 12;
                birthDates.put(name, birthDates.get(relative) - count);
                birthYears.put(name, animal);
            }
            else{
                int index = animals.indexOf(birthYears.get(relative));
                int count = 0;
                while (!(temp[index].equals(animal))) {
                    index++;
                    if (index > 11) {
                        index -= 12;
                    }
                    count++;
                }
                if (count == 0) count = 12;
                birthDates.put(name, birthDates.get(relative) + count);
                birthYears.put(name, animal);
            }
        }
        System.out.println(Math.abs((birthDates.get("Elsie"))));
    }
}