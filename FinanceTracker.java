import java.awt.*;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class FinanceTracker extends JFrame {
    private JTextField amountField, dateField;
    private JComboBox<String> categoryBox, viewMonthBox;
    private JTable table;
    private DefaultTableModel tableModel;
    private JLabel totalLabel;
    private ArrayList<Expense> expenseList = new ArrayList<>();

    // Color Palette
    Color lightBlueBG = new Color(235, 245, 255);
    Color headerBlue = new Color(52, 152, 219);
    Color successGreen = new Color(46, 204, 113);
    Color dangerRed = new Color(231, 76, 60);

    public FinanceTracker() {
        setTitle("College Student Finance Tracker");
        setSize(850, 550);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center on screen
        setLayout(new BorderLayout());
        getContentPane().setBackground(lightBlueBG);

        // --- TOP INPUT PANEL ---
        JPanel inputPanel = new JPanel();
        inputPanel.setBackground(lightBlueBG);
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        dateField = new JTextField(LocalDate.now().toString(), 8);
        amountField = new JTextField(6);
        
        String[] categories = {"Mess/Canteen", "Hostel/Rent", "Stationary", "Social/Friends", "Travel", "Misc"};
        categoryBox = new JComboBox<>(categories);

        JButton addButton = new JButton("Add Expense");
        JButton deleteButton = new JButton("Delete");
        
        styleButton(addButton, successGreen);
        styleButton(deleteButton, dangerRed);

        inputPanel.add(new JLabel("Date:"));
        inputPanel.add(dateField);
        inputPanel.add(new JLabel("Amount:"));
        inputPanel.add(amountField);
        inputPanel.add(new JLabel("Category:"));
        inputPanel.add(categoryBox);
        inputPanel.add(addButton);
        inputPanel.add(deleteButton);

        // --- MIDDLE TABLE PANEL ---
        String[] columns = {"Date", "Amount (₹)", "Category"};
        tableModel = new DefaultTableModel(columns, 0);
        table = new JTable(tableModel);
        table.setRowHeight(30);
        table.getTableHeader().setBackground(headerBlue);
        table.getTableHeader().setForeground(Color.WHITE);
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));
        table.setSelectionBackground(new Color(174, 214, 241));

        // --- BOTTOM SUMMARY PANEL ---
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        bottomPanel.setBackground(lightBlueBG);
        
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        viewMonthBox = new JComboBox<>(months);
        viewMonthBox.setSelectedIndex(LocalDate.now().getMonthValue() - 1);

        JButton summaryButton = new JButton("Monthly Report");
        styleButton(summaryButton, headerBlue);

        totalLabel = new JLabel("Total Spent: ₹0.00");
        totalLabel.setFont(new Font("Arial", Font.BOLD, 16));
        totalLabel.setBorder(BorderFactory.createEmptyBorder(0, 50, 0, 10));

        bottomPanel.add(new JLabel("View:"));
        bottomPanel.add(viewMonthBox);
        bottomPanel.add(summaryButton);
        bottomPanel.add(totalLabel);

        // --- LOGIC / LISTENERS ---
        addButton.addActionListener(e -> {
            try {
                double amt = Double.parseDouble(amountField.getText());
                LocalDate date = LocalDate.parse(dateField.getText());
                String cat = (String) categoryBox.getSelectedItem();

                Expense exp = new Expense(amt, cat, date);
                expenseList.add(exp);
                tableModel.addRow(new Object[]{date, amt, cat});
                
                calculateTotal();
                saveToFile();
                amountField.setText("");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Use YYYY-MM-DD for date!");
            }
        });

        deleteButton.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row != -1) {
                expenseList.remove(row);
                tableModel.removeRow(row);
                calculateTotal();
                saveToFile();
            }
        });

        summaryButton.addActionListener(e -> {
            int month = viewMonthBox.getSelectedIndex() + 1;
            double mTotal = 0;
            for (Expense ex : expenseList) {
                if (ex.getDate().getMonthValue() == month) mTotal += ex.getAmount();
            }
            JOptionPane.showMessageDialog(this, "Total for " + viewMonthBox.getSelectedItem() + ": ₹" + String.format("%.2f", mTotal));
        });

        // Assemble
        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        loadFromFile();
    }

    private void styleButton(JButton btn, Color color) {
        btn.setBackground(color);
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setFont(new Font("Arial", Font.BOLD, 12));
        btn.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(color.darker(), 1, true),
            BorderFactory.createEmptyBorder(5, 15, 5, 15)
        ));
    }

    private void calculateTotal() {
        double sum = 0;
        for (Expense e : expenseList) sum += e.getAmount();
        totalLabel.setText("Total Spent: ₹" + String.format("%.2f", sum));
    }

    private void saveToFile() {
        try (PrintWriter pw = new PrintWriter(new FileWriter("expenses.txt"))) {
            for (Expense e : expenseList) pw.println(e.getDate() + "," + e.getAmount() + "," + e.getCategory());
        } catch (IOException e) { e.printStackTrace(); }
    }

    private void loadFromFile() {
        File f = new File("expenses.txt");
        if (!f.exists()) return;
        try (Scanner sc = new Scanner(f)) {
            while (sc.hasNextLine()) {
                String[] p = sc.nextLine().split(",");
                if (p.length == 3) {
                    Expense e = new Expense(Double.parseDouble(p[1]), p[2], LocalDate.parse(p[0]));
                    expenseList.add(e);
                    tableModel.addRow(new Object[]{e.getDate(), e.getAmount(), e.getCategory()});
                }
            }
            calculateTotal();
        } catch (Exception e) { System.out.println("New data file created."); }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FinanceTracker().setVisible(true));
    }
}