package region2018;

import java.util.*;
import java.io.*;

public class Opus {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(new File("opus.dat"));
        Scanner keyInput = new Scanner(input.nextLine());
        keyInput.next();
        int loc = 1;
        String [] key = new String[41];
        while(keyInput.hasNext()){
            key[loc] = keyInput.next();
            loc++;
        }

        ArrayList<Student> [] output = new ArrayList [7];
        for (int i = 1; i < 7; i++){
            output[i] = new ArrayList<>();
        }

        while(input.hasNextLine()){
            Scanner line = new Scanner(input.nextLine());
            String first = line.next();
            String last = line.next();
            String school = line.next();
            String conf = line.next();
            double numSkipped = 0;
            double numCorrect = 0;
            int question = 1;
            while(line.hasNext()){
                String ans = line.next();
                if (ans.equals("S")){
                    numSkipped++;
                }
                else if(key[question].equals(ans)){
                    numCorrect++;
                }
                question++;
            }
            int score = (int)(numCorrect * 6 - (2 * (40 - numSkipped - numCorrect)));
            double percent = numCorrect / (40 - numSkipped);
            Student stu = new Student(first, last, score, school, percent);

            int confNumber = Integer.parseInt(conf.substring(0, 1));
            output[confNumber].add(stu);
        }

        for (int i = 1; i < 7; i++){
            if (output[i].size() != 0){
                Collections.sort(output[i]);
                System.out.println(i + "A");
                int place = 1;
                int numPrinted = 1;
                for (int j = 1; j <= output[i].size(); j++){
                    System.out.println(place + " " + output[i].get(j - 1).toString());
                    if (j > 1 && j < output[i].size()){
                        if (output[i].get(j).score == output[i].get(j - 1).score 
                        && output[i].get(j).percentage == output[i].get(j - 1).percentage){
                            place--;
                        }
                        else{
                            place = numPrinted;
                        }
                    }
                    place++;
                    numPrinted++;
                }
            }
        }
    }

    private static class Student implements Comparable<Student>{
        public String firstName;
        public String lastName;
        public int score;
        public String school;
        public double percentage;

        public Student(String fn, String ln, int sco, String sch, double percent){
            firstName = fn;
            lastName = ln;
            score = sco;
            school = sch;
            percentage = percent;
        }

        public int compareTo(Student other){
            if (score - other.score == 0){
                if (percentage < other.percentage){
                    return 1;
                }
                else if (percentage > other.percentage){
                    return -1;
                }
                else if(lastName.compareTo(other.lastName) < 0){
                    return -1;
                }
                else if(lastName.compareTo(other.lastName) > 0){
                    return 1;
                }
                else if (firstName.compareTo(other.firstName) < 0) {
                    return -1;
                } 
                else if (firstName.compareTo(other.firstName) > 0) {
                    return 1;
                }
                return 0;
            }
            return other.score - score;
        }

        public String toString(){
            return lastName + ", " + firstName + " - " + school + ": " + score;
        }
    }
}
