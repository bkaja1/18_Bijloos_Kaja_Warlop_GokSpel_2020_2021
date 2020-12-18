package model.gokstrategies;

/**
 * @Author Sébastien Warlop
 *
 */

public class EvenStrategy implements GokStrategy {

    @Override
    public boolean evalueerGok(int i) {
        return i % 2 == 0;
    }
}
