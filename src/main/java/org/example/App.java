/*
 *  UCF COP3330 Fall 2021 Assignment 20 Solution
 *  Copyright 2021 Sarim Jatt
 */
package org.example;
import java.util.Scanner;
public class App {
    public static void main( String[] args ) {
        Scanner in = new Scanner(System.in);

        System.out.print("What is the order amount? ");
        float order = in.nextInt();
        in.nextLine(); // Needed to start scanning the next line for the next strings (needed it because strings need a whole line while floats don't)
        System.out.print("What state do you live in? ");
        String state = in.nextLine();

        String total;
        String tax = "0";

        if(state.equals("Wisconsin")) {
            System.out.print("What county do you live in? ");
            String county = in.nextLine();
            float total_tax = (float) 0.05 * order;
            if(county.equals("Eau Claire")) {
                total_tax = total_tax + (float) 0.005*order;
                tax = String.format("The tax is $%.2f.", total_tax);
            }
            else if(county.equals("Dunn")) {
                total_tax = total_tax + (float) 0.004*order;
                tax = String.format("The tax is $%.2f.", total_tax);
            }
            else {
                tax = String.format("The tax is $%.2f.", total_tax);
            }
            total = String.format("The total is $%.2f.", (order+total_tax));
        }
        else if(state.equals("Illinois")) {
            float total_tax = (float) 0.08 * order;
            tax = String.format("The tax is $%.2f.", total_tax);
            total = String.format("The total is $%.2f.", (order+total_tax));
        }
        else {
            total = String.format("The total is $%.2f.", order);
        }

        if(state.equals("Wisconsin") || state.equals("Illinois")) {
            String newLine = System.getProperty("line.separator");
            System.out.println(tax + newLine + total);
        }
        else {
            System.out.println(total);
        }

        in.close();
    }
}