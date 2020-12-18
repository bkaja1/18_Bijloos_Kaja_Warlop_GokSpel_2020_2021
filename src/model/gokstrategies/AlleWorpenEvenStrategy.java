package model.gokstrategies;

/**
 * @Author Sébastien Warlop
 *
 */

public class AlleWorpenEvenStrategy implements GokStrategy {

    @Override
    public boolean evalueerGok(int worp) {
        return worp % 2 == 0;
    }
}
