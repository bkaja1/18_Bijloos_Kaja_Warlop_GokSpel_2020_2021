package model.gokstrategies;

/**
 * @Author Sébastien Warlop
 *
 */

public class HogerDanVorigeStrategy implements GokStrategy {
    private int vorige = 0;
    private String omschrijving = "het aantal ogen is bij elke worp hoger dan bij de vorige worp";
    private int gekozen = 0;
    private int gewonnen = 0;
    private int inzet = 0;
    private int bedrag = 0;

    @Override
    public boolean evalueerGok(int i) {
        if (i > vorige) {
            vorige = i;
            return true;
        } else {
            return false;
        }
    }
}
