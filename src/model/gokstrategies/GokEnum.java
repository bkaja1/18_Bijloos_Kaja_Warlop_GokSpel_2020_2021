package model.gokstrategies;

/**
 * @Author Niels Bijloos
 *
 */

public enum GokEnum {
    ALLEWORPENEVENSTRATEGY("het aantal ogen is bij elke worp een even getal", "model.gokstrategies.AlleWorpenEvenStrategy", 4),
    SOMIS21STRATEGY("de som van de ogen van alle worpen is 21", "model.gokstrategies.SomIs21Strategy", 5),
    HOGERDANVORIGESTRATEGY("het aantal ogen is bij elke worp hoger dan bij de vorige worp", "model.gokstrategies.HogerDanVorigeStrategy", 10);

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
