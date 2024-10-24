import java.util.*;
public class test {
    public static void main(String[] args) {
        
    
    Scanner puj = new Scanner(System.in);

        int ticket = 0;
        int rawr = 0;
        int disc = 0;
        int kiw = 0;
        int batas = 0;

        while (true) {
            int inc = puj.nextInt();

            for (int i = 1; i <= inc; i++) {
                int tin = puj.nextInt();

                if (tin < 4) {
                    batas = rawr;
                } else if (tin < 7) {
                    rawr = tin*50000;
                    disc = 5*rawr/100;
                    kiw += disc;
                } else {
                    rawr = tin*50000;
                    disc = 10*rawr/100;
                    kiw += disc;
                }
              
                ticket += tin;

                rawr = ticket*50000;

                batas = rawr - kiw;

                if (i == inc) {
                    System.out.printf("Total transaksi: %d\n",inc);
                    System.out.printf("Total tiket terjual: %d\n",ticket);
                    System.out.printf("Total pendapatan: Rp %d\n",rawr);
                    System.out.printf("Total diskon: Rp %d\n",kiw);
                    System.out.printf("Pendapatan bersih: Rp %d\n",batas);            
                }
            }
            
            return;
        }
    }
}
