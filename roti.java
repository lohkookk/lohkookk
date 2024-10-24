import java.util.*;
public class roti {
    public static void main(String[] args) {
        Scanner puj = new Scanner(System.in);

        System.out.println("SELAMAT DATANG DI TEDDY'S BAKERY");
        System.out.println("LIST ROTI:");
        System.out.println("1. Roti Tawar - Rp 10.000,00");
        System.out.println("2. Roti Gandum - Rp 12.000,00");
        System.out.println("3. Roti Coklat - Rp 15.000,00");
        System.out.println("0. Keluar");

        int back = 0;
        int burner = 0;

        while (true) {
            System.out.print("Pilih order dan masukkan jumlah:\n");
            int lonely = puj.nextInt();
            if (lonely > 3) {
                System.out.print("Pilihan tidak ada!\n");
            } else if (lonely == 0) {
                System.out.printf("Total belanja: Rp %d,00\n",burner);
                System.out.print("TERIMA KASIH TELAH BERBELANJA DI TEDDY'S BAKERY");
                return;
            } else {
                int alone = puj.nextInt();
                switch (lonely) {
                    case 1 : back = alone*10000;
                        break;
                    case 2 : back = alone*12000;
                        break;
                    case 3 : back = alone*15000;
                        break;
                }
                burner += back;
            }
        }
    }
}
