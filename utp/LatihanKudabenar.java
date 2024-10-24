package utp;
import java.util.*;



public class LatihanKudabenar {
    public static void main(String[] args) {
        Scanner utp = new Scanner(System.in);

        // Input data kuda pertama
        String nama1 = utp.nextLine();
        int durasi1 = utp.nextInt();
        
        utp.nextLine(); // membersihkan newline

        // Input data kuda kedua

        String nama2 = utp.nextLine();
        int durasi2 = utp.nextInt();
        
        utp.nextLine(); // membersihkan newline

        // Input data kuda ketiga
        String nama3 = utp.nextLine();
        int durasi3 = utp.nextInt();

        // Menghitung kecepatan dalam km/jam
        double kecepatan1 = (2.4 / (durasi1 / 3600.0)); // jarak 2.4 km dan waktu dalam jam
        double kecepatan2 = (2.4 / (durasi2 / 3600.0)); // jarak 2.4 km dan waktu dalam jam
        double kecepatan3 = (2.4 / (durasi3 / 3600.0)); // jarak 2.4 km dan waktu dalam jam

        // Menentukan urutan tercepat
        String kudaTercepat1, kudaTercepat2, kudaTercepat3;
        double kecepatanTercepat1, kecepatanTercepat2, kecepatanTercepat3;

        if (kecepatan1 >= kecepatan2 && kecepatan1 >= kecepatan3) {
            kudaTercepat1 = nama1;
            kecepatanTercepat1 = kecepatan1;

            if (kecepatan2 >= kecepatan3) {
                kudaTercepat2 = nama2;
                kecepatanTercepat2 = kecepatan2;
                kudaTercepat3 = nama3;
                kecepatanTercepat3 = kecepatan3;
            } else {
                kudaTercepat2 = nama3;
                kecepatanTercepat2 = kecepatan3;
                kudaTercepat3 = nama2;
                kecepatanTercepat3 = kecepatan2;
            }
        } else if (kecepatan2 >= kecepatan1 && kecepatan2 >= kecepatan3) {
            kudaTercepat1 = nama2;
            kecepatanTercepat1 = kecepatan2;

            if (kecepatan1 >= kecepatan3) {
                kudaTercepat2 = nama1;
                kecepatanTercepat2 = kecepatan1;
                kudaTercepat3 = nama3;
                kecepatanTercepat3 = kecepatan3;
            } else {
                kudaTercepat2 = nama3;
                kecepatanTercepat2 = kecepatan3;
                kudaTercepat3 = nama1;
                kecepatanTercepat3 = kecepatan1;
            }
        } else {
            kudaTercepat1 = nama3;
            kecepatanTercepat1 = kecepatan3;

            if (kecepatan1 >= kecepatan2) {
                kudaTercepat2 = nama1;
                kecepatanTercepat2 = kecepatan1;
                kudaTercepat3 = nama2;
                kecepatanTercepat3 = kecepatan2;
            } else {
                kudaTercepat2 = nama2;
                kecepatanTercepat2 = kecepatan2;
                kudaTercepat3 = nama1;
                kecepatanTercepat3 = kecepatan1;
            }
        }

        // Menampilkan hasil
        System.out.printf("Kuda tercepat pertama adalah %s dengan kecepatan %.2f km/jam%n", kudaTercepat1, Math.round(kecepatanTercepat1 * 100.0) / 100.0);
        System.out.printf("Kuda tercepat kedua adalah %s dengan kecepatan %.2f km/jam%n", kudaTercepat2, Math.round(kecepatanTercepat2 * 100.0) / 100.0);
        System.out.printf("Kuda tercepat ketiga adalah %s dengan kecepatan %.2f km/jam%n", kudaTercepat3, Math.round(kecepatanTercepat3 * 100.0) / 100.0);

        utp.close();
    }
}


