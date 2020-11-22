package model;

/**
 * @Author Niels Bijloos
 *
 */

public class Speler {
    private String naam, voornaam, spelersnaam;
    private int saldo; // of double?

    public Speler(String naam, String voornaam, String spelersnaam, int saldo) {
        setNaam(naam);
        setVoornaam(voornaam);
        setSpelersnaam(spelersnaam);
        setSaldo(saldo);
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        if(naam.trim().isEmpty() || naam == null) throw new IllegalArgumentException("Naam mag niet leeg zijn");
        this.naam = naam;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        if(voornaam.trim().isEmpty() || voornaam == null) throw new IllegalArgumentException("Voornaam mag niet leeg zijn");
        this.voornaam = voornaam;
    }

    public String getSpelersnaam() {
        return spelersnaam;
    }

    public void setSpelersnaam(String spelersnaam) {
        if(spelersnaam.trim().isEmpty() || spelersnaam == null) throw new IllegalArgumentException("Spelersnaam mag niet leeg zijn");
        this.spelersnaam = spelersnaam;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        if(saldo < 0) throw new IllegalArgumentException("Saldo kan niet negatief zijn");
        this.saldo = saldo;
    }

    public void voegToeAanSaldo(int bedrag) {
        this.saldo += bedrag;
    }
}
