package model.gokstrategies;

/**
 * @Author Niels Bijloos
 *
 */

public interface GokStrategy {
    int getWinstfactor();
    void setWinstfactor(int i);
    boolean evalueerGok(int i);
    void addGekozen();
    void addGewonnen();
    void addInzet(int i);
    void addBedrag(int i);
    String getOmschrijving();
    int getGekozen();
    int getGewonnen();
    int getInzet();
    int getBedrag();
}
