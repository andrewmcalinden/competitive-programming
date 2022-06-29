//\\wsl$\Ubuntu\home\andrew\GitHub\Competitive-Programming\hashcode\more pizza practice

import java.util.*;
import java.io.*;

public class Solution{
    private static class Customer{
        public ArrayList<String> likes = new ArrayList<>();
        public ArrayList<String> dislikes = new ArrayList<>();
    }

    private static class Ingredient{
        public ArrayList<Integer> likes = new ArrayList<>();
        public ArrayList<Integer> dislikes = new ArrayList<>();
    }

    public static void solve(String inputFile, String outputFile) throws IOException{
        Scanner s = new Scanner(new File(inputFile));
        int c = s.nextInt();

        HashMap<String, Ingredient> ingredients = new HashMap<>();
        HashMap<Integer, Customer> customers = new HashMap<>();

        for (int i = 0; i < c; i++){
            Customer cur = new Customer();

            int l = s.nextInt();
            for (int j = 0; j < l; j++){
                String name = s.next();
                cur.likes.add(name);

                if (!ingredients.keySet().contains(name)){
                    Ingredient ing = new Ingredient();
                    ing.likes.add(i);
                    ingredients.put(name, ing);
                }
                else{
                    Ingredient old = ingredients.get(name);
                    old.likes.add(i);
                    ingredients.put(name, old);
                }
            }

            int d = s.nextInt();
            for (int j = 0; j < d; j++) {
                String name = s.next();
                cur.dislikes.add(name);

                if (!ingredients.keySet().contains(name)) {
                    Ingredient ing = new Ingredient();
                    ing.dislikes.add(i);
                    ingredients.put(name, ing);
                } else {
                    Ingredient old = ingredients.get(name);
                    old.dislikes.add(i);
                    ingredients.put(name, old);
                }
            }
            customers.put(i, cur);
        }

        ArrayList<String> answer = new ArrayList<>();
        for (String ing : ingredients.keySet()){
            Ingredient cur = ingredients.get(ing);
            if (cur.likes.size() > cur.dislikes.size()){ //maybe >=
                answer.add(ing);

                for (int id : cur.dislikes){
                    //this customer won't come to the pizzeria no matter what
                    //remove all of their likes and dislikes so we don't make 
                    //descisions based on their opinion
                    Customer noVote = customers.get(id);
                    for (String rem : noVote.dislikes){
                        Ingredient badData = ingredients.get(rem);
                        badData.dislikes.remove(rem); //slow, use hashmap
                        ingredients.put(rem, badData);
                    }
                    for (String rem : noVote.likes) {
                        Ingredient badData = ingredients.get(rem);
                        badData.likes.remove(rem);
                        ingredients.put(rem, badData);
                    }
                }
            }
            else{
                for (int id : cur.likes) {
                    // this customer won't come to the pizzeria no matter what
                    // remove all of their likes and dislikes so we don't make
                    // descisions based on their opinion
                    Customer noVote = customers.get(id);
                    for (String rem : noVote.dislikes) {
                        Ingredient badData = ingredients.get(rem);
                        badData.dislikes.remove(rem); // slow, use hashmap
                        ingredients.put(rem, badData);
                    }
                    for (String rem : noVote.likes) {
                        Ingredient badData = ingredients.get(rem);
                        badData.likes.remove(rem);
                        ingredients.put(rem, badData);
                    }
                }
            }
        }

        FileWriter writer = new FileWriter(outputFile);
        writer.write(answer.size() + " ");
        for (String f : answer) {
            writer.write(f + " ");
        }
        writer.close();
        s.close();
    }

    public static void main(String [] args) throws IOException{
        solve("a_an_example.in.txt", "ans_a.out");
        solve("b_basic.in.txt", "ans_b.out");
        solve("c_coarse.in.txt", "ans_c.out");
        solve("d_difficult.in.txt", "ans_d.out");
        solve("e_elaborate.in.txt", "ans_e.out");
    }
}