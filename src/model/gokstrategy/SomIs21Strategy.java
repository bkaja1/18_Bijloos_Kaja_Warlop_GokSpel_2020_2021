package model.gokstrategy;

/**
 * @Author Sébastien Warlop
 *
 */

public class SomIs21Strategy implements VraagGokstrategy{
    private int som = 0;

    @Override
    public boolean heeftGewonnen(int worp) {
        som += worp;
        if (som <= 21) {
            return true;
        } else {
            return false;
        }
    }

}
