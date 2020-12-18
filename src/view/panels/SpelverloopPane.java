package view.panels;

import controller.SpelverloopController;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import model.Spel;

import java.util.Arrays;

/**
 * @Author Blenda Kaja
 */

public class SpelverloopPane extends GridPane {
    private Label nummer = new Label();
    private Label speler = new Label();
    private Label inzet = new Label();
    private Label gokStrategy = new Label();
    private Label worpen = new Label();
    private Label gewonnen = new Label();
    private Label goksaldo = new Label();
    public SpelverloopPane(SpelverloopController controller) {
        controller.setView(this);

        this.setPadding(new Insets(5, 5, 5, 5));
        this.setVgap(5);
        this.setHgap(5);

        this.add(new Label("Spelerverloop:"), 0, 0, 1, 1);
        this.add(nummer, 0, 1, 1, 1);
        this.add(speler, 0, 2, 1, 1);
        this.add(inzet, 0, 3, 1, 1);
        this.add(gokStrategy, 0, 4, 1, 1);
        this.add(worpen, 0, 5, 1, 1);
        this.add(gewonnen, 0, 6, 1, 1);
        this.add(goksaldo, 0, 7, 1, 1);
    }

    public void display(Spel spel) {
        nummer.setText("");
        speler.setText("");
        inzet.setText("");
        gokStrategy.setText("");
        worpen.setText("");
        gewonnen.setText("");
        if(spel.getInzet() != 0) {
            nummer.setText("Dit is spel " + spel.getNummer() + " van de huidige sessie");
            speler.setText("De huidige speler is " + spel.getVoornaam() + " " + spel.getFamilienaam() + " –  Spelernaam: " + spel.getSpelernaam());
            inzet.setText("Inzet: " + spel.getInzet() + " €");
        }
        if(spel.getGokStrategy() != null) {
            gokStrategy.setText("De gekozen gokstrategie is: " + spel.getGokOmschrijving());
        }
    }

    public void displayGewonnen(Spel spel) {
        worpen.setText("De worpen van " + spel.getSpelernaam() + ":" + spel.getWorpenToString());
        gewonnen.setText(spel.getSpelernaam() + " heeft " + (spel.isGewonnen()?"":"NIET ") + "gewonnen");
        goksaldo.setText("Nieuwe goksaldo: " + spel.getGoksaldo() + " €");
    }
}
