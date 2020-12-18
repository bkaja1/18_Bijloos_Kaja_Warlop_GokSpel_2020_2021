package model.gokstrategies;

/**
 * @Author Niels Bijloos
 *
 */

public enum GokEnum {
    EVENSTRATEGY("het aantal ogen is bij elke worp een even getal", "model.gokstrategies.EvenStrategy", 4),
    SOMIS21STRATEGY("de som van de ogen van alle worpen is 21", "model.gokstrategies.SomIs21Strategy", 5),
    HOGERDANVORIGESTRATEGY("het aantal ogen is bij elke worp hoger dan bij de vorige worp", "model.gokstrategies.HogerDanVorigeStrategy", 10),
    HOGERDANEENSTRATEGY("het aantal ogen is bij elke worp hoger dan 1", "model.gokstrategies.HogerDanEenStrategy", 2),
    SOMISMINSTENS6STRATEGY("de som van alle worpen is minstens 6", "model.gokstrategies.SomIsMin6Strategy", 2);

    private final String omschrijving;
    private final String klasseNaam;
    private final int winstfactor;

    GokEnum(String omschrijving, String klasseNaam, int winstfactor) {
        this.omschrijving = omschrijving;
        this.klasseNaam = klasseNaam;
        this.winstfactor = winstfactor;
    }

    public String getOmschrijving() {
        return omschrijving;
    }

    public String getKlasseNaam() {
        return klasseNaam;
    }

    public int getWinstfactor() {
        return winstfactor;
    }
}
