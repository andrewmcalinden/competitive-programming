import java.util.*;
import java.io.*;

class Kevin {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(new File("kevin.dat"));
        double totalDist = 0;
        double totalTime = 0;
        double longestDist = 0;
        double longestTime = 0;
        double fastestPace = 0;
        double shortTotalDist = 0;
        double shortTotalPace = 0;
        double medTotalDist = 0;
        double medTotalPace = 0;
        double longTotalDist = 0;
        double longTotalPace = 0;
           
        int numRuns = 0;
        while(input.hasNextLine()) {
            String line = input.nextLine();
            Scanner lineScan = new Scanner(line);
            String date = lineScan.next();
            String [] dateRay = date.split("/");
            int month = Integer.parseInt(dateRay[0]);
            int day = Integer.parseInt(dateRay[1]);
            double dist = Integer.parseInt(lineScan.next());
            String time = lineScan.next();
            String[] timeRay = time.split(":");
            double seconds = Integer.parseInt(timeRay[0]) * 3600;
            seconds += Integer.parseInt(timeRay[1]) * 60;
            seconds += Integer.parseInt(timeRay[2]);

            double pace = seconds / dist;

            totalDist += dist;
            totalTime += seconds;
            longestDist = Math.max(dist, longestDist);
            longestTime = Math.max(time, longestTime);
            fastestPace = Math.min(pace, fastestPace);

            if (dist >= 5 && dist < 10){
                shortTotalDist += dist;
                shortTotalPace += pace;
            }
            else if (dist >= 10 && dist < 42.195 / 2.0){
                medTotalDist += dist;
                medTotalPace += pace;
            }
            else if(dist >= 42.195 / 2.0){
                longTotalDist += dist;
                longTotalPace += pace;
            }
            numRuns++;
        }

        System.out.print("Total distance = ");
        System.out.printf("%.2f", totalDist);
        System.out.println();

        int hours = (int)(totalTime / 3600);
        totalTime -= hours * 3600;
        int mins = (int)(totalTime / 60);
        totalTime -= mins * 60;
        int secs = (int) (totalTime);

        System.out.println("Total time = " + hours + ":" + mins + ":" + secs);


        double avgDist = totalDist / numRuns;
        double avgTime = totalTime / numRuns;

        System.out.print("Average distance = ");
        System.out.printf("%.2f", avgDist);
        System.out.println();

        hours = (int) (avgTime / 3600);
        avgTime -= hours * 3600;
        mins = (int) (avgTime / 60);
        avgTime -= mins * 60;
        secs = (int) (avgTime);

        System.out.println("Average time = " + hours + ":" + mins + ":" + secs);

        System.out.println("Longest distance = ");
        System.out.printf("%.2f", longestDist);

        hours = (int) (longestTime / 3600);
        longestTime -= hours * 3600;
        mins = (int) (longestTime / 60);
        longestTime -= mins * 60;
        secs = (int) (longestTime);

        System.out.println("Longest time = ");
        System.out.printf("%.2f", longestTime);

        hours = (int) (fastestPace / 3600);
        fastestPace -= hours * 3600;
        mins = (int) (fastestPace / 60);
        fastestPace -= mins * 60;
        secs = (int) (fastestPace);

        System.out.println("Fastest pace = " + hours + ":" + mins + ":" + secs);

        

    }
        
}