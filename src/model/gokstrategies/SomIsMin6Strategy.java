package model.gokstrategies;

/**
 * @Author Niels Bijloos
 */

public class SomIsMin6Strategy  implements GokStrategy{
    private int som = 0;

    @Override
    public boolean evalueerGok(int worp) {
        som += worp;
        return som <= 6;
    }
}
