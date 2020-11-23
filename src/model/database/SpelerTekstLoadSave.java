package model.database;

import model.Speler;

import java.io.*;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author Blenda Kaja
 */

public class SpelerTekstLoadSave extends TekstLoadSaveTemplate {
    public SpelerTekstLoadSave() {
        super("src/bestanden/speler.txt");
    }

    @Override
    protected void scan(Scanner scannerNextLine, Map<String, Object> objects) {
        scannerNextLine.useDelimiter(",");
        String familienaam = scannerNextLine.next();
        String voornaam = scannerNextLine.next();
        String spelernaam = scannerNextLine.next();
        int goksaldo = Integer.parseInt(scannerNextLine.next());
        Speler speler = new Speler(familienaam, voornaam, spelernaam, goksaldo);
        objects.put(spelernaam, speler);
    }

    @Override
    protected void println(PrintWriter printWriter, Object object) {
        Speler speler = (Speler)object;
        printWriter.println(speler.getFamilienaam() + "," + speler.getVoornaam() + "," + speler.getSpelernaam() + ","
                + speler.getGoksaldo());
    }
}
