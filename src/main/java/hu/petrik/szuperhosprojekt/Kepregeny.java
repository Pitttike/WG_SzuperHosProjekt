package hu.petrik.szuperhosprojekt;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Kepregeny {
    public static List<Szuperhos> szuperhosLista = new ArrayList<>();

    public static void szereplok(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                String nev = parts[0];
                int kutyuSzam = Integer.parseInt(parts[1]);

                Szuperhos szuperhos;
                if (nev.equals("Vasember")) {
                    szuperhos = new Vasember();
                } else if (nev.equals("Batman")) {
                    szuperhos = new Batman();
                } else {
                    continue;
                }

                if (szuperhos instanceof Milliardos) {
                    Milliardos milliardos = (Milliardos) szuperhos;
                    for (int i = 0; i < kutyuSzam; i++) {
                        milliardos.kutyutKeszit();
                    }
                }

                szuperhosLista.add(szuperhos);
            }
        } catch (IOException e) {
            System.err.println("Hiba történt a fájl olvasása közben: " + e.getMessage());
        }
    }

    public static void szuperhosok() {
        for (Szuperhos szuperhos : szuperhosLista) {
            System.out.println(szuperhos);
        }
    }


}
