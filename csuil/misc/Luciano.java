package misc;

import java.util.*;

import java.io.*;

public class Luciano {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("misc/luciano.dat"));

        int numWords = input.nextInt();
        input.nextLine();
        String[] wordsBubble = new String[numWords];
        String[] wordsSelection = new String[numWords];
        for (int loop = 0; loop < numWords; loop++) {
            String word = input.next();
            wordsSelection[loop] = word;
            wordsBubble[loop] = word;
        }

        for (int i = 0; i < 10; i++) {
            String min = wordsSelection[i];
            int minLoc = i;
            for (int j = i + 1; j < numWords; j++) {
                if (wordsSelection[j].compareTo(min) < 0) {
                    min = wordsSelection[j];
                    minLoc = j;
                }
            }
            wordsSelection[minLoc] = wordsSelection[i];
            wordsSelection[i] = min;
        }

        for (int run = 0; run < 10; run++) {
            for (int i = numWords - 1; i >= 1; i--) {
                String word1 = wordsBubble[i];
                String word2 = wordsBubble[i - 1];

                if (word1.compareTo(word2) < 0) {
                    wordsBubble[i] = word2;
                    wordsBubble[i - 1] = word1;
                }
            }
        }

        System.out.printf("%-20s", "Selection Sort");
        System.out.print(":Bubble Sort\n");

        for (int i = 0; i < numWords; i++) {
            System.out.printf("%-20s", wordsSelection[i]);
            System.out.print(":" + wordsBubble[i]);
            System.out.println();
        }
    }
}
