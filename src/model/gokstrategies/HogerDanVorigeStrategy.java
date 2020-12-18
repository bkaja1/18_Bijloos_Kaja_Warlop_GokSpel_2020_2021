package model.gokstrategies;

/**
 * @Author Sébastien Warlop
 *
 */

public class HogerDanVorigeStrategy implements GokStrategy {
    private int vorige = 0;

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
