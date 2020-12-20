package model.gokstrategies;

/**
 * @Author Niels Bijloos
 */

public class HogerDanEenStrategy implements GokStrategy {
    private String omschrijving = "de som van de ogen van alle worpen is 21";
    private int gekozen = 0;
    private int gewonnen = 0;
    private int inzet = 0;
    private int bedrag = 0;

    @Override
    public boolean evalueerGok(int i) {
        return i > 1;
    }

    @Override
    public void addGekozen() {
        gekozen++;
    }

    @Override
    public void addGewonnen() {
        gewonnen++;
    }

    @Override
    public void addInzet(int i) {
        inzet += i;
    }

    @Override
    public void addBedrag(int i) {
        bedrag += i;
    }

    @Override
    public String getOmschrijving() {
        return omschrijving;
    }

    @Override
    public int getGekozen() {
        return gekozen;
    }

    @Override
    public int getGewonnen() {
        return gewonnen;
    }

    @Override
    public int getInzet() {
        return inzet;
    }

    @Override
    public int getBedrag() {
        return bedrag;
    }
}
