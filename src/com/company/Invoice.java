package com.company;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Invoice {

    private String userName;
    private String userAddress;
    private String userNumber;

    private double sessionCost;
    private double questionCost;
    private double questionAsked;

    public Invoice() {
    }

    public Invoice(String userName, String userAddress, String userNumber) {
        this.userName = userName;
        this.userAddress = userAddress;
        this.userNumber = userNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }

    public double getSessionCost() {
        return sessionCost;
    }

    public void setSessionCost(double sessionCost) {
        this.sessionCost = sessionCost;
    }

    public double getQuestionCost() {
        return questionCost;
    }

    public void setQuestionCost(double questionCost) {
        this.questionCost = questionCost;
    }

    public double getQuestionAsked() {
        return questionAsked;
    }

    public void setQuestionAsked(double questionAsked) {
        this.questionAsked = questionAsked;
    }

    public void inputUser(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome. Please enter your information");
        System.out.print("Name: ");
        setUserName(scanner.nextLine());
        System.out.print("Address: ");
        setUserAddress(scanner.nextLine());
        System.out.print("Phone Number: ");
        setUserNumber(scanner.nextLine());
    }

    public void displayInvoice(int size){

        DecimalFormat df = new DecimalFormat("0.00");
        DecimalFormat dfz = new DecimalFormat("#");

        setQuestionAsked(size);
        setQuestionCost(.35);
        setSessionCost(100.00);


        double questionTotal = getQuestionAsked() * getQuestionCost();
        double totalCost = questionTotal + getSessionCost();

        System.out.println("Raven's Invoice");
        System.out.println("To:");
        System.out.println(getUserName());
        System.out.println(getUserAddress());
        System.out.println(getUserNumber() + "\n");
        System.out.println("Items:");
        System.out.println("Quantity | Description | Price | Total");
        System.out.println("\t1 \t\t Session \t$" + df.format(getSessionCost()) + " $" + df.format(getSessionCost()));
        System.out.println("\t" + dfz.format(getQuestionAsked()) + " \t\tQuestions \t$" + df.format(getQuestionCost()) + "\t$" + df.format(questionTotal));
        System.out.println("\nTotal Due: $" + df.format(totalCost));
        System.out.println("\nThank you for doing business with Raven.\n");
    }

}
