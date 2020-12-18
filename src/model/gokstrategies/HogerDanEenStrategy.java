package model.gokstrategies;

/**
 * @Author Niels Bijloos
 */

public class HogerDanEenStrategy implements GokStrategy{
    @Override
    public boolean evalueerGok(int worp) {
        return worp > 1;
    }
}
