package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        RavenEliza eliza = new RavenEliza();

        String input = "";
        ArrayList<String> chatHistory = new ArrayList<>();

        System.out.print("Good day. What is your problem?\n");

        //loops until user inputs (q) to quit
        while (!input.equalsIgnoreCase("q")) {
            //prompts user for input
            System.out.println("Enter your response here or Q to quit: ");
            Scanner scanner = new Scanner(System.in);
            input = scanner.nextLine();

            //if input doesn't equal (q) then run through methods to convert it to Raven's Response
            //save input/response in the chatHistory ArrayList
            if (!input.equalsIgnoreCase("q")) {
                chatHistory.add(eliza.question(input));
            }

        }
        //after user input (q) display all of the past inputs/responses
        System.out.println("\nChat History:\n");
        for (String history : chatHistory){
            System.out.println(history);
        }

        if (eliza.overallMood(0) > 0){
            System.out.println("You are an overall positive person.");
        } else if (eliza.overallMood(0) < 0) {
            System.out.println("You are an overall negative person.");
        } else {
            System.out.println("You have no over mood.");
        }
    }
}
