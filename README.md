#  College Student Finance Tracker 

A custom Java Desktop Application built to help students manage their daily expenses with a focus on college life.

##  Key Features
- **Rupee (₹) Support:** Tailored for Indian students.
- **Categorized Spending:** Track Mess/Canteen, Hostel, Stationary, and Social life.
- **Monthly Filtering:** View specific reports for any month of the year.
- **Modern UI:** Blue theme and better UX.
- **Data Persistence:** Saves all data to `expenses.txt` automatically.

### Technical Flow
1. **Data Entry:** User inputs price, date, and category via the Swing GUI.
2. **Validation:** The app checks for valid number formats and date strings (`YYYY-MM-DD`).
3. **Storage:** The `Expense` object is added to an `ArrayList` and simultaneously written to `expenses.txt`.
4. **Analysis:** The "Monthly Report" button triggers a stream-like filter that calculates totals based on the `LocalDate` month value.

##  Tech Stack & Concepts
- **Language:** Java
- **Library:** Java Swing (GUI)
- **OOP:** Encapsulation and Data Modeling (Expense class).
- **File I/O:** Scanner and PrintWriter for local storage.

##  How to Run
1. Ensure you have **JDK** installed.
2. Compile the project:
   ```bash
   javac Expense.java FinanceTracker.java