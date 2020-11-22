package model.database;

import model.Speler;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TekstLoadSaveSpeler {
    public Map<String, Speler> load() {
        Map<String, Speler> spelers = new HashMap<>();
        try {
            Scanner scanner = new Scanner(new File("src/bestanden/speler.txt"));
            while (scanner.hasNextLine()) {
                Scanner scannerLine = new Scanner(scanner.nextLine());
                scannerLine.useDelimiter(",");
                String naam = scannerLine.next();
                String voornaam = scannerLine.next();
                String spelersnaam = scannerLine.next();
                int saldo = Integer.parseInt(scannerLine.next());
                Speler speler = new Speler(naam, voornaam, spelersnaam, saldo);
                spelers.put(spelersnaam, speler);
                scannerLine.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return spelers;
    }

    public void save(Speler speler) {
        try {
            PrintWriter printWriter = new PrintWriter(new FileWriter("src/bestanden/speler.txt", true));
            printWriter.println(speler.getNaam() + "," + speler.getVoornaam() + "," + speler.getSpelersnaam() + ","
                    + speler.getSaldo());
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
