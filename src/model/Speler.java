package model;

/**
 * @Author Niels Bijloos
 *
 */

public class Speler implements Comparable<Speler> {
    private String familienaam, voornaam, spelernaam;
    private int goksaldo;
    private int inzet;

    public Speler(String familienaam, String voornaam, String spelernaam, int goksaldo) {
        setFamilienaam(familienaam);
        setVoornaam(voornaam);
        setSpelernaam(spelernaam);
        setGoksaldo(goksaldo);
    }

    public String getFamilienaam() {
        return familienaam;
    }

    public void setFamilienaam(String familienaam) {
        if(familienaam == null || familienaam.trim().isEmpty()) throw new IllegalArgumentException("Familienaam mag niet leeg zijn");
        this.familienaam = familienaam;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        if(voornaam == null || voornaam.trim().isEmpty()) throw new IllegalArgumentException("Voornaam mag niet leeg zijn");
        this.voornaam = voornaam;
    }

    public String getSpelernaam() {
        return spelernaam;
    }

    public void setSpelernaam(String spelernaam) {
        if(spelernaam == null || spelernaam.trim().isEmpty()) throw new IllegalArgumentException("Spelernaam mag niet leeg zijn");
        this.spelernaam = spelernaam;
    }

    public int getGoksaldo() {
        return goksaldo;
    }

    public void setGoksaldo(int goksaldo) {
        if(goksaldo < 0) throw new IllegalArgumentException("Goksaldo kan niet negatief zijn");
        this.goksaldo = goksaldo;
    }

    public int getInzet() {
        return inzet;
    }

    public void setInzet(int inzet) {
        if(inzet < 0) throw new IllegalArgumentException("Inzet kan niet negatief zijn");
        if(inzet == 0) throw new IllegalArgumentException("Inzet kan niet 0 zijn");
        if(inzet > goksaldo) throw new IllegalArgumentException("Inzet kan niet groter zijn dan goksaldo");
        this.inzet = inzet;
    }

    @Override
    public int compareTo(Speler o) {
        return this.getSpelernaam().compareTo(o.getSpelernaam());
    }
}
