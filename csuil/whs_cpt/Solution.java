package whs_cpt;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException{
        Scanner input = new Scanner(new File("input.dat"));
        ArrayList<Ticket> good = new ArrayList<>();
        ArrayList<Ticket> bad = new ArrayList<>();

        Ticket t = new Ticket();
        boolean date = false;
        boolean name = false;
        boolean price = false;
        boolean room = false;
        input.nextLine();
        while (input.hasNextLine()) {
            String line = "";
            while (!line.trim().matches("[*]+")) {
                line = input.nextLine();
                Scanner currentLine = new Scanner(line);
                currentLine.useDelimiter("\\s|\\*");
                while (currentLine.hasNext()) {
                    String word = currentLine.next();
                    if (word.contains("date")) {
                        date = true;
                        int index = word.indexOf("date") + 5;
                        Scanner s = new Scanner(word.substring(index));
                        s.useDelimiter("=>");
                        t.year = s.nextInt();
                        t.month = s.nextInt();
                        t.day = s.nextInt();
                    }

                    else if (word.contains("name")) {
                        name = true;
                        Scanner s = new Scanner(word.substring(5));
                        s.useDelimiter(",");
                        String last = s.next();
                        String first = s.next();
                        t.name = first + " " + last;
                    }

                    else if (word.contains("room")) {
                        room = true;
                        int roomNumber = Integer.parseInt(word.substring(5));
                        t.room = roomNumber;
                    }

                    else if (word.contains("price")) {
                        price = true;
                        int priceAmount = Integer.parseInt(word.substring(7));
                        t.price = priceAmount;
                    }
                }
            }
            if (date && name && price && room) {
                good.add(t);
            } else {
                bad.add(t);
            }
            date = false;
            name = false;
            price = false;
            room = false;

            t = new Ticket();
        }

        System.out.println(good.size() + " " + bad.size());

        Collections.sort(good);
        Collections.sort(bad);

        for (Ticket t1 : good) {
            System.out.println(t1);
        }

        for (Ticket t1 : bad) {
            System.out.println(t1);
        }
    }

    private static class Ticket implements Comparable<Ticket> {
        public int year;
        public int month;
        public int day;
        public String name;
        public int room = -1;
        public int price = -1;

        public String toString() {
            String date = "N/A";
            if (year > 0) {
                date = String.format("%04d", year) + String.format("%02d", month) + String.format("%02d", day);
            }

            String priceString = "N/A";
            if (price > 0) {
                priceString = "" + price;
            }

            String roomString = "N/A";
            if (room > 0) {
                roomString = "" + room;
            }

            String nameString = "N/A";
            if (name != null) {
                nameString = name;
            }

            return date + "-" + nameString + "-" + priceString + "-" + roomString;
        }

        public int compareTo(Ticket other) {
            if (other.year == 0 && year != 0) {
                return 1;
            } else if (other.year != 0 && year == 0) {
                return -1;
            } else if (other.year != 0 && year != 0) {
                String date = String.format("%04d", year) + String.format("%02d", month) + String.format("%02d", day);
                String otherDate = String.format("%04d", other.year) + String.format("%02d", other.month)
                        + String.format("%02d", other.day);
                if (date.compareTo(otherDate) != 0){
                    return date.compareTo(otherDate);
                }
            }

            // if get to here, neither year was valid, move on
            if (other.name == null && name != null) {
                return 1;
            } else if (other.name != null && name == null) {
                return -1;
            } else if (other.name != null && name != null) {
                // System.out.println(name + " " + other.name);
                // System.out.println(name.compareTo(other.name));
                if (name.compareTo(other.name) != 0){
                    return name.compareTo(other.name);
                }
            }

            if (other.price == -1 && price != -1) {
                return 1;
            } else if (other.price != -1 && price == -1) {
                return -1;
            } else if (other.price != -1 && price != -1) {
                if (other.price != price)
                return other.price - price;
            }

            if (other.room == -1 && room != -1) {
                return 1;
            } else if (other.room != -1 && room == -1) {
                return -1;
            } else if (other.room != -1 && room != -1) {
                return other.room - room;
            }
            return 0;
        }
    }
}