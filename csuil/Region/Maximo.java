package region;

import java.util.*;
import java.io.*;

class Maximo {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(new File("maximo.dat"));
        int runs = input.nextInt();
        input.nextLine();
        for (int run = 1; run <= runs; run++) {
            String lineString = input.nextLine();
            Scanner line = new Scanner(lineString.substring(3, lineString.length() - 1));
            line.useDelimiter(",");
            HashSet<Integer> set1 = new HashSet<>();
            while(line.hasNextInt()){
                set1.add(line.nextInt());
            }
            //System.out.println(set1);

            lineString = input.nextLine();
            line = new Scanner(lineString.substring(3, lineString.length() - 1));
            line.useDelimiter(",");
            HashSet<Integer> set2 = new HashSet<>();
            while (line.hasNextInt()) {
                set2.add(line.nextInt());
            }

            boolean aSubB = true;
            boolean bSubA = true;

            for (int el : set1){
                if (!set2.contains(el)){
                    aSubB = false;
                }
            }

            for (int el : set2) {
                if (!set1.contains(el)) {
                    bSubA = false;
                }
            }

            if (aSubB && bSubA){
                System.out.println("Set A is equal to Set B");
            }
            else if(aSubB){
                System.out.println("Set A is a subset of Set B");
            }
            else if(bSubA){
                System.out.println("Set B is a subset of Set A");
            }
            else{
                ArrayList<Integer> intersection = new ArrayList<>();
                for (int el : set1){
                    if (set2.contains(el)){
                        intersection.add(el);
                    }
                }

                if (intersection.size() == 0){
                    System.out.println("Neither set is a subset of the other. Their intersection is: {}");
                    
                }
                else{
                    Collections.sort(intersection);

                    System.out.print("Neither set is a subset of the other. Their intersection is: {");
                    
                    for (int i = 0; i < intersection.size() - 1; i++){
                        System.out.print(intersection.get(i) + ",");
                    }
                    System.out.print(intersection.get(intersection.size() - 1));
                    System.out.println("}");
                }

                
            }

        }
    }
}