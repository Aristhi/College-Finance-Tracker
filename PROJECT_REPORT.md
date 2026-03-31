Approach & Methodology
The Plan: 
The project was developed as a Desktop GUI Application using the Java Swing framework. I followed a "Data-First" approach for the development of this project. Initially, I established how to represent a single expense (the Expense object) and then I built the file-handling logic to ensure that the data isn't lost when the program closes and then finally, I wrapped it in a user-friendly and simple graphical interface.
System Architecture: 
The application follows a Modular Design:
Data Model (Expense.java): A dedicated class that encapsulates expense details (amount, category, and date).
GUI Layer (FinanceTracker.java): Built using JFrame and BorderLayout to organize inputs at the top, a dynamic JTable in the middle, and summary statistics at the bottom.
Persistence Layer: Uses FileWriter and Scanner to read/write to a local expenses.txt file, ensuring the user's budget history is preserved between sessions.
Tech Stack:
Java SE (Standard Edition): For core logic and Object-Oriented structure.
Java Swing & AWT: For the graphical user interface components.
Java Time API (LocalDate): To handle modern date formatting and month-based filtering.
File I/O: For flat-file database management.
Key Decisions & Design Choices
Encapsulation:
 By creating a separate Expense class with private fields and public getters, I tried to make sure that the data remains consistent and protected from accidental modifications from outside of the class logic.
User Interface (UI) Aesthetics: 
I modified the default grey Java look by changing the colour palette and creating  a Custom Color Palette (lightBlueBG, headerBlue, successGreen, dangerRed). This makes this application more modern, better looking and engaging, while keeping it simple at the same time for college students.
Data Portability: 
I chose a comma-separated format for the expenses.txt file. This allows  students to easily open their data in external softwares like Excel or Notepad, if they need a raw backup.

Challenges Faced
Challenge 1: Real-time UI Synchronization. 
The Problem: Ensuring the "Total Spent" label and the JTable updated immediately after adding or deleting a row.
The Solution:
 I created a centralized calculateTotal() method and linked it to the ActionListener of both the Add and Delete buttons, making sure that the interface always reflects the current state of the ArrayList.
Challenge 2: Input Robustness.
The Problem:  A user entering a word in the "Amount" field or a typo in the "Date" field would normally crash a Java program.
The Solution: 
I implemented Exception Handling (try-catch blocks) that catches NumberFormatException and DateTimeParseException, which provides the user with a helpful JOptionPane message instead of crashing the app.
Lessons Learned
Object-Orientation Understanding: 
This project improved my understanding of how to manage a collection of objects (ArrayList<Expense>) and sync them with a visual UI component (DefaultTableModel).
Effective File Handling: 
I learned how to parse Strings back into Objects (using Double.parseDouble and LocalDate.parse) which is actually a fundamental skill when working with applications that work on data storage.
User-Centric Design: 
By including student-specific categories like "Mess/Canteen" and "Stationary”, Also, I included the Rupee sign instead of the usual Dollar, we find in various applications available online. I learned that software is most effective when it is tailored to a specific audience’s needs.

