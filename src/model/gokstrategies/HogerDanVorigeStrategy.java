package model.gokstrategies;

/**
 * @Author Sébastien Warlop
 *
 */

public class HogerDanVorigeStrategy implements GokStrategy {
    private int vorige = 0;

    @Override
    public boolean evalueerGok(int worp) {
        if (worp > vorige) {
            vorige = worp;
            return true;
        } else {
            return false;
        }
    }
}
