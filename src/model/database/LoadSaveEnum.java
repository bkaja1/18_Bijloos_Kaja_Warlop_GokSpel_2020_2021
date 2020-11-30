package model.database;

 public enum LoadSaveEnum {
     SPELERTEKST("SpelerTekst", "model.database.SpelerTekstLoadSaveStrategy"),
     SPELEREXCEL("SpelerExcel", "model.database.SpelerExcelLoadSaveStrategy");

     private final String omschrijving;
     private final String klasseNaam;

     LoadSaveEnum(String omschrijving, String klasseNaam) {
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
