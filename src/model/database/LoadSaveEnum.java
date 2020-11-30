package model.database;

 public enum LoadSaveEnum {
     SPELERTEKST( "SpelerTekst", "database.SpelerTekstLoadSave"),
     SPELEREXCEL("SpelerExcel", "database.SpelerExcelLoadSaveStrategy");

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
