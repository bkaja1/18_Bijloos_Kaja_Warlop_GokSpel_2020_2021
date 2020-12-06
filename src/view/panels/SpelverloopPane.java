package view.panels;

import controller.SpelverloopController;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import model.Spel;

public class SpelverloopPane extends GridPane {
    private Label spelverloop = new Label();
    public SpelverloopPane(SpelverloopController controller) {
        controller.setView(this);

        this.setPadding(new Insets(5, 5, 5, 5));
        this.setVgap(5);
        this.setHgap(5);

        this.add(new Label("Spelerverloop:"), 0, 0, 1, 1);
        this.add(spelverloop, 0, 1, 1, 1);
    }

    public void display(Spel spel) {
        spelverloop.setText("Dit is spel " + spel.getNummer() + " van de huidige sessie" +
                "\nDe huidige speler is " + spel.getVoornaam() + " " + spel.getFamilienaam() + " –  Spelernaam: " + spel.getSpelernaam() +
                "\nInzet: " + spel.getInzet() + " €"
        );
    }
}
