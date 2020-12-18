package model.gokstrategies;

/**
 * @Author Niels Bijloos
 */

public class SomIsMin6Strategy  implements GokStrategy{
    private int som = 0;

    @Override
    public boolean evalueerGok(int i) {
        som += i;
        return som <= 6;
    }
}
