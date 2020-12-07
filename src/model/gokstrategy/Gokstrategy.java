package model.gokstrategy;

/**
 * @Author Niels Bijloos
 *
 */

public enum Gokstrategy {
    ALLEWORPENEVENSTRATEGY("mogelijke winst is 4 x je inzet", "AlleWorpenEvenStrategy", 4),
    TOTALESOMIS21STRATEGY("mogelijke winst is 5 x je inzet", "TotaleSom21Strategy", 5),
    STEEDSHOGERDANVORIGESTRATEGY("mogelijke winst is 10 x je inzet", "SteedsHogerDanVorigeStrategy", 10);

    private final String beschrijving;
    private final String strategyKlasse;
    private final int opbrengst;

    Gokstrategy(String beschrijving, String strategyKlasse, int opbrengst) {
        this.beschrijving = beschrijving;
        this.strategyKlasse = strategyKlasse;
        this.opbrengst = opbrengst;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public String getStrategyKlasse() {
        return strategyKlasse;
    }

    public int getOpbrengst() {
        return opbrengst;
    }
}
