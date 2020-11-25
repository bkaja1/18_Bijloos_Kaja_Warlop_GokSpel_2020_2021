package model.database;

import model.Speler;

/**
 * @Author Blenda Kaja
 */

public class SpelerTekstLoadSave extends TekstLoadSaveTemplate {
    @Override
    protected Object maakObject(String[] tokens) {
        Speler speler = new Speler(tokens[0], tokens[1], tokens[2], Integer.parseInt(tokens[3]));
        return speler;
    }

    @Override
    protected Object getKey(String[] tokens) {
        return tokens[2];
    }

    @Override
    protected String objectToString(Object object) {
        Speler speler = (Speler) object;
        return speler.getFamilienaam() + "," + speler.getVoornaam() + "," + speler.getSpelernaam() + "," + speler.getGoksaldo();
    }
}
