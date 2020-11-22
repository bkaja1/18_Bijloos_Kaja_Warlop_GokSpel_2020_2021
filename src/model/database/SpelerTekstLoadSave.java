package model.database;

import model.Speler;

import java.io.*;
import java.util.Scanner;

/**
 * @Author Blenda Kaja
 */

public class SpelerTekstLoadSave extends TekstLoadSaveTemplate {
    public SpelerTekstLoadSave() {
        super("src/bestanden/speler.txt");
    }

    @Override
    protected void scan(Scanner scanner) {
        while (scanner.hasNextLine()) {
            Scanner scannerLine = new Scanner(scanner.nextLine());
            scannerLine.useDelimiter(",");
            String familienaam = scannerLine.next();
            String voornaam = scannerLine.next();
            String spelernaam = scannerLine.next();
            int goksaldo = Integer.parseInt(scannerLine.next());
            Speler speler = new Speler(familienaam, voornaam, spelernaam, goksaldo);
            objects.put(spelernaam, speler);
            scannerLine.close();
        }
    }

    @Override
    protected void println(PrintWriter printWriter, Object object) {
        Speler speler = (Speler)object;
        printWriter.println(speler.getFamilienaam() + "," + speler.getVoornaam() + "," + speler.getSpelernaam() + ","
                + speler.getGoksaldo());
        printWriter.close();
    }
}
