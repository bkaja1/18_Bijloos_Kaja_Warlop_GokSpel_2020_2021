package model.gokstrategies;

/**
 * @Author Sébastien Warlop
 *          Niels Bijloos
 *
 */

public class SomIs21Strategy implements GokStrategy {
    private int aantal = 0;
    private int som = 0;

    @Override
    public boolean evalueerGok(int i) {
        aantal++;
        som += i;

        if(aantal == 4) {
            return som == 21;
        } else return true;
    }
}
