# Building Flexible Java Programs (VIT Chennai Guest Lecture)

This repository contains all the live-coding examples and demonstration code for the guest lecture, "Building Flexible Java Programs with Generics, Lists, and Maps," delivered at VIT Chennai on October 27, 2025.

## About This Lecture

The goal of this session is to bridge the gap between academic OOP theory and professional, robust Java development. We explore *why* simply using `Object` is dangerous and how modern Java's core collections (Generics, Lists, and Maps) allow us to build applications that are safe, flexible, and performant.

## What's Inside

This project is intentionally simple and does not require any build tools like Maven. You can run it directly in an IDE like VS Code by following the "No build tools" project setup.

* `src/com/vitchennai/WarmUp.java`: **Part 1 of the lecture.** This file is a "theory lab" where we live-code the prerequisites (Basic Syntax, OOP, Inheritance) and demonstrate the theory behind Generics and Maps.
* `src/com/vitchennai/LectureDemo.java`: **Part 2 of the lecture.** This is the main "demo script" organized into three acts. It directly compares unsafe code with its safe, modern alternatives and includes performance tests.
* `src/com/vitchennai/models/` & `services/`: **Part 3 of the lecture.** These packages contain the complete "DevConnect" mini-application, which we build and run as the final capstone demo.
* `Building Flexible Java Programs.pdf`: The slide deck used for the presentation.

## How to Use This Repo

This project is designed to be followed along with the lecture slides (`Building Flexible Java Programs.pdf`).

The intended flow is:

1.  **Warm-up (Theory):** Open `WarmUp.java` and follow along as we cover:
    * Basic Syntax Recap
    * OOP Recap (Inheritance, Polymorphism)
    * Generics Theory (building our own `Box<T>`)
    * Map Theory (using `HashMap`)

2.  **The Main Event (Demo):** Open `LectureDemo.java`. The `main` method is a control panel. You can follow the "story" by commenting/uncommenting each `run...` method:
    * `runActI_TheProblem()`: See how `Object[]` leads to a `ClassCastException`.
    * `runActII_Generics()`: Fix the problem with `List<Integer>` and see compile-time safety.
    * `runActII_ListPerformance()`: Run the `ArrayList` vs. `LinkedList` performance duel.
    * `runActIII_DevConnectApp()`: Run the final application that combines all concepts.

Thank you for attending the session!