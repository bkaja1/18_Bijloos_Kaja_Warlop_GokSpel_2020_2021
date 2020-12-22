package model.gokstrategies;

/**
 * @Author Niels Bijloos
 *
 */

public enum GokEnum {
    EVENSTRATEGY("het aantal ogen is bij elke worp een even getal", "model.gokstrategies.EvenStrategy"),
    SOMIS21STRATEGY("de som van de ogen van alle worpen is 21", "model.gokstrategies.SomIs21Strategy"),
    HOGERDANVORIGESTRATEGY("het aantal ogen is bij elke worp hoger dan bij de vorige worp", "model.gokstrategies.HogerDanVorigeStrategy"),
    HOGERDANEENSTRATEGY("het aantal ogen is bij elke worp hoger dan 1", "model.gokstrategies.HogerDanEenStrategy"),
    SOMISMINSTENS6STRATEGY("de som van alle worpen is minstens 6", "model.gokstrategies.SomIsMin6Strategy");

    private final String omschrijving;
    private final String klasseNaam;

    GokEnum(String omschrijving, String klasseNaam) {
        this.omschrijving = omschrijving;
        this.klasseNaam = klasseNaam;
    }

    public String getOmschrijving() {
        return omschrijving;
    }

    public String getKlasseNaam() {
        return klasseNaam;
    }
}
