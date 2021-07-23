package misc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeMap;

public class Noah {
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.nextLine();

        ArrayList<Car> order = new ArrayList<>();

        TreeMap<String, Integer> makes = new TreeMap<>();
        TreeMap<String, Integer> models = new TreeMap<>();
        TreeMap<Integer, Integer> years = new TreeMap<>();

        for (int c = 0; c < n; c++){
            String sLine = input.nextLine();
            Scanner line = new Scanner(sLine);
            line.useDelimiter(",");
            String make = line.next();
            String model = line.next();
            int year = line.nextInt();

            order.add(new Car(make, model, year));

            if (makes.containsKey(make)){
                makes.put(make, makes.get(make) + 1);
            }
            else{
                makes.put(make, 1);
            }

            if (models.containsKey(model)) {
                models.put(model, models.get(model) + 1);
            }
            else {
                models.put(model, 1);
            }

            if (years.containsKey(year)) {
                years.put(year, years.get(year) + 1);
            }
            else {
                years.put(year, 1);
            }
        }
        Collections.sort(order);

        System.out.println("---Data Sorted---");
        for (Car c : order){
            System.out.println(c);
        }

        System.out.println("\n---Make Breakdown---");
        for (String m : makes.keySet()){
            System.out.println(m + ": " + makes.get(m));
        }

        System.out.println("\n---Model Breakdown---");
        for (String m : models.keySet()) {
            System.out.println(m + ": " + models.get(m));
        }

        System.out.println("\n---Year Breakdown---");
        for (int m : years.keySet()) {
            System.out.println(m + ": " + years.get(m));
        }
    } 

    private static class Car implements Comparable<Car>{
        public String make;
        public String model;
        public int year;
        
        public Car(String make, String model, int year){
            this.make = make;
            this.model = model;
            this.year = year;
        }

        @Override
        public int compareTo(Car other){
            if (!make.equals(other.make)){
                return make.compareTo(other.make);
            }
            else if (!model.equals(other.model)){
                return model.compareTo(other.model);
            }
            else{
                return year - other.year;
            }
        }

        public String toString(){
            return make + " "+ model + " "+ year;
        }
    }
}
