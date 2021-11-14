package misc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Josey {
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        
        for (int run = 1; run <= t; run++){
            int b = input.nextInt();

            HashMap<String, ArrayList<String>> adjList = new HashMap<>();
            for (int i = 0; i < b; i++){
                String e1 = input.next();
                String e2 = input.next();

                if (!adjList.containsKey(e1)){
                    adjList.put(e1, new ArrayList<String>());
                }
                if (!adjList.containsKey(e2)) {
                    adjList.put(e2, new ArrayList<String>());
                }

                adjList.get(e1).add(e2);
                adjList.get(e2).add(e1);
            }

            ArrayList<String> landLocked = new ArrayList<>();
            for (String key : adjList.keySet()){
                if (key.equals("OCEAN")){
                    continue;
                }
                boolean foundOcean = false;
                for (String adj : adjList.get(key)){
                    if (adj.equals("OCEAN")){
                        foundOcean = true;
                        break;
                    }
                }
                if(!foundOcean){
                    landLocked.add(key);
                }
            }

            ArrayList<String> doubly = new ArrayList<>();
            for (String country : landLocked){
                boolean dub = true;
                for (String adj : adjList.get(country)){
                    if (landLocked.indexOf(adj) == -1){
                        dub = false;
                        break;
                    }
                }
                if (dub){
                    doubly.add(country);
                }
            }

            Collections.sort(doubly);

            System.out.println("Case #" + run + ": " + doubly.size());
            for (String ans : doubly){
                System.out.println(ans);
            }
        }
        input.close();

    }
}