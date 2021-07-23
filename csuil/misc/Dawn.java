package misc;

import java.util.*;
import java.io.*;

public class Dawn {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("misc/dawn.dat"));

        System.out.printf("%11s", "Amount");
        System.out.printf("%37s", "Monthly");
        System.out.printf("%18s", "Total of\n");
        System.out.println("....Invested........APR......Years.......Payment.........Payments............Profit..");


        int loops = input.nextInt();
        input.nextLine();

        double totalInvested = 0;
        double totalMonthly = 0;
        double totalPayments = 0;
        double totalProfit = 0;

        for (int loop = 1; loop <= loops; loop++) {
            double amountInvested = input.nextDouble();
            totalInvested += amountInvested;
            double APR = input.nextDouble();
            double monthlyRate = APR / 1200.0;
            int years = input.nextInt();

            double monthlyPayment = (amountInvested * monthlyRate) / (1-Math.pow(1 + monthlyRate, -years * 12));
            monthlyPayment = Math.round(monthlyPayment * 100) / 100.0;
            totalMonthly += monthlyPayment;

            double totalOfPayments = monthlyPayment * 12 * years;
            totalOfPayments = Math.round(totalOfPayments * 100) / 100.0;
            totalPayments += totalOfPayments;

            double profit = totalOfPayments - amountInvested;
            profit = Math.round(profit * 100) / 100.0;
            totalProfit += profit;

            System.out.print("$");
            System.out.printf("%,12.2f", amountInvested);
            System.out.print("  |");
            System.out.printf("%8.3f", APR);
            System.out.print("%  |");
            System.out.printf("%5d", years);
            System.out.print("  |  $");
            System.out.printf("%,10.2f", monthlyPayment);
            System.out.print("  |  $");
            System.out.printf("%,12.2f", totalOfPayments);
            System.out.print("  |  $");
            System.out.printf("%,12.2f", profit);
            System.out.println();
        }
        System.out.print("$");
        System.out.printf("%,12.2f", totalInvested);
        System.out.print("  |");
        System.out.printf("%11s", "");
        System.out.print("|");
        System.out.printf("%5s", "");
        System.out.print("  |  $");
        System.out.printf("%,10.2f", totalMonthly);
        System.out.print("  |  $");
        System.out.printf("%,12.2f", totalPayments);
        System.out.print("  |  $");
        System.out.printf("%,12.2f", totalProfit);
        System.out.println();


    }
}
