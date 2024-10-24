import java.io.*;
import java.util.*;

class Activity {
    String name;
    String description;
    String date;
    String time;

    Activity(String name, String description, String date, String time) {
        this.name = name;
        this.description = description;
        this.date = date;
        this.time = time;
    }

    @Override
    public String toString() {
        return "Kegiatan: " + name + "\nDeskripsi: " + description + "\nTanggal: " + date + "\nWaktu: " + time;
    }
}

public class ActivityScheduler {
    private List<Activity> activities = new ArrayList<>();

    public static void main(String[] args) {
        ActivityScheduler scheduler = new ActivityScheduler();
        scheduler.loadData();
        scheduler.displayMenu();
    }

    private void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        String choice;

        do {
            System.out.println("\n--- Sistem Penjadwalan Kegiatan ---");
            System.out.println("1. Tambah Kegiatan");
            System.out.println("2. Tampilkan Kegiatan");
            System.out.println("3. Simpan Data");
            System.out.println("4. Muat Data");
            System.out.println("5. Keluar");
            System.out.print("Pilih opsi: \n");
            choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addActivity(scanner);
                    break;
                case "2":
                    displayActivities();
                    break;
                case "3":
                    saveData();
                    break;
                case "4":
                    loadData();
                    break;
                case "5":
                    System.out.println("Keluar dari aplikasi.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (!choice.equals("5"));

        scanner.close();
    }

    private void addActivity(Scanner scanner) {
        System.out.print("Masukkan nama kegiatan: ");
        String name = scanner.nextLine();
        System.out.print("Masukkan deskripsi: ");
        String description = scanner.nextLine();
        System.out.print("Masukkan tanggal (DD/MM/YYYY): ");
        String date = scanner.nextLine();
        System.out.print("Masukkan waktu (HH:MM): ");
        String time = scanner.nextLine();

        activities.add(new Activity(name, description, date, time));
        System.out.println("Kegiatan ditambahkan.");
    }

    private void displayActivities() {
        System.out.println("\n--- Daftar Kegiatan ---");
        for (Activity activity : activities) {
            System.out.println(activity);
            System.out.println("--------------------------------");
        }
    }

    private void saveData() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("activities.txt"))) {
            for (Activity activity : activities) {
                writer.println(activity.name + "|" + activity.description + "|" + activity.date + "|" + activity.time);
            }
            System.out.println("Data berhasil disimpan.");
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat menyimpan data.");
        }
    }

    private void loadData() {
        File file = new File("activities.txt");
        if (!file.exists()) {
            System.out.println("File data tidak ditemukan, memulai dengan data kosong.");
            return;
        }

        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNextLine()) {
                String[] parts = fileScanner.nextLine().split("\\|");
                if (parts.length == 4) {
                    activities.add(new Activity(parts[0], parts[1], parts[2], parts[3]));
                }
            }
            System.out.println("Data berhasil dimuat.");
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat memuat data.");
        }
    }
}
