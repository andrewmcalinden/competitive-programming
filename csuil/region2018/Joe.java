package region2018;

import java.util.*;
import java.io.*;

public class Joe {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(new File("joe.dat"));
        while(input.hasNextLine()){
            String line = input.nextLine().toUpperCase();
            Scanner currentLine = new Scanner(line);
            currentLine.useDelimiter("\\W");
            ArrayList<String> words = new ArrayList<>();
            while(currentLine.hasNext()){
                String word = currentLine.next();
                if (!words.contains(word)){
                    words.add(word.trim());
                }
            }
            Collections.sort(words, new Comp());
            for(String word : words){
                System.out.print(word + " ");
            }
            System.out.println();
            currentLine.close();
        }

    }

    private static class Comp implements Comparator<String>{
        public int compare(String s1, String s2){
            if (s1.length() == s2.length()){
                return s1.compareTo(s2);
            }
            return s1.length() - s2.length();
        }
    }
}
