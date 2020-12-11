package model.gokstrategies;

/**
 * @Author Niels Bijloos
 */

public class HogerDanEenStrategy implements GokStrategy{
    @Override
    public boolean heeftGewonnen(int worp) {
        return worp > 1;
    }
}
