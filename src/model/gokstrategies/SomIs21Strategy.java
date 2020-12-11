package model.gokstrategies;

/**
 * @Author Sébastien Warlop
 *          Niels Bijloos
 *
 */

public class SomIs21Strategy implements GokStrategy {
    private int som = 0;

    @Override
    public boolean heeftGewonnen(int worp) {
        som += worp;

        return som == 21;
    }

}
