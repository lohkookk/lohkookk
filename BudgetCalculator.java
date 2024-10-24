import java.io.*;
import java.util.Scanner;

class Transaction {
    String type; // "income" or "expense"
    double amount;
    String category; // for expenses only
    String name; // name of the expense
    String description;

    public Transaction(String type, double amount, String category, String name, String description) {
        this.type = type;
        this.amount = amount;
        this.category = category;
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        if (type.equals("income")) {
            return type + "," + amount + "," + description;
        } else {
            return type + "," + amount + "," + category + "," + name + "," + description;
        }
    }
}

public class BudgetCalculator {
    static final String DATA_FILE = "budget_data.txt";

    public static void main(String[] args) {
        BudgetCalculator app = new BudgetCalculator();
        app.showMenu();
    }

    void showMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n_________________________________\n=== Kalkulator Budget Pribadi ===");
            System.out.println("1. Tambah Pemasukan");
            System.out.println("2. Tambah Pengeluaran");
            System.out.println("3. Lihat Ringkasan Anggaran");
            System.out.println("4. Keluar");
            System.out.print("Pilih opsi: \n________________________________\n");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (choice) {
                case 1:
                    addTransaction("income", scanner);
                    break;
                case 2:
                    addTransaction("expense", scanner);
                    break;
                case 3:
                    displaySummary();
                    break;
                case 4:
                    System.out.println("Keluar dari aplikasi.");
                    return;
                default:
                    System.out.println("Opsi tidak valid. Silakan coba lagi.");
            }
        }
    }

    void addTransaction(String type, Scanner scanner) {
        System.out.print("Masukkan jumlah: Rp.");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Clear buffer
        System.out.print("Masukkan deskripsi: ");
        String description = scanner.nextLine();
        String category = "";
        String name = "";

        if (type.equals("expense")) {
            System.out.print("Masukkan kategori: ");
            category = scanner.nextLine();
            System.out.print("Masukkan nama pengeluaran: ");
            name = scanner.nextLine();
        }

        Transaction transaction = new Transaction(type, amount, category, name, description);
        saveTransaction(transaction);
        System.out.println("Transaksi berhasil ditambahkan.");
    }

    void saveTransaction(Transaction transaction) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DATA_FILE, true))) {
            writer.write(transaction.toString());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Kesalahan saat menyimpan data.");
        }
    }

    void displaySummary() {
        double totalIncome = 0;
        double totalExpense = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(DATA_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String type = parts[0];
                double amount = Double.parseDouble(parts[1]);

                if (type.equals("income")) {
                    totalIncome += amount;
                } else {
                    totalExpense += amount;
                }
            }
        } catch (IOException e) {
            System.out.println("Kesalahan saat memuat data.");
        }

        System.out.println("\n=== Ringkasan Anggaran ===");
        System.out.printf("Total Pemasukan: %.2f\n", totalIncome);
        System.out.printf("Total Pengeluaran: %.2f\n", totalExpense);
        System.out.printf("Sisa Anggaran: %.2f\n", totalIncome - totalExpense);
    }
}
