import java.io.*;
import java.util.*;

public class utp2 {

    public static void main(String[] args) {
        Scanner utpGacor = new Scanner(System.in);

        String email = utpGacor.next();
        String emailbaru = utpGacor.next();
        String domainn = utpGacor.next();
        double Harga = utpGacor.nextDouble();

        int lastdot = 0;

        for (int i = 0; i < email.length() - 1; i++) {
            if (email.charAt(i) == '.') {
                lastdot = i;
            }
        }

        String akhirDomain = email.substring(lastdot, email.length());

        String newakhirDomain = "";
        double hargaFinal = Harga;

        if (akhirDomain.equals(".com")) {
            newakhirDomain = ".com";
            hargaFinal += Harga * 0.50;
        } else if (akhirDomain.equals(".id")) {
            newakhirDomain = ".id";
            hargaFinal += Harga * 0.75;
        } else if (akhirDomain.equals(".net")) {
            newakhirDomain = ".net";
            hargaFinal += Harga * 0.25;
        } else {
            newakhirDomain = "." + akhirDomain;
        }

        String lastEmail = emailbaru + "@" + domainn + newakhirDomain;
        String fullnamaDomain = domainn + newakhirDomain;

        System.out.printf("Nama email baru: %s\n", lastEmail);
        System.out.printf("Nama domain untuk Elon: %s\n", fullnamaDomain);
        System.out.printf("Total harga pembelian: %.2f$\n", hargaFinal);

        utpGacor.close();
    }
}