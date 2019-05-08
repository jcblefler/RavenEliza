package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class RavenEliza {

    private int moodMeter = 0;





    public int getMoodMeter() {
        return moodMeter;
    }

    public void setMoodMeter(int moodMeter) {
        this.moodMeter = moodMeter;
    }

    public String positiveHedge() {
        Random random = new Random();

        ArrayList<String> positive = new ArrayList<String>();

        //add Strings to the ArrayList
        positive.add("Really! Why, tell me more!");
        positive.add("That sounds great! Continue!");
        positive.add("Super! What else!");

        //creates a random number based on the size of the ArrayList
        int ranNum = random.nextInt(positive.size());
        //returns a random string from the ArrayList
        return positive.get(ranNum);

    }

    public String negativeHedge() {
        Random random = new Random();

        ArrayList<String> negative = new ArrayList<String>();

        //add Strings to the ArrayList
        negative.add("I am so happy for you...Yay...");
        negative.add("That sounds...great...");
        negative.add("Super...why are you still talking to me?");

        //creates a random number based on the size of the ArrayList
        int ranNum = random.nextInt(negative.size());
        //returns a random string from the ArrayList
        return negative.get(ranNum);

    }

    public String neutralHedge() {
        Random random = new Random();

        ArrayList<String> neutral = new ArrayList<String>();

        //Add Strings to the ArrayList
        neutral.add("Meh.");

        //creates a random number based on the size of the ArrayList
        int ranNum = random.nextInt(neutral.size());
        //returns a random string from the ArrayList
        return neutral.get(ranNum);

    }


    //takes in what the user inputs and runs the input through the other methods
    public String question(String input){

        //returns the generated response
        return response(wordReplacer(input), input);

    }

    //method to change (I, me, my, am) into (you, you, your, are)
    public ArrayList<String> wordReplacer(String input) {
        //create an ArrayList to put the input string into
        ArrayList<String> words = new ArrayList<String>();

        //ensures the ArrayList is empty, when function loops it will have previous input, this wipes it out
        words.clear();

        //takes the input String, takes each word and puts the word into the ArrayList
        //each word is a separate variable inside ArrayList
        for (String inputs : input.split(" ")) {
            words.add(inputs);
        }

        //for each word in ArrayList check if its (I, me, my, am) & change that word to (you, you, your, are)
        for (int i = 0; i < words.size(); i++) {
            if (words.get(i).equalsIgnoreCase("i")) {
                words.set(i, "you");
            } else if (words.get(i).equalsIgnoreCase("me")) {
                words.set(i, "you");
            } else if (words.get(i).equalsIgnoreCase("my")) {
                words.set(i, "your");
            } else if (words.get(i).equalsIgnoreCase("am")) {
                words.set(i, "are");
            }
        }

        //return ArrayList of converted words
        return words;

    }

    public int overallMood( int n){

        setMoodMeter(getMoodMeter() + n);
        return getMoodMeter();
    }

    //method to check if user input matches words in positive or negative Arrays
    public String moodCounter(ArrayList<String> words) {
        //positive Array
        String[] positive = {"good", "glad", "happy", "relaxed", "accomplished", "alert", "creative"};
        //negative Array
        String[] negative = {"bad", "sad", "tired", "angry", "anxious", "hungry", "moody", "afraid", "mad"};
        //counters to count the number of matching words
        int positiveCounter = 0;
        int negativeCounter = 0;


        //for each word in the ArrayList
        for (String word : words) {
            //Check if word matches any word in positive Array
            for (String p : positive) {
                //if word matches a word in the positive Array then add one to positive counter
                if (word.equalsIgnoreCase(p)) {
                    positiveCounter++;
                    overallMood(1);
                }
            }
            //Check if word matches any word in negative Array
            for (String n : negative) {
                //if word matches a word in the negative Array then add one to negative counter
                if (word.equalsIgnoreCase(n)) {
                    negativeCounter++;
                    overallMood(-1);
                }
            }
        }

        //return a hedge based on amount of keywords
        //if less positive words, return positive response
        if (positiveCounter < negativeCounter) {
            return positiveHedge();
        }
        //if more positive words, return negative response
        else if (negativeCounter < positiveCounter){
            return negativeHedge();
        }
        //if positive words = negative words, return neutral response
        else {
            return neutralHedge();
        }
    }

    //method to change the first char in response to Uppercase
    public String upperCaseFirst(String value) {

        char[] array = value.toCharArray();
        array[0] = Character.toUpperCase(array[0]);
        return new String(array);
    }

    //method to take converted input and add it to Raven's response
    public String response(ArrayList<String> words, String input) {

        String response = "";
        //take each word from the input ArrayList and put them all together in a String
        for (String word : words) {
            response += word + " ";
        }
        //remove the space behind the last word
        response = response.substring(0, response.length()-1);
        //take the response 'with Uppercase first letter' and concatenate it with a Raven mood response
        response = upperCaseFirst(response) + ". " + moodCounter(words);



        //prints Raven's response
        System.out.println(response);


        //Returns to Main
        return chatHistory(input, response);
    }

    //method for past inputs and responses
    public String chatHistory(String input, String response) {

        String history = "The user said: " + input + "\n" + "Raven responded: " + response + "\n\n";

        return history;
    }

}
