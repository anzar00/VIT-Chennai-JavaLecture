package com.vitchennai;

// Imports for our demos
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// Imports for our DevConnect App
import com.vitchennai.models.Post;
import com.vitchennai.models.User;
import com.vitchennai.services.DevConnectService;

public class LectureDemo {

    public static void main(String[] args) throws InterruptedException {
        // This is your main control panel.

        // Uncomment the below methods one by one. Start with ActI to show the problem.
        // runActI_TheProblem();

        // Then, comment out Act I and uncomment this one.
        // runActII_Generics();

        // Then, comment out Act II and uncomment this one.
        // runActII_ListPerformance();

        // Finally, comment out the performance demo and uncomment this one.
        // runActIII_DevConnectApp();
    }

    // -----------------------------------------------------------------
    // ACT I: THE PROBLEM
    // -----------------------------------------------------------------
    public static void runActI_TheProblem() {
        System.out.println("--- Act I: The 'Flexible' but DANGEROUS Object Array ---");

        // "Let's use our OOP knowledge. Everything is an Object, right?"
        Object[] mixedBag = new Object[3];
        mixedBag[0] = 95;            // An Integer
        mixedBag[1] = 88;            // Another Integer
        mixedBag[2] = "Good Job!";   // A String! (The mistake)

        System.out.println("Array created. Compiler is happy.");
        
        try {
            int totalScore = 0;
            for (Object item : mixedBag) {
                // "To use it, we are forced to cast..."
                totalScore += (Integer) item; // The time bomb!
            }
            System.out.println("Total Score: " + totalScore);
        } catch (ClassCastException e) {
            System.out.println("\nBOOM! Runtime Crash:");
            System.out.println("Error: " + e.getMessage());
            System.out.println("This is what we must prevent!");
        }
    }

    // -----------------------------------------------------------------
    // ACT II, Scene 1: GENERICS
    // -----------------------------------------------------------------
    public static void runActII_Generics() {
        System.out.println("\n--- Act II, Scene 1: Generics (The Safety Net) ---");

        // "Now, let's use Generics."
        List<Integer> safeScores = new ArrayList<>();
        safeScores.add(95);
        safeScores.add(88);

        // "Now, watch. The moment we try to make the same mistake..."
        // safeScores.add("Good Job!"); // <-- UNCOMMENT THIS LIVE
        
        // "VS Code gives an immediate compile-time error! This is so much better."
        // (After seeing the error, delete or re-comment the line)

        int totalScore = 0;
        for (Integer score : safeScores) {
            // "And look! No cast needed. It's clean and 100% type-safe."
            totalScore += score;
        }
        System.out.println("Safe Total Score: " + totalScore);
    }

    // -----------------------------------------------------------------
    // ACT II, Scene 2: LIST PERFORMANCE
    // -----------------------------------------------------------------
    public static void runActII_ListPerformance() {
        System.out.println("\n--- Act II, Scene 2: ArrayList vs. LinkedList ---");
        int size = 100000; // 100k items

        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        System.out.println("Testing insertion at the *beginning* (slow for ArrayList)...");

        long startTime = System.nanoTime();
        for (int i = 0; i < size; i++) {
            arrayList.add(0, i); // Very slow! O(n) for each add
        }
        long endTime = System.nanoTime();
        System.out.println("  ArrayList (add at start):  " + (endTime - startTime) / 1_000_000 + "ms");

        startTime = System.nanoTime();
        for (int i = 0; i < size; i++) {
            linkedList.add(0, i); // Very fast! O(1) for each add
        }
        endTime = System.nanoTime();
        System.out.println("  LinkedList (add at start): " + (endTime - startTime) / 1_000_000 + "ms");
    }


    // -----------------------------------------------------------------
    // ACT III: THE DEVCONNECT APP
    // -----------------------------------------------------------------
    public static void runActIII_DevConnectApp() throws InterruptedException {
        System.out.println("\n--- Act III: Running DevConnect ---");
        DevConnectService devConnect = new DevConnectService();

        // 1. Create Users (adds to the Map)
        devConnect.createUser("Anzar");
        devConnect.createUser("Rahul");

        // 2. Add Posts (looks up in Map, adds to List)
        System.out.println("\nPosting activity...");
        Thread.sleep(500); // Simulate time
        devConnect.addPost("Anzar", "Just started my lecture at VIT!");
        Thread.sleep(500);
        devConnect.addPost("Rahul", "Welcome to VIT, Anzar!");
        Thread.sleep(500);
        devConnect.addPost("Anzar", "We are building the DevConnect app live!");

        // 3. Display Feeds (looks up in Map, iterates List)
        devConnect.displayUserFeed("Anzar");
        devConnect.displayUserFeed("Rahul");
        devConnect.displayUserFeed("Dinesh"); // Test unknown user
    }
}