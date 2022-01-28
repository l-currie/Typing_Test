package ui;

import Model.TypingTest;

import java.util.Scanner;

public class TypingApp {
    private Scanner input;
    private TypingTest test;
    private Boolean isRunning;

    public TypingApp() throws InterruptedException {
        isRunning = true;
        input = new Scanner(System.in);

        String command;
        while (isRunning) {
            displayMenu();
            command = input.next();

            if (command.equals("Q") || command.equals("q")) {
                isRunning = false;
            } else {
                handleInput(command);
            }
        }
    }

    public void displayMenu() {
        System.out.println("Hi!  Please select which typing test you would like to take!");
        System.out.println("\t 1 -> 5 random words");
        System.out.println("\t 2 -> 15 random words");
        System.out.println("\t 3 -> 30 random words");
        System.out.println("\t 4 -> ? random words");
        System.out.println("\t 5 -> Short Premade");
        System.out.println("\t 6 -> Medium Premade");
        System.out.println("\t 7 -> Long Premade");
        System.out.println("\t Q ->  quit app");
    }

    public void handleInput(String command) throws InterruptedException {
        if (command.equals("1")) {
            doRandom(5);
        } else if (command.equals("2")) {
            doRandom(15);
        } else if (command.equals("3")) {
            doRandom(30);
        } else if (command.equals("4")) {
            System.out.println("Please enter the number of words for the test");
            int numWords = Integer.parseInt(input.next());
            doRandom(numWords);
        } else if (command.equals("5")) {
            doPhrase("short");
        } else if (command.equals("6")) {
            doPhrase("medium");
        } else if (command.equals("7")) {
            doPhrase("long");
        }
    }

    public void doRandom(int numWords) throws InterruptedException {
        test = new TypingTest(numWords);
        runTest();
    }

    public void doPhrase(String mode) throws InterruptedException {
        test = new TypingTest(mode);
        runTest();
    }

    public void runTest() throws InterruptedException {
        test.runTest();

        System.out.println("");
        boolean returnToMenu = false;
        while (!returnToMenu) {
            System.out.println("Enter 'm' to return to the menu");
            String temp = input.next();
            if (temp.equals("m")) {
                returnToMenu = true;
            }
        }
    }
}
