package model.gokstrategies;

/**
 * @Author Niels Bijloos
 */

public class HogerDanEenStrategy implements GokStrategy{
    @Override
    public boolean evalueerGok(int i) {
        return i > 1;
    }
}
