package ui;

import model.TypingTest;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class TypingApp {
    private Scanner input;
    private TypingTest test;
    private Boolean isRunning;
    private int curTestType;

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
        curTestType = Integer.parseInt(command);
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

        System.out.println("\n\n\n\nYour test will begin in 3 seconds \n\n");
        for (int i = 3; i > 0; i--) {
            System.out.println(i);
            TimeUnit.SECONDS.sleep(1);
        }

        String[] testWords = test.getWords();

        for (int i = 0; i < testWords.length; i++) {
            if ((i) % 10 == 0) {
                System.out.print("\n" + testWords[i] + " ");
            } else {
                System.out.print(testWords[i] + " ");
            }
        }

        test.setStartTime(System.currentTimeMillis());

        input = new Scanner(System.in);
        test.setRawInput(input.nextLine());
        test.setEndTime(System.currentTimeMillis());
        test.setTypedWords(test.getRawInput().split(" "));

        test.updateStats();

        double accuracy = test.getAccuracy();
        double grossWPM = test.getGrossWPM();
        double netWPM = test.getNetWPM();
        double elapsedTime = test.getElapsedTime();

        System.out.println("You finished in " + elapsedTime + " seconds! \n");
        System.out.println("Your gross WPM was: " + grossWPM + "!\n");
        System.out.println("Your net WPM was: " + netWPM + "!\n");
        System.out.printf("Accuracy: %.2f", accuracy);

        System.out.println("");
        boolean returnToMenu = false;
        while (!returnToMenu) {
            System.out.println("Enter 'm' to return to the menu");
            System.out.println("Enter 'r' to do another test of the same type!");
            String temp = input.next();
            if (temp.equals("m")) {
                returnToMenu = true;
            }
            if(temp.equals("r")) {
                returnToMenu = true;
                handleInput(Integer.toString(curTestType));
            }
        }
    }
}
