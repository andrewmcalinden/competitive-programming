import java.util.*;
import java.io.*;

class Dryrun{
    public static void main(String [] args) throws IOException{
        Scanner input = new Scanner(new File("dryrun.dat"));
        int runs = input.nextInt();
        input.nextLine();
        for (int run = 1; run <= runs; run++){
            System.out.println("I like " + input.nextLine() + ".");
        }
    }
}