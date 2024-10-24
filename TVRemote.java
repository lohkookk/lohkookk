import java.util.*;


public class TVRemote {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command;
        boolean isOn = false;
        int currentChannel = 1;
        int volume = 50;
        boolean isMuted = false;
        int previousChannel = 1;

        while (true) {
            command = scanner.nextLine().toUpperCase();

            if (command.equals("POWER")) {
                if (!isOn) {
                    isOn = true;
                    currentChannel = 1;
                    volume = 50;
                    System.out.println("TV ON");
                } else {
                    isOn = false;
                    System.out.println("TV OFF");
                    break; // Exit the loop when TV is turned off
                }
            } else if (isOn) {
                switch (command) {
                    case "CHANNEL UP":
                        if (currentChannel < 30) {
                            previousChannel = currentChannel;
                            currentChannel++;
                            System.out.println("Channel sekarang: " + currentChannel);
                        } else {
                            System.out.println("Channel tidak valid");
                        }
                        break;
                    case "CHANNEL DOWN":
                        if (currentChannel > 1) {
                            previousChannel = currentChannel;
                            currentChannel--;
                            System.out.println("Channel sekarang: " + currentChannel);
                        } else {
                            System.out.println("Channel tidak valid");
                        }
                        break;
                    case "PREV CHANNEL":
                        int tempChannel = currentChannel;
                        currentChannel = previousChannel;
                        previousChannel = tempChannel;
                        System.out.println("Channel sekarang: " + currentChannel);
                        break;
                    case "VOLUME UP":
                        if (!isMuted) {
                            volume += 5;
                            if (volume > 100) {
                                volume = 100;
                                System.out.println("Volume tidak valid");
                            } else {
                                System.out.println("Volume sekarang: " + volume);
                            }
                        }
                        break;
                    case "VOLUME DOWN":
                        if (!isMuted) {
                            volume -= 5;
                            if (volume < 0) {
                                volume = 0;
                                System.out.println("Volume tidak valid");
                            } else {
                                System.out.println("Volume sekarang: " + volume);
                            }
                        }
                        break;
                    case "MUTE":
                        isMuted = true;
                        System.out.println("Volume mute");
                        break;
                        
                    case "UNMUTE":
                        if (isMuted) {
                            isMuted = false;
                            System.out.println("Volume sekarang: " + volume);
                        }
                        break;
                    default:
                        if (command.startsWith("CHANNEL ")) {
                            try {
                                int newChannel = Integer.parseInt(command.split(" ")[1]);
                                if (newChannel >= 1 && newChannel <= 30) {
                                    previousChannel = currentChannel;
                                    currentChannel = newChannel;
                                    System.out.println("Channel sekarang: " + currentChannel);
                                } else {
                                    System.out.println("Channel yang dimasukkan tidak valid");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Channel yang dimasukkan tidak valid");
                            }
                        }
                        break;
                }
            } else {
                System.out.println("TV OFF, tidak bisa menerima perintah");
            }
        }

        scanner.close();
    }
}
