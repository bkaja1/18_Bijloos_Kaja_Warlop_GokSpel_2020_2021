package model.gokstrategy;

/**
 * @Author Sébastien Warlop
 *
 */

public class GewonnenStrategy implements VraagGokstrategy {

    @Override
    public boolean heeftGewonnen(int worp) {
        if (worp % 2 == 0) return true;
        else return false;
    }
}
