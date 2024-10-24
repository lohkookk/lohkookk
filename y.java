import java.util.*;
public class y {
    public static void main(String[] args) {
        
    
Scanner dobbu = new Scanner(System.in);

        String beg = dobbu.next().toLowerCase();
        if (!beg.equalsIgnoreCase("power")) {
            System.out.println("TV OFF");
            dobbu.close();
            return;
        } else {
            System.out.println("TV ON");
        }

        int uhuy = 1, vod = 50;

        while (true) {
            String fir = dobbu.next().toLowerCase();
            if (fir.equalsIgnoreCase("channel")) {
                String sec = dobbu.next().toLowerCase();
                if (sec.equalsIgnoreCase("up")) {
                    uhuy++;
                    if (uhuy < 1 || uhuy > 30) {
                        System.out.println("Channel tidak valid");
                    } else {
                        System.out.printf("Channel sekarang: %d\n",uhuy);
                    }
                } else if (sec.equalsIgnoreCase("down")) {
                    uhuy--;
                    if (uhuy < 1 || uhuy > 30) {
                        System.out.println("Channel tidak valid");
                        uhuy++;
                    } else {
                        System.out.printf("Channel sekarang: %d\n",uhuy);
                    }
                } else {
                    int cha = Integer.parseInt(sec);
                    if (cha < 1 || cha > 30) {
                        System.out.println("Channel tidak valid");
                    } else {
                        System.out.printf("Channel sekarang: %d\n",cha);
                    }
                }
            } else if (fir.equalsIgnoreCase("volume")) {
                String sec = dobbu.next().toLowerCase();
                if (sec.equalsIgnoreCase("up")) {
                    vod += 5;
                    if (vod < 1 || vod > 100) {
                        System.out.println("Volume tidak valid");
                    } else {
                        System.out.printf("Volume sekarang: %d\n",vod);
                    }    
                } else if (sec.equalsIgnoreCase("down")) {
                    vod -= 5;
                    if (vod < 1 || vod > 100) {
                        System.out.println("Volume tidak valid");
                    } else {
                        System.out.printf("Volume sekarang: %d\n",vod);
                    }    
                }
            } else if (fir.equalsIgnoreCase("prev")) {
                String sec = dobbu.next().toLowerCase();
                if (sec.equalsIgnoreCase("channel")) {
                    System.out.printf("Channel sekarang: %d\n",uhuy);
                }
            } else if (fir.equalsIgnoreCase("mute")) {
                System.out.printf("Volume mute\n");
            } else if (fir.equalsIgnoreCase("unmute")) {
                System.out.printf("Volume sekarang: %d\n",vod);
            } else if (fir.equalsIgnoreCase("power")) {
                System.out.println("TV OFF");
                dobbu.close();
                return;
            }
        }
    }
}