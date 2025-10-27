package com.vitchennai;

// Imports for our theory demos
import java.util.HashMap;
import java.util.Map;

public class WarmUp {

    // --- Helper classes for OOP Recap ---
    //  "Let's create a class 'Animal'. A class is just a blueprint."
    static class Animal {
        String name;

        public Animal(String name) {
            this.name = name;
        }

        public void eat() {
            System.out.println(name + " is eating.");
        }
    }

    //  "Now let's create a 'Dog' class that 'extends' Animal."
    static class Dog extends Animal {
        public Dog(String name) {
            super(name); // Calls the parent constructor
        }

        // Method Overriding
        @Override
        public void eat() {
            System.out.println(name + " (a dog) is eating happily.");
        }

        public void bark() {
            System.out.println("Woof! Woof!");
        }
    }
    // --- End of OOP helper classes ---


    // --- Helper class for Generics Theory ---
    //  "Let's build our own simple generic class, a 'Box'."
    static class Box<T> { // 'T' (for Type) is a placeholder
        private T content;

        public void set(T content) {
            this.content = content;
        }

        public T get() {
            return content;
        }
    }
    // --- End of Generics helper class ---


    // --- Main method for all our warm-ups ---
    public static void main(String[] args) {
        
        // You can run these sections one by one by uncommenting them,
        // or just code them live from top to bottom.
        
        runBasicSyntaxRecap();
        runOOPRecap();
        runGenericsTheory();
        runMapTheory();
    }

    // -----------------------------------------------------------------
    // 1. BASIC SYNTAX RECAP
    // -----------------------------------------------------------------
    public static void runBasicSyntaxRecap() {
        System.out.println("--- 1. Basic Syntax Recap ---");
        
        //  "We have variables to store data..."
        String message = "Hello VIT!";  // String variable
        int studentCount = 100;         // int variable

        //  "...and loops to repeat actions."
        System.out.println("Basic 'for' loop:");
        for (int i = 1; i <= 3; i++) {
            System.out.println("  Count: " + i);
        }

        //  "...and methods to organize code."
        sayHello("Anzar"); // Calling a method
    }

    // Helper method for the recap
    public static void sayHello(String name) {
        System.out.println("Hello, " + name + "! Welcome to the lecture.");
    }


    // -----------------------------------------------------------------
    // 2. OOP RECAP
    // -----------------------------------------------------------------
    public static void runOOPRecap() {
        System.out.println("\n--- 2. OOP Recap ---");
        
        //  "A class is a blueprint (like 'Dog'). An object is an instance (like 'buddy')."
        Dog buddy = new Dog("Buddy"); // We create an object
        buddy.eat();
        buddy.bark();

        //  "Because Dog 'extends' Animal, a Dog IS-A Animal. This is Inheritance."
        Animal myPet = buddy; // This is Polymorphism
        myPet.eat(); // It calls the Dog's 'eat' method!

        //  "And *everything* in Java, even our 'Dog', IS-A Object."
        Object someObject = buddy;
        System.out.println("Object's default toString(): " + someObject.toString());
    }


    // -----------------------------------------------------------------
    // 3. GENERICS THEORY (Our own <T>)
    // -----------------------------------------------------------------
    public static void runGenericsTheory() {
        System.out.println("\n--- 3. Generics Theory (Our own Box<T>) ---");

        //  "Let's use our generic 'Box' class. I'll make one for a String."
        Box<String> stringBox = new Box<>();
        stringBox.set("This is a text.");
        // stringBox.set(123); // <-- UNCOMMENT THIS to see
        //  "The compiler stops me! This is type safety."
        System.out.println("String Box contains: " + stringBox.get());

        //  "And I can re-use the *same* Box class for an Integer."
        Box<Integer> intBox = new Box<>();
        intBox.set(100);
        System.out.println("Integer Box contains: " + intBox.get());
    }


    // -----------------------------------------------------------------
    // 4. MAP THEORY
    // -----------------------------------------------------------------
    public static void runMapTheory() {
        System.out.println("\n--- 4. Map Theory (Key-Value Directory) ---");

        //  "A Map is like a dictionary. It holds key-value pairs."
        // We use Generics: Map<String, Integer>
        Map<String, Integer> studentGrades = new HashMap<>();

        //  "We use 'put' to add data. The key is 'Anzar', the value is 95."
        studentGrades.put("Anzar", 95);
        studentGrades.put("Dinesh", 90);
        studentGrades.put("Aditya", 88);

        //  "The real power is 'get'. We get a value instantly by its key."
        Integer anzarGrade = studentGrades.get("Anzar");
        System.out.println("Anzar's Grade: " + anzarGrade);

        //  "We can also check for keys."
        System.out.println("Do we have a grade for 'Sivakami'? " + studentGrades.containsKey("Sivakami"));

        //  "And we can iterate over it."
        System.out.println("All grades:");
        for (String studentName : studentGrades.keySet()) {
            System.out.println("  " + studentName + ": " + studentGrades.get(studentName));
        }
    }
}