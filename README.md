# 🎓 College Student Finance Tracker 

A professional Java Desktop Application developed for college students to track, categorize, and analyze their daily expenses. This project serves as the final "Bring Your Own Project" (BYOP) Capstone submission for the VITyarthi Java Programming course.

---

## 📖 Project Overview
Financial management is a critical skill for students. This application provides a localized, lightweight solution to log daily spending in **Rupees (₹)**. It allows users to categorize expenses (such as Mess, Hostel, or Stationery) and generate specific monthly reports to help monitor spending habits and stay within a budget.

##  Key Features
- **Localized UI:** Native support for the Rupee (₹) symbol.
- **Categorized Logging:** Dropdown selection for student-specific expense categories.
- **Monthly Summary:** A dynamic filtering system to calculate total spending for any chosen month.
- **Persistent Storage:** Uses File I/O to automatically save and load data from a local `expenses.txt` file.
- **Modern Design:** A customized Java Swing interface featuring a light-blue theme and styled rounded buttons.

---

##  Environment Setup & Requirements
To set up this project locally, ensure your system meets the following specifications:

### 1. Prerequisites
- **Java Development Kit (JDK):** Version 8 or higher (JDK 17 recommended).
- **Text Editor/IDE:** Visual Studio Code (with Java Extension Pack), IntelliJ IDEA, or Eclipse.
- **Operating System:** Windows 10/11, macOS, or Linux.

### 2. Verify Java Installation
Open your terminal or command prompt and run:
```bash
java -version
If you see a version number (e.g., java version "17.0.x"), your environment is ready.

Installation & Execution (Step-by-Step)
Step 1: Clone or Download the Repository
Clone the repository using Git:

Bash
git clone [https://github.com/Aristhi/College-Finance-Tracker.git](https://github.com/Aristhi/College-Finance-Tracker.git)
cd College-Finance-Tracker
(Alternatively, download the ZIP file from GitHub and extract it to a folder).

Step 2: Compile the Source Code
The application consists of two core Java files. Compile them together to link the classes:

Bash
javac Expense.java FinanceTracker.java

Step 3: Run the Application
Execute the main class to launch the Graphical User Interface (GUI):

Bash
java FinanceTracker

 Project Structure & Configuration
FinanceTracker.java: The entry point of the app. Handles the GUI (Swing), Event Listeners, and Monthly Filtering logic.

Expense.java: The Data Model class. Encapsulates expense attributes like Date, Amount, and Category.

expenses.txt: The flat-file database. This is automatically created in the root folder upon the first successful save.

 Usage Instructions
Adding an Expense: Enter the amount, select a category, and ensure the date follows the YYYY-MM-DD format (e.g., 2026-03-31). Click "Add Expense".

Generating a Report: Type the name of the month (e.g., "March") into the report field and click "Monthly Report".

Data Safety: All entries are saved instantly. You can close the app and reopen it to find your data intact.

Developer: Arnima Awasthi
Submission: VITyarthi BYOP Capstone Project 2026