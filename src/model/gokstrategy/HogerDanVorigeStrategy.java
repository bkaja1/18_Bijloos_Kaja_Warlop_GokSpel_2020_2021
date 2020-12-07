package model.gokstrategy;

/**
 * @Author Sébastien Warlop
 *
 */

public class HogerDanVorigeStrategy implements VraagGokstrategy {
    private int vorige = 0;

    @Override
    public boolean heeftGewonnen(int worp) {
        if (worp  >  vorige) {
            vorige = worp;
            return true;
        } else {
            return false;
        }
    }
}
