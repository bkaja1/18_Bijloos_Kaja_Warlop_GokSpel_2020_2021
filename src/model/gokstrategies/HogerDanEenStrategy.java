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
}
